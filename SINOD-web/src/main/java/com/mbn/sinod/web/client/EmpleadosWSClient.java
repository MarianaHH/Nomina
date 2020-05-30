/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.mbn.sinod.model.dto.EmpleadoDTO;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import com.mbn.sinod.web.util.ResourceBundles;
import com.mbn.sinod.web.util.StaticsConstants;
import com.mbn.sinod.web.util.TokenController;
import com.mbn.sinod.web.util.URIBuilder;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Cesar Jesús Gutiérrez Gutiérrez, MBN
 * @version 2.0
 * @since 15/12/2017 Clase que implementa clientes de los servicios web REST
 * expuestos en la capa de servicios
 */
public class EmpleadosWSClient {

    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(EmpleadosWSClient.class);

    public static List<Tsgrhempleados> listarEmpleados() {
        JSONObject json;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            //System.out.println("-->Empledos > Param: " + paramMap );
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTAR_EMPLEADOS), paramMap);
            //System.out.println("-->Empleados > URI: " + uri );
            EmpleadoDTO dto = TEMPLATE.getForObject(uri, EmpleadoDTO.class);
            //System.out.println("-->Empleados > DTO obtenido ");
            return dto.getListaEmpleados();
        } catch (JSONException | RestClientException e) {
            System.err.println("-->Error: No se pueden listar los empleados");
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }//end try catch
    }//end listarEmpleados

    public static Tsgrhempleados obtenerEmpleadoPorId(Integer empleadoId) {
        JSONObject json;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("empleadoId", empleadoId);
//            System.out.println("-->Empledos ID > Param: " + paramMap );
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_OBTENER_EMPLEADO_ID), paramMap);
//            System.out.println("-->Empleados ID > URI: " + uri );
            EmpleadoDTO dto = new EmpleadoDTO();
            dto = TEMPLATE.postForObject(uri, dto, EmpleadoDTO.class);
//            System.out.println("-->Empleados ID > DTO obtenido ");
            return dto.getEmpleado();
        } catch (Exception e) {
            System.err.println("-->Empledo por ID error: no se obtuvo el empleado");
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }//end try catch
    }//end obtenerEmpleadoPorId

    public static String getNombreEmpleado(Integer empleadoId) {
        Tsgrhempleados empleado = EmpleadosWSClient.obtenerEmpleadoPorId(empleadoId);
        String nombre = empleado.getDesNombre() + " ";
        if (empleado.getDesNombres() != null && empleado.getDesNombres().length() > 0) {
            nombre += empleado.getDesNombres() + " ";
        }//end if
        nombre += empleado.getDesApepaterno() + " " + empleado.getDesApematerno();
        return nombre;
    }//end getNombreEmpleado

    public static EmpleadoDTO listarEmpleadosRh(Integer empleadoId) {
        JSONObject json;
        EmpleadoDTO dto = new EmpleadoDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("empleadoId", empleadoId);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_OBTENER_EMPLEADO_ID), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, EmpleadoDTO.class);
        } catch (HttpServerErrorException | JSONException hsee) {
            logger.error(hsee.getMessage());
            dto = errorWebService();
        }
        return dto;
    }

    private static EmpleadoDTO errorWebService() {
        EmpleadoDTO dto = new EmpleadoDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }
}

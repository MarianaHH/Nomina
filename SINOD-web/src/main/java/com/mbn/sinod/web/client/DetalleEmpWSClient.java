/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mbn.sinod.model.dto.EmpDTO;
import com.mbn.sinod.web.util.ResourceBundles;
import com.mbn.sinod.web.util.StaticsConstants;
import com.mbn.sinod.web.util.TokenController;
import com.mbn.sinod.web.util.URIBuilder;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author eduardotorres
 */
public class DetalleEmpWSClient {

    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(DetalleEmpWSClient.class);

//    public static List<DetalleEmpDTO> listarEmp(Integer cabecera) throws JsonProcessingException {
//        JSONObject json;
//        try {
//            json = new JSONObject( TokenController.getAccessToken() );
//            Map<String, Object> paramMap = new HashMap<>();
//            paramMap.put( StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE) );
//            paramMap.put("cabecera", cabecera);
//            //System.out.println("-->Empledos > Param: " + paramMap );
//            URI uri = URIBuilder.buildWSUri( BUNDLE.getString(StaticsConstants.WS_LISTAR_TODOS_EMPELADOS), paramMap);
//            System.out.println("-->todos Empleados > URI: " + uri );
//            EmpDTO dto = TEMPLATE.getForObject(uri, EmpDTO.class);
////            System.out.println("WS CLIENT BIEN");
//            //System.out.println("-->Empleados > DTO obtenido ");
//            return dto.getListaEmp();
//        } catch (JSONException | RestClientException e) {
//            System.err.println("-->Error: No se pueden listar los empleados");
//            System.out.println("WS CLien no va bien");
//            e.printStackTrace();
//            return null;
//        }//end try catch
//    }//end listarEmp    EmpDTO
    public static EmpDTO EMPladoDTO(Integer cabecera) throws JsonProcessingException {
        JSONObject json;
        EmpDTO dto = new EmpDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("cabecera", cabecera);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTAR_TODOS_EMPELADOS), paramMap);
            System.out.println("ws de los pagos");
            dto = TEMPLATE.postForObject(uri, dto, EmpDTO.class);
        } catch (HttpServerErrorException | JSONException hsee) {
            logger.error(hsee.getMessage());
            dto = errorWebService();
        }
        return dto;
    }

    public static EmpDTO confirmaEmpleado(Integer cabecera, Integer empleado) throws JsonProcessingException {
        JSONObject json;
        EmpDTO dto = new EmpDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("cabecera", cabecera);
            paramMap.put("empleado", empleado);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_MOSTRAR_EMPLEADO), paramMap);
            System.out.println(uri);
            dto = TEMPLATE.postForObject(uri, dto, EmpDTO.class);
        } catch (HttpServerErrorException | JSONException hsee) {
            logger.error(hsee.getMessage());
            dto = errorWebService();
        }
        return dto;
    }

    private static EmpDTO errorWebService() {
        EmpDTO dto = new EmpDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }
}

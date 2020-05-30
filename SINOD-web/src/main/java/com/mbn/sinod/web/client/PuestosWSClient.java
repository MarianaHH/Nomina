/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.mbn.sinod.model.dto.PuestosDTO;
import com.mbn.sinod.model.entidades.Tsgrhpuestos;
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
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author eduardotorres
 */
public class PuestosWSClient {
    
    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(PuestosWSClient.class);
    
    public static List<Tsgrhpuestos> listarPuestos() {
        JSONObject json;
        try {
            json = new JSONObject( TokenController.getAccessToken() );
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put( StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE) );
            //System.out.println("-->Empledos > Param: " + paramMap );
            URI uri = URIBuilder.buildWSUri( BUNDLE.getString(StaticsConstants.WS_LISTA_PUESTOS), paramMap);
            //System.out.println("-->Empleados > URI: " + uri );
            PuestosDTO dto = TEMPLATE.getForObject(uri, PuestosDTO.class);
            //System.out.println("-->Empleados > DTO obtenido ");
            return dto.getListarPuestos();
        } catch (JSONException | RestClientException e) {
            System.err.println("-->Error: No se pueden listar los puestos");
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }//end try catch
    }//end listarPuestos
    
    public static Tsgrhpuestos obtenerPuestosPorId(Integer puestosId) {
        JSONObject json;
        try {
            json = new JSONObject( TokenController.getAccessToken() );
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put( StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE) );
            paramMap.put("puestosId", puestosId);
            //System.out.println("-->Empledos ID > Param: " + paramMap );
            URI uri = URIBuilder.buildWSUri( BUNDLE.getString(StaticsConstants.WS_OBTENER_PUESTOS_POR_ID), paramMap);
            //System.out.println("-->Empleados ID > URI: " + uri );
            PuestosDTO dto = new PuestosDTO();
            dto = TEMPLATE.postForObject(uri, dto, PuestosDTO.class);
            //System.out.println("-->Empleados ID > DTO obtenido ");
            return dto.getPuesto();
        } catch (Exception e) {
            System.err.println("-->Puesto por ID error: no se obtuvo el puesto");
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }//end try catch
    }//end obtenerPuestosPorId
    
    public static String getNombreEmpleado(Integer puestosId) {
        Tsgrhpuestos puesto = PuestosWSClient.obtenerPuestosPorId(puestosId); 
        String nombre = puesto.getDesPuesto() + " "; 
//        if ( puesto.getDesPuesto() != null && puesto.getDesPuesto().length() > 0) { 
//            nombre += puesto.getDesPuesto() + " ";
//        }//end if
        nombre += puesto.getCodAcronimo() + "  " + puesto.getCodAcronimo(); 
        return nombre;
    }//end getNombreEmpleado
            
    private static PuestosDTO errorWebService() {
        PuestosDTO dto = new PuestosDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.mbn.sinod.model.dto.DetalleIncidenciasEmpleadoDTO;
import com.mbn.sinod.model.dto.IncidenciasDTO;
import com.mbn.sinod.model.dto.IncidenciasPorEmpleadoDTO;
import com.mbn.sinod.web.util.ResourceBundles;
import com.mbn.sinod.web.util.StaticsConstants;
import com.mbn.sinod.web.util.TokenController;
import com.mbn.sinod.web.util.URIBuilder;
import java.math.BigDecimal;
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
 * @author Karla
 */
public class IncidenciasEmpleadoWSClient {
    
    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(IncidenciasEmpleadoWSClient.class);
    
    public static List<DetalleIncidenciasEmpleadoDTO> detalleIncidenciasEmpleado(Integer empleadoid){
        JSONObject json;
        try{
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("reporta", empleadoid);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_DETALLE_INCIDENCIAS_POR_EMPLEADO), paramMap);
            
            IncidenciasPorEmpleadoDTO dto = new IncidenciasPorEmpleadoDTO();
            dto = TEMPLATE.postForObject(uri, dto, IncidenciasPorEmpleadoDTO.class);
            return dto.getListaIncidenciasEmpleado();
        }catch(JSONException | RestClientException e){
            System.err.println("\nERROR BUSQUEDA INCIDENCIAS POR EMPLEADO" +e);
            logger.error(e.getMessage());
            return null;
        }
    }
    
    public static List<DetalleIncidenciasEmpleadoDTO> incidenciasQuincena(Integer quincena){
        JSONObject json;
        try{
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("quincena", quincena);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_INCIDENCIAS_POR_QUINCENA), paramMap);
            
            IncidenciasPorEmpleadoDTO dto = new IncidenciasPorEmpleadoDTO();
            dto = TEMPLATE.postForObject(uri, dto, IncidenciasPorEmpleadoDTO.class);
            return dto.getListaIncidenciasEmpleado();
        }catch(JSONException | RestClientException e){
            System.err.println("\nERROR BUSQUEDA INCIDENCIAS POR QUINCENA" +e);
            logger.error(e.getMessage());
            return null;
        }
    }
    
    public static List<DetalleIncidenciasEmpleadoDTO> incidenciasEmpleadoQuincena(Integer empleado, Integer quincena){
        JSONObject json;
        try{
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("empleado", empleado);
            paramMap.put("quincena", quincena);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_INCIDENCIAS_POR_EMPLEADOQUINCENA), paramMap);
            
            IncidenciasPorEmpleadoDTO dto = new IncidenciasPorEmpleadoDTO();
            dto = TEMPLATE.postForObject(uri, dto, IncidenciasPorEmpleadoDTO.class);
            return dto.getListaIncidenciasEmpleado();
        }catch(JSONException | RestClientException e){
            System.err.println("\nERROR BUSQUEDA INCIDENCIAS POR EMPLEADO" +e);
            logger.error(e.getMessage());
            return null;
        }
    }
     
    public static List<DetalleIncidenciasEmpleadoDTO> incidenciasQuincenaArea(Integer quincena, Integer area){
        JSONObject json;
        try{
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("quincena", quincena);
            paramMap.put("area", area);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_INCIDENCIAS_POR_QUINCENA_AREA), paramMap);
            
            IncidenciasPorEmpleadoDTO dto = new IncidenciasPorEmpleadoDTO();
            dto = TEMPLATE.postForObject(uri, dto, IncidenciasPorEmpleadoDTO.class);
            return dto.getListaIncidenciasEmpleado();
        }catch(JSONException | RestClientException e){
            System.err.println("\nERROR BUSQUEDA INCIDENCIAS POR QUINCENA AREA" +e);
            logger.error(e.getMessage());
            return null;
        }
    }
    public static boolean eliminarIncidenciaEmpleado(Integer incidenciaid, Integer reporta){
        JSONObject json;
        try{
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            paramMap.put("incidenciaid", incidenciaid);
            paramMap.put("reporta", reporta);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_ELIMINAR_INCIDENCIA_POR_EMPLEADO), paramMap);
            
            boolean bandera = false;
            bandera = TEMPLATE.postForObject(uri, bandera, Boolean.class);
            return bandera;
        }catch(JSONException | RestClientException e){
            System.out.println("\nERROR ELIMINAR INCIDENCIA"+ e);
            logger.error(e.getMessage());
            return false;
        }
    }
    
    public static boolean actualizarComentariosIncidencia(Integer incidenciaid, String comentarios, Integer reporta){
        JSONObject json;
        try{
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            paramMap.put("incidenciaid", incidenciaid);
            paramMap.put("comentarios", comentarios);
            paramMap.put("reporta", reporta);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_ACTUALIZAR_COMENTARIOS_INCIDENCIA), paramMap);
            
            boolean bandera = false;
            bandera = TEMPLATE.postForObject(uri, bandera, Boolean.class);
            return bandera;
        }catch(JSONException | RestClientException e){
            System.out.println("\nERROR ACTUALIZAR COMENTARIOS INCIDENCIA"+ e);
            logger.error(e.getMessage());
            return false;
        }
    }
    
    public static boolean actualizarImporteIncidencia(Integer incidenciaid, BigDecimal importe, Integer reporta){
        JSONObject json;
        try{
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            paramMap.put("incidenciaid", incidenciaid);
            paramMap.put("importe", importe);
            paramMap.put("reporta", reporta);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_ACTUALIZAR_IMPORTE_INCIDENCIA), paramMap);
            
            boolean bandera = false;
            bandera = TEMPLATE.postForObject(uri, bandera, Boolean.class);
            return bandera;
        }catch(JSONException | RestClientException e){
            System.out.println("\nERROR ACTUALIZAR IMPORTE INCIDENCIA"+ e);
            logger.error(e.getMessage());
            return false;
        }
    }
    
    public static boolean actualizarIncidencia(Integer incidenciaid, String comentarios, BigDecimal importe, Integer reporta){
        JSONObject json;
        try{
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            paramMap.put("incidenciaid", incidenciaid);
            paramMap.put("comentarios", comentarios);
            paramMap.put("importe", importe);
            paramMap.put("reporta", reporta);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_ACTUALIZAR_INCIDENCIA), paramMap);
            
            boolean bandera = false;
            bandera = TEMPLATE.postForObject(uri, bandera, Boolean.class);
            return bandera;
        }catch(JSONException | RestClientException e){
            System.out.println("\nERROR ACTUALIZAR INCIDENCIA"+ e);
            logger.error(e.getMessage());
            return false;
        }
    }
    
    public static boolean registrarIncidencia(IncidenciasDTO incidenciadto){
        boolean respuesta;
        JSONObject json;
        try{
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_REGISTRAR_INCIDENCIA), paramMap);
            respuesta = TEMPLATE.postForObject(uri, incidenciadto, Boolean.class);
        }catch(JSONException | RestClientException e){
            System.out.println("\nERROR registrar INCIDENCIA"+ e);
            logger.error(e.getMessage());
            respuesta = false;
        }
        System.out.println("\nRESPUESTA boolean: " +respuesta);
        return respuesta;
    }
}

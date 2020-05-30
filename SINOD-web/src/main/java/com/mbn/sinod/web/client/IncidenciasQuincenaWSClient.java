/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbn.sinod.model.dto.IncidenciasQuincenaDTO;
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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author mariana
 */
public class IncidenciasQuincenaWSClient {
    
    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(IncidenciasQuincenaWSClient.class);
    
    public static List<IncidenciasQuincenaDTO> listarIncidenciasQuincena() {
        JSONObject json;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            //System.out.println("-->Empledos > Param: " + paramMap );
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTAR_INCIDENCIAS_QUINCENA), paramMap);
            System.out.println("-->Incidencias quincena > URI: " + uri);
            IncidenciasQuincenaDTO dto = TEMPLATE.getForObject(uri, IncidenciasQuincenaDTO.class);
            //System.out.println("-->Empleados > DTO obtenido ");
            return dto.getListaIncidencias();
        } catch (JSONException | RestClientException e) {
            System.err.println("-->Error: No se pueden listar las incidencias");
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }//end try catch
    }//end listar

    public static IncidenciasQuincenaDTO validarIncidencias(IncidenciasQuincenaDTO dto) throws JsonProcessingException {
        JSONObject json;
        IncidenciasQuincenaDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_VALIDAR_INCIDENCIAS), paramMap);
            
            System.out.println("wsclin validar " + dto.getListaIncidencias().get(0));
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, IncidenciasQuincenaDTO.class);
            
            ObjectMapper mapper = new ObjectMapper();
            String jsonS = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
            
            System.out.println(uri);
            System.out.println("SALIDA JSON: \n" + jsonS);
        } catch (HttpClientErrorException | JSONException jsone) {
            dtoRespuesta = errorWebService();
            logger.error(jsone.getMessage());
        }
        return dtoRespuesta;
    }
    
    public static IncidenciasQuincenaDTO validarTodas(IncidenciasQuincenaDTO dto) throws JsonProcessingException {
        JSONObject json;
        IncidenciasQuincenaDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_VALIDAR_TODAS_INCIDENCIAS), paramMap);
            
            System.out.println("wsclin validar " + dto.getListaIncidencias().get(0));
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, IncidenciasQuincenaDTO.class);
            
            ObjectMapper mapper = new ObjectMapper();
            String jsonS = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
            
            System.out.println(uri);
            System.out.println("SALIDA JSON: \n" + jsonS);
        } catch (HttpClientErrorException | JSONException jsone) {
            dtoRespuesta = errorWebService();
            logger.error(jsone.getMessage());
        }
        return dtoRespuesta;
    }
    
    public static IncidenciasQuincenaDTO rechazarTodas(IncidenciasQuincenaDTO dto) throws JsonProcessingException {
        JSONObject json;
        IncidenciasQuincenaDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_RECHAZAR_TODAS_INCIDENCIAS), paramMap);
            
            System.out.println("wsclin validar " + dto.getListaIncidencias().get(0));
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, IncidenciasQuincenaDTO.class);
            
            ObjectMapper mapper = new ObjectMapper();
            String jsonS = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
            
            System.out.println(uri);
            System.out.println("SALIDA JSON: \n" + jsonS);
        } catch (HttpClientErrorException | JSONException jsone) {
            dtoRespuesta = errorWebService();
            logger.error(jsone.getMessage());
        }
        return dtoRespuesta;
    }
    
    public static IncidenciasQuincenaDTO autorizarIncidencias(IncidenciasQuincenaDTO dto) throws JsonProcessingException {
        JSONObject json;
        IncidenciasQuincenaDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_AUTORIZAR_INCIDENCIAS), paramMap);
            
            System.out.println("wsclin AUTORIZAR " + dto.getListaIncidencias().get(0));
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, IncidenciasQuincenaDTO.class);
            
            ObjectMapper mapper = new ObjectMapper();
            String jsonS = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
            
            System.out.println(uri);
            System.out.println("SALIDA JSON: \n" + jsonS);
        } catch (HttpClientErrorException | JSONException jsone) {
            dtoRespuesta = errorWebService();
            logger.error(jsone.getMessage());
        }
        return dtoRespuesta;
    }
    
    public static IncidenciasQuincenaDTO autorizarTodas(IncidenciasQuincenaDTO dto) throws JsonProcessingException {
        JSONObject json;
        IncidenciasQuincenaDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_AUTORIZAR_TODAS_INCIDENCIAS), paramMap);
            
            System.out.println("wsclin AUTORIZAR " + dto.getListaIncidencias().get(0));
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, IncidenciasQuincenaDTO.class);
            
            ObjectMapper mapper = new ObjectMapper();
            String jsonS = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
            
            System.out.println(uri);
            System.out.println("SALIDA JSON: \n" + jsonS);
        } catch (HttpClientErrorException | JSONException jsone) {
            dtoRespuesta = errorWebService();
            logger.error(jsone.getMessage());
        }
        return dtoRespuesta;
    }
    
    public static IncidenciasQuincenaDTO denegarTodas(IncidenciasQuincenaDTO dto) throws JsonProcessingException {
        JSONObject json;
        IncidenciasQuincenaDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_DENEGAR_TODAS_INCIDENCIAS), paramMap);
            
            System.out.println("wsclin AUTORIZAR " + dto.getListaIncidencias().get(0));
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, IncidenciasQuincenaDTO.class);
            
            ObjectMapper mapper = new ObjectMapper();
            String jsonS = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
            
            System.out.println(uri);
            System.out.println("SALIDA JSON: \n" + jsonS);
        } catch (HttpClientErrorException | JSONException jsone) {
            dtoRespuesta = errorWebService();
            logger.error(jsone.getMessage());
        }
        return dtoRespuesta;
    }
    
    public static List<IncidenciasQuincenaDTO> incidenciasQuincenaPorArea(Integer area) {
        JSONObject json;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("area", area);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_INCIDENCIAS_QUINCENA_POR_AREA), paramMap);
            
            IncidenciasQuincenaDTO dto = new IncidenciasQuincenaDTO();
            dto = TEMPLATE.postForObject(uri, dto, IncidenciasQuincenaDTO.class);
            return dto.getListaIncidencias();
        } catch (JSONException | RestClientException e) {
            System.err.println("\nERROR BUSQUEDA INCIDENCIAS QUINCENA POR AREA (LC)" + e);
            logger.error(e.getMessage());
            return null;
        }
    }
    
    public static IncidenciasQuincenaDTO autorizarPagosIncidencias(IncidenciasQuincenaDTO dto) throws JsonProcessingException {
        JSONObject json;
        IncidenciasQuincenaDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_AUTORIZAR_PAGOS_INCIDENCIAS), paramMap);
            
            System.out.println("wsclin AUTORIZAR " + dto.getListaIncidencias().get(0));
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, IncidenciasQuincenaDTO.class);
            
            ObjectMapper mapper = new ObjectMapper();
            String jsonS = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
            
            System.out.println(uri);
            System.out.println("SALIDA JSON: \n" + jsonS);
        } catch (HttpClientErrorException | JSONException jsone) {
            dtoRespuesta = errorWebService();
            System.err.println("\nERROR AUTORIZAR PAGOS INCIDENCIAS una por una" + jsone);
            logger.error(jsone.getMessage());
        }
        return dtoRespuesta;
    }
    
    public static IncidenciasQuincenaDTO autorizarPagoIncidencias(IncidenciasQuincenaDTO dto) throws JsonProcessingException {
        JSONObject json;
        IncidenciasQuincenaDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_AUTORIZAR_PAGO_INCIDENCIAS), paramMap);
            
            System.out.println("wsclin AUTORIZAR " + dto.getListaIncidencias().get(0));
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, IncidenciasQuincenaDTO.class);
            
            ObjectMapper mapper = new ObjectMapper();
            String jsonS = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
            
            System.out.println(uri);
            System.out.println("SALIDA JSON: \n" + jsonS);
        } catch (HttpClientErrorException | JSONException jsone) {
            dtoRespuesta = errorWebService();
            System.err.println("\nERROR AUTORIZAR PAGOS INCIDENCIAS TODAS" + jsone);
            logger.error(jsone.getMessage());
        }
        return dtoRespuesta;
    }
    
    public static IncidenciasQuincenaDTO denegarPagoIncidencias(IncidenciasQuincenaDTO dto) throws JsonProcessingException {
        JSONObject json;
        IncidenciasQuincenaDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_DENEGAR_PAGO_INCIDENCIAS), paramMap);
            
            System.out.println("wsclin AUTORIZAR " + dto.getListaIncidencias().get(0));
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, IncidenciasQuincenaDTO.class);
            
            ObjectMapper mapper = new ObjectMapper();
            String jsonS = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
            
            System.out.println(uri);
            System.out.println("SALIDA JSON: \n" + jsonS);
        } catch (HttpClientErrorException | JSONException jsone) {
            dtoRespuesta = errorWebService();
            System.err.println("\nERROR DENEGAR PAGOS INCIDENCIAS TODAS" + jsone);
            logger.error(jsone.getMessage());
        }
        return dtoRespuesta;
    }
    
    public static boolean posponerPagoIncidencia(Integer incidenciaid, String comentarios, Integer modifica) {
        JSONObject json;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            paramMap.put("incidenciaid", incidenciaid);
            paramMap.put("comentarios", comentarios);
            paramMap.put("modifica", modifica);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_POSPONER_PAGO_INCIDENCIA), paramMap);
            
            boolean bandera = false;
            bandera = TEMPLATE.postForObject(uri, bandera, Boolean.class);
            return bandera;
        } catch (JSONException | RestClientException e) {
            System.out.println("\nERROR POSPONER PAGO DE INCIDENCIA" + e);
            logger.error(e.getMessage());
            return false;
        }
    }
    
    private static IncidenciasQuincenaDTO errorWebService() {
        IncidenciasQuincenaDTO dto = new IncidenciasQuincenaDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }
    
}

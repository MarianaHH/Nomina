/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbn.sinod.model.dto.IncidenciasQuincenaDTO;
import com.mbn.sinod.model.dto.ValidacionAltasDTO;
import com.mbn.sinod.model.dto.ValidacionBajasDTO;
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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author mariana
 */
public class EnviarCorreoWSClient {
    
    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(EnviarCorreoWSClient.class);
    
    public static void enviarCorreos(IncidenciasQuincenaDTO dto) throws JsonProcessingException {
        JSONObject json;
        IncidenciasQuincenaDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_ENVIAR_CORREOS_INCIDENCIAS), paramMap);
            
            System.out.println("wsclin validar " + dto.getListaIncidencias().get(0).getIncidencia());
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, IncidenciasQuincenaDTO.class);
            
            ObjectMapper mapper = new ObjectMapper();
            String jsonS = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
            
            System.out.println(uri);
            System.out.println("SALIDA JSON: \n" + jsonS);
        } catch (HttpClientErrorException | JSONException jsone) {
            dtoRespuesta = errorWebService();
            logger.error(jsone.getMessage());
        }
    }
    
    public static void enviarCorreosValidarAltas(ValidacionAltasDTO dto) throws JsonProcessingException {
        JSONObject json;
        ValidacionAltasDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_ENVIAR_CORREO_VALIDAR_ALTA), paramMap);
            
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, ValidacionAltasDTO.class);
            
            ObjectMapper mapper = new ObjectMapper();
            String jsonS = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
            
            System.out.println(uri);
            System.out.println("SALIDA JSON: \n" + jsonS);
        } catch (HttpClientErrorException | JSONException jsone) {
            errorWebService();
            logger.error(jsone.getMessage());
        }
    }
    
    public static void enviarCorreosValidarBajas(ValidacionBajasDTO dto) throws JsonProcessingException {
        JSONObject json;
        ValidacionBajasDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_ENVIAR_CORREO_VALIDAR_BAJA), paramMap);
            
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, ValidacionBajasDTO.class);
            
            ObjectMapper mapper = new ObjectMapper();
            String jsonS = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
            
            System.out.println(uri);
            System.out.println("SALIDA JSON: \n" + jsonS);
        } catch (HttpClientErrorException | JSONException jsone) {
            errorWebService();
            logger.error(jsone.getMessage());
        }
    }
    
    private static IncidenciasQuincenaDTO errorWebService() {
        IncidenciasQuincenaDTO dto = new IncidenciasQuincenaDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }
}

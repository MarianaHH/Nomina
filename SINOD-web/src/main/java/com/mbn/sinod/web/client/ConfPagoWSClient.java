/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbn.sinod.model.dto.ConfPagoDTO;
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
 * @author eduardotorres
 */
public class ConfPagoWSClient {

    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(ConfPagoWSClient.class);

    public static ConfPagoDTO guardarPagoRF(ConfPagoDTO dto) throws JsonProcessingException {
        JSONObject json;
        ConfPagoDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_GUARDAR_AUTORIZACION_RF), paramMap);
            System.out.println("WS_CLIENT_RF bien");
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, ConfPagoDTO.class);
            ObjectMapper mapper = new ObjectMapper();
            String jsonS = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);

            System.out.println("SALIDA JSON: \n" + jsonS);
        } catch (HttpClientErrorException | JSONException jsone) {
            dtoRespuesta = errorWebService();
            logger.error(jsone.getMessage());
        }

        return dtoRespuesta;
    }

    public static ConfPagoDTO guardarPagoRH(ConfPagoDTO dto) throws JsonProcessingException {
        JSONObject json;
        ConfPagoDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_GUARDAR_AUTORIZACION_RH), paramMap);

            dtoRespuesta = TEMPLATE.postForObject(uri, dto, ConfPagoDTO.class);
            ObjectMapper mapper = new ObjectMapper();
            String jsonS = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);

            System.out.println("SALIDA JSON: \n" + jsonS);
        } catch (HttpClientErrorException | JSONException jsone) {
            dtoRespuesta = errorWebService();
            logger.error(jsone.getMessage());
        }

        return dtoRespuesta;
    }

    public static ConfPagoDTO guardarPagoEMP(Integer empQuincena, boolean autorizaciones) throws JsonProcessingException {
        JSONObject json;
        ConfPagoDTO dto = new ConfPagoDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            paramMap.put("empquincenaFK", empQuincena);
            paramMap.put("pago3", autorizaciones);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_GUARDAR_AUTORIZACION_EMP), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, ConfPagoDTO.class);
        } catch (HttpClientErrorException | JSONException jsone) {
            dto = errorWebService();
            logger.error(jsone.getMessage());
        }
        return dto;
    }

    public static ConfPagoDTO validarTodas(Integer cabecera) throws JsonProcessingException {
        JSONObject json;
        ConfPagoDTO dto = new ConfPagoDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            paramMap.put("cabecera", cabecera);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_VALIDAR_TODAS_RF), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, ConfPagoDTO.class);
        } catch (HttpClientErrorException | JSONException jsone) {
            dto = errorWebService();
            logger.error(jsone.getMessage());
        }
        return dto;
    }

    public static ConfPagoDTO validarTodasRH(Integer cabecera) throws JsonProcessingException {
        JSONObject json;
        ConfPagoDTO dto = new ConfPagoDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            paramMap.put("cabecera", cabecera);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_VALIDAR_TODAS_RH), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, ConfPagoDTO.class);
        } catch (HttpClientErrorException | JSONException jsone) {
            dto = errorWebService();
            logger.error(jsone.getMessage());
        }
        return dto;
    }

    public static ConfPagoDTO rechazarTodasRF(Integer cabecera) throws JsonProcessingException {
        JSONObject json;
        ConfPagoDTO dto = new ConfPagoDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            paramMap.put("cabecera", cabecera);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_RECHAZAR_TODAS_RF), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, ConfPagoDTO.class);
        } catch (HttpClientErrorException | JSONException jsone) {
            dto = errorWebService();
            logger.error(jsone.getMessage());
        }
        return dto;
    }

    public static ConfPagoDTO rechazarTodasRH(Integer cabecera) throws JsonProcessingException {
        JSONObject json;
        ConfPagoDTO dto = new ConfPagoDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            paramMap.put("cabecera", cabecera);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_RECHAZAR_TODAS_RH), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, ConfPagoDTO.class);
        } catch (HttpClientErrorException | JSONException jsone) {
            dto = errorWebService();
            logger.error(jsone.getMessage());
        }
        return dto;
    }

    private static ConfPagoDTO errorWebService() {
        ConfPagoDTO dto = new ConfPagoDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }

}

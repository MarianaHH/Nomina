/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbn.sinod.model.dto.DesgloseEmpleadoDTO;
import com.mbn.sinod.model.dto.EmpleadosNomDTO;
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
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Karla
 */
public class EmpleadosNomWSClient {
    
    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(EmpleadosNomWSClient.class);
    
    public static EmpleadosNomDTO obtenerEmpleadonomPorIdrh(Integer idempleadorh){
        JSONObject json;
        EmpleadosNomDTO dto = new EmpleadosNomDTO();
        try{
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("idempleadorh", idempleadorh);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_OBTENER_EMPLEADO_NOM), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, EmpleadosNomDTO.class);
            return dto;
        }catch(JSONException | RestClientException e){
            System.out.println("\nERROR OBTENER EMPLEADO DE NOMINA: "+ e);
            logger.error(e.getMessage());
            return dto;
        }
    }
    
    public static EmpleadosNomDTO guardarEmpleado(EmpleadosNomDTO dto) throws JsonProcessingException {
        JSONObject json;
       EmpleadosNomDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_GUARDAR_EMPLEADO_NOMINA), paramMap);
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, EmpleadosNomDTO.class);
            ObjectMapper mapper = new ObjectMapper();     
        } catch (HttpClientErrorException | JSONException jsone) {
            logger.error(jsone.getMessage());
            dtoRespuesta = errorWebService();
        }
        return dtoRespuesta;
    }
    
    public static EmpleadosNomDTO obtenerEmpleadosnomPorIdNom(Integer idempleadonom){
        JSONObject json;
        EmpleadosNomDTO dto = new EmpleadosNomDTO();
        try{
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("idempleadonom", idempleadonom);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_OBTENER_EMPLEADOS_MOMINA_POR_IDNOM), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, EmpleadosNomDTO.class);
            return dto;
        }catch(JSONException | RestClientException e){
            System.out.println("\nERROR OBTENER EMPLEADO DE NOMINA: "+ e);
            logger.error(e.getMessage());
            return dto;
        }
    }
    
    public static DesgloseEmpleadoDTO obtenerEmpleadosnomPorIdNomHT(Integer idempleadonom){
        JSONObject json;
        DesgloseEmpleadoDTO dto = new DesgloseEmpleadoDTO();
        try{
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("idempleadonom", idempleadonom);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_OBTENER_EMPLEADOS_MOMINA_POR_IDNOMHT), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, DesgloseEmpleadoDTO.class);
            return dto;
        }catch(JSONException | RestClientException e){
            System.out.println("\nERROR OBTENER EMPLEADO DE NOMINA: "+ e);
            logger.error(e.getMessage());
            return dto;
        }
    }
    
    private static EmpleadosNomDTO errorWebService() {
        EmpleadosNomDTO dto = new EmpleadosNomDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }
}

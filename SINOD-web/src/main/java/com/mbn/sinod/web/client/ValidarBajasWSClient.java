/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbn.sinod.model.dto.ValidacionBajasDTO;
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
 * @author Ivette
 */
public class ValidarBajasWSClient {

    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(ValidarAltasWSClient.class);

    public static List<ValidacionBajasDTO> listarValidarBajas() {
        JSONObject json;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            //System.out.println("-->Empledos > Param: " + paramMap );
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTAR_BAJAS), paramMap);
            System.out.println("-->validar bajas > URI: " + uri);
            ValidacionBajasDTO dto = TEMPLATE.getForObject(uri, ValidacionBajasDTO.class);
            //System.out.println("-->Empleados > DTO obtenido ");
            return dto.getListaInformacionValidar();
        } catch (JSONException | RestClientException e) {
            System.err.println("-->Error: No se pueden listar las bajas");
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }//end try catch
    }//end listar

    public static ValidacionBajasDTO validarCadaBaja(ValidacionBajasDTO dto) throws JsonProcessingException {
        JSONObject json;
        ValidacionBajasDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_VALIDAR_CADA_BAJA), paramMap);

            System.out.println("wsclin validar " + dto.getListaInformacionValidar().get(0));
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, ValidacionBajasDTO.class);

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

    public static ValidacionBajasDTO validarBajasAceptadas(ValidacionBajasDTO dto) throws JsonProcessingException {
        JSONObject json;
        ValidacionBajasDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_VALIDAR_BAJAS_ACEPTADAS), paramMap);

            System.out.println("wsclin validar " + dto.getListaInformacionValidar().get(0));
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, ValidacionBajasDTO.class);

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

    public static ValidacionBajasDTO validarBajasRechazadas(ValidacionBajasDTO dto) throws JsonProcessingException {
        JSONObject json;
        ValidacionBajasDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_VALIDAR_BAJAS_RECHAZADAS), paramMap);

            System.out.println("wsclin validar " + dto.getListaInformacionValidar().get(0));
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, ValidacionBajasDTO.class);

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

    private static ValidacionBajasDTO errorWebService() {
        ValidacionBajasDTO dto = new ValidacionBajasDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }
}

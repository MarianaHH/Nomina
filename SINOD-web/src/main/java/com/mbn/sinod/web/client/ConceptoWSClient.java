 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbn.sinod.model.dto.ConceptoDTO;
import com.mbn.sinod.model.entidades.Tsgnomconcepto;
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
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ambrosio
 */
public class ConceptoWSClient {
    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(ConceptoWSClient.class);

    public static List<Tsgnomconcepto> listarConceptos() {
        JSONObject json;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTA_CONCEPTOS), paramMap);
            ConceptoDTO dto = TEMPLATE.getForObject(uri, ConceptoDTO.class);
            return dto.getListConceptos();
        } catch (JSONException | RestClientException e) {
            System.err.println("-->Error: No se pueden listar los conceptos");
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }//end try catch
    }//end listar
    
    public static ConceptoDTO eliminarConcepto(Integer id) throws JsonProcessingException {
        JSONObject json;
        ConceptoDTO dto = new ConceptoDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();            
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("conceptoid", id);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_ELIMINAR_CONCEPTO), paramMap);            
            dto = TEMPLATE.postForObject(uri, dto, ConceptoDTO.class);
        } catch (HttpServerErrorException | JSONException hsee) {
            logger.error(hsee.getMessage());
            dto = errorWebService();
        }
        return dto;
    }
     
    public static ConceptoDTO guardarConcepto(ConceptoDTO dto) throws JsonProcessingException {
        JSONObject json;
        ConceptoDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_GUARDAR_CONCEPTO), paramMap);
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, ConceptoDTO.class);
            ObjectMapper mapper = new ObjectMapper();
            String jsonS = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
            System.out.println("SALIDA JSON: \n" + jsonS);
        } catch (HttpClientErrorException | JSONException jsone) {
            dtoRespuesta = errorWebService();
            logger.error(jsone.getMessage());
        }
        return dtoRespuesta;
    }
     
     
    public static ConceptoDTO guardarPrioridad(ConceptoDTO dto) throws JsonProcessingException {
        JSONObject json;
        ConceptoDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_GUARDAR_PRIORIDAD), paramMap);
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, ConceptoDTO.class);
            ObjectMapper mapper = new ObjectMapper();
            String jsonS = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
            System.out.println("SALIDA JSON: \n" + jsonS);
        } catch (HttpClientErrorException | JSONException jsone) {
            dtoRespuesta = errorWebService();
            logger.error(jsone.getMessage());
        }
        return dtoRespuesta;
    }
     
     public static List<Tsgnomconcepto> listarConceptosPercepcion() {
        JSONObject json;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTAR_CONCEPTOS_PERCEPCION), paramMap);
            ConceptoDTO dto = TEMPLATE.getForObject(uri, ConceptoDTO.class);
            return dto.getListConceptos();
        } catch (JSONException | RestClientException e) {
            System.err.println("-->Error: No se pueden listar los conceptos por percepcion");
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }//end try catch
    }//end listar
    
     
     public static List<Tsgnomconcepto> listarConceptosDeduccion() {
        JSONObject json;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTAR_CONCEPTOS_DEDUCCION), paramMap);
            ConceptoDTO dto = TEMPLATE.getForObject(uri, ConceptoDTO.class);
            return dto.getListConceptos();
        } catch (JSONException | RestClientException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }//end try catch
    }//end listar
     
    private static ConceptoDTO errorWebService() {
        ConceptoDTO dto = new ConceptoDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }
    
}

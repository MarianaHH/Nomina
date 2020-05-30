/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbn.sinod.model.dto.CatIncidenciaDTO;
import com.mbn.sinod.model.entidades.Tsgnomcatincidencia;
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
public class CatIncidenciaWSClient {

    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(CatIncidenciaWSClient.class.getName());

    public static List<Tsgnomcatincidencia> listarCatIncidencias() {
        JSONObject json;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTA_CATINCIDENCIA), paramMap);
            CatIncidenciaDTO dto = TEMPLATE.getForObject(uri, CatIncidenciaDTO.class);
            return dto.getListarCatIncidencias();
        } catch (JSONException | RestClientException e) {
            System.err.println("-->Error: No se pueden listar los empleados");
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }//end try catch
    }//end listar

    public static CatIncidenciaDTO guardarActualizarCatInci(CatIncidenciaDTO dto) throws JsonProcessingException {
        JSONObject json;
        CatIncidenciaDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_GUARDAR_CATINCIDENCIA), paramMap);
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, CatIncidenciaDTO.class);

            ObjectMapper mapper = new ObjectMapper();
        } catch (HttpClientErrorException | JSONException jsone) {
            dtoRespuesta = errorWebService();
            logger.error(jsone.getMessage());
        }
        return dtoRespuesta;
    }

    public static CatIncidenciaDTO eliminarCatIncidenciasId(Integer id) throws JsonProcessingException {
        JSONObject json;
        CatIncidenciaDTO dto = new CatIncidenciaDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();            
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("codCatincidenciaid", id);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_ELIMINAR_CATINCIDENCIA), paramMap);            
            dto = TEMPLATE.postForObject(uri, dto, CatIncidenciaDTO.class);
        } catch (HttpServerErrorException | JSONException hsee) {
            logger.error(hsee.getMessage());
            dto = errorWebService();
        }
        return dto;
    }
    
    private static CatIncidenciaDTO errorWebService() {
        CatIncidenciaDTO dto = new CatIncidenciaDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }
}

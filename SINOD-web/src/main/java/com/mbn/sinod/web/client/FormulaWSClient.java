/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbn.sinod.model.dto.FormulaDTO;
import com.mbn.sinod.model.entidades.Tsgnomformula;
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
public class FormulaWSClient {
    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(FormulaWSClient.class);
    
    public static List<Tsgnomformula> listarCatIncidencias() {
        JSONObject json;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTA_FORMULAS), paramMap);
            FormulaDTO dto = TEMPLATE.getForObject(uri, FormulaDTO.class);
            return dto.getListarFormulas();
        } catch (JSONException | RestClientException e) {
            System.err.println("-->Error: No se pueden listar los empleados");
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }//end try catch
    }//end listar
    
    public static FormulaDTO guardarFormula(FormulaDTO dto) throws JsonProcessingException {
        JSONObject json;
        FormulaDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_GUARDAR_FORMULA), paramMap);
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, FormulaDTO.class);

            ObjectMapper mapper = new ObjectMapper();
        } catch (HttpClientErrorException | JSONException jsone) {
            dtoRespuesta = errorWebService();
            logger.error(jsone.getMessage());
        }
        return dtoRespuesta;
    }
    
    private static FormulaDTO errorWebService() {
        FormulaDTO dto = new FormulaDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }
    
    
    
    
}

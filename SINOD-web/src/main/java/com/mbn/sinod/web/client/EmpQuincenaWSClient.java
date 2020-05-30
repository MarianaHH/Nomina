/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mbn.sinod.model.dto.EmpQuincenasDTO;
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
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author User
 */
public class EmpQuincenaWSClient {

    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(ConceptoWSClient.class);

    public static EmpQuincenasDTO insertaEmpQuincena(Integer id) throws JsonProcessingException {
        JSONObject json;
        EmpQuincenasDTO dto = new EmpQuincenasDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("cabeceraid_fk", id);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_INSERTA_EMPQUINCENA), paramMap);
//            System.out.println(uri);
            dto = TEMPLATE.postForObject(uri, dto, EmpQuincenasDTO.class);
        } catch (HttpServerErrorException | JSONException hsee) {
            logger.error(hsee.getMessage());
            dto = errorWebService();
        }
        return dto;
    }

    private static EmpQuincenasDTO errorWebService() {
        EmpQuincenasDTO dto = new EmpQuincenasDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }
}

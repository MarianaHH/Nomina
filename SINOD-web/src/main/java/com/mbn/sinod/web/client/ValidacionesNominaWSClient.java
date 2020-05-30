/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.mbn.sinod.model.dto.InfoValidacionesNominaDTO;
import com.mbn.sinod.model.dto.ValidacionesNominaDTO;
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
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Ivette
 */
public class ValidacionesNominaWSClient {

    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(ValidacionesNominaWSClient.class);
    
    public static List<ValidacionesNominaDTO> detallesValidacionesNomina() {
        JSONObject json;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            //PASAMOS LOS PARÁMETROS PARA CREAR NUESTRA URL
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            //paramMap.put("clienteid", clienteId);//Parámetro a pasar
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_ALTASVALIDADAS), paramMap);
            System.out.println("-->ALTAS VALIDADAS > URI: " + uri);
            InfoValidacionesNominaDTO dto = new InfoValidacionesNominaDTO();
            //postForObject ---se pone de acuerdo a si nuestro metodo es GET o POST
            dto = TEMPLATE.postForObject(uri, dto, InfoValidacionesNominaDTO.class);
            return dto.getListaValidacionesNomina();
        } catch (JSONException | RestClientException e) {
            System.err.println("ERROR LISTA ALTAS VALIDADAS " + e);
            logger.error(e.getMessage());
            return null;
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.mbn.sinod.model.dto.CatClasificadorDTO;
import com.mbn.sinod.model.entidades.Tsgnomclasificador;
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
 * @author ambrosio
 */
public class CatClasificadorWSClient {
    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(CatClasificadorWSClient.class.getName());
    
    public static List<Tsgnomclasificador> listarConceptos() {
        JSONObject json;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTA_CATCLASIFICADR), paramMap);
            CatClasificadorDTO dto = TEMPLATE.getForObject(uri, CatClasificadorDTO.class);
            return dto.getListaCatClasificadores();
        } catch (JSONException | RestClientException e) {
            System.err.println("-->Error: No se pueden listar los empleados");
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }//end try catch
    }//end listar
}

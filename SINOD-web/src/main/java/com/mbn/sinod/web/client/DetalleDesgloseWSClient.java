/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mbn.sinod.model.dto.DesgloseDTO;
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
 * @author eduardotorres
 */
public class DetalleDesgloseWSClient {

    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(DetalleDesglosePercepcionWSClient.class);

    public static DesgloseDTO listarDeducciones(Integer cod_empleado, Integer cod_cabecera) throws JsonProcessingException {
        JSONObject json;
        DesgloseDTO dto = new DesgloseDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("cod_empleado", cod_empleado);
            paramMap.put("cod_cabecera", cod_cabecera);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTA_DEATALLE_DESGLOSE_D), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, DesgloseDTO.class);
        } catch (HttpServerErrorException | JSONException hsee) {
            System.err.println("-->Error: No se pueden listar las deducciones del empelado");
            logger.error(hsee.getMessage());
            dto = errorWebService();
        }
        return dto;
    }

    private static DesgloseDTO errorWebService() {
        DesgloseDTO dto = new DesgloseDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }
}

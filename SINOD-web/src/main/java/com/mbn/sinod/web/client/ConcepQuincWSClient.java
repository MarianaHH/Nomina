/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.mbn.sinod.model.dto.ConcepQuincDTO;
import com.mbn.sinod.model.dto.ConcepQuincHTDTO;
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
 * @author Ambro
 */
public class ConcepQuincWSClient {

    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(ConcepQuincWSClient.class);

    public static ConcepQuincDTO listarConceptosByEmpQuin(Integer empQuinc)  {
        JSONObject json;
        ConcepQuincDTO dto = new ConcepQuincDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("empQuinc", empQuinc);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTA_CONCEPQUINC), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, ConcepQuincDTO.class);
        } catch (HttpServerErrorException | JSONException hsee) {
            logger.error(hsee.getMessage());
            dto = errorWebService();
        }
        return dto;
    }

    public static ConcepQuincHTDTO listarConceptosByEmpQuinHT(Integer empQuinc) {
        JSONObject json;
        ConcepQuincHTDTO dto = new ConcepQuincHTDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("empQuinc", empQuinc);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTA_CONCEPQUINCHT), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, ConcepQuincHTDTO.class);
        } catch (HttpServerErrorException | JSONException hsee) {
            logger.error(hsee.getMessage());
            dto = errorWebServiceHT();
        }
        return dto;
    }
    
    public static ConcepQuincDTO listaConceptosEmpl(Integer empleado){
        JSONObject json;
        ConcepQuincDTO dto = new ConcepQuincDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("empleado", empleado);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_CONCEPTOSEMPLEADOS), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, ConcepQuincDTO.class);
        } catch (HttpServerErrorException | JSONException hsee) {
            logger.error(hsee.getMessage());
            dto = errorWebService();
        }
        return dto;

    }
    
    public static ConcepQuincDTO listaConceptosCabecera(Integer cabecera){
        JSONObject json;
        ConcepQuincDTO dto = new ConcepQuincDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("cabecera", cabecera);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTA_CONCEPQUINC_CABECERA), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, ConcepQuincDTO.class);
        } catch (HttpServerErrorException | JSONException hsee) {
            logger.error(hsee.getMessage());
            dto = errorWebService();
        }
        return dto;

    }

    private static ConcepQuincDTO errorWebService() {
        ConcepQuincDTO dto = new ConcepQuincDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }

    private static ConcepQuincHTDTO errorWebServiceHT() {
        ConcepQuincHTDTO dto = new ConcepQuincHTDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }
}

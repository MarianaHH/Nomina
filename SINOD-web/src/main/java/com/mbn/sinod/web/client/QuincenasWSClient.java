/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbn.sinod.model.dto.QuincenasDTO;
import com.mbn.sinod.model.entidades.Tsgnomquincena;
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
 * @author mipe
 */
public class QuincenasWSClient {

    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(QuincenasWSClient.class);
    //era este sorry error en el nombre

    public static List<Tsgnomquincena> listarQuincenas() {
        JSONObject json;    //objeto tipo JSON 
        try {   //es para que el sistema no se detenga
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
//            System.out.println("-->Empledos > Param: " + paramMap );
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTAR_QUINCENAS), paramMap);
//            System.out.println("-->Empleados > URI: " + uri );
            QuincenasDTO dto = TEMPLATE.getForObject(uri, QuincenasDTO.class);
//            System.out.println("-->Empleados > DTO obtenido ");
            return dto.getListarquincena();
        } catch (JSONException | RestClientException e) {
            System.err.println("-->Error: No se pueden listar los Quincenas");
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }//end try catch
    }//end listarEmpleados
    
    public static List<Tsgnomquincena> listarQuincenasFuturas() {
        JSONObject json;    //objeto tipo JSON 
        try {   //es para que el sistema no se detenga
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
//            System.out.println("-->Empledos > Param: " + paramMap );
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTAR_QUINCENAS_FUTURAS), paramMap);
//            System.out.println("-->Empleados > URI: " + uri );
            QuincenasDTO dto = TEMPLATE.getForObject(uri, QuincenasDTO.class);
//            System.out.println("-->Empleados > DTO obtenido ");
            return dto.getListarquincena();
        } catch (JSONException | RestClientException e) {
            System.err.println("-->Error: No se pueden listar los Quincenas");
            e.printStackTrace();
            return null;
        }//end try catch
    }//end listarEmpleados
    
     public static QuincenasDTO guardarQuincena(QuincenasDTO dto) throws JsonProcessingException {
        JSONObject json;
        QuincenasDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_GUARDAR_QUINCENA), paramMap);
//            System.out.println("wsclin " + dto.getArgumento().getCodNbargumento());
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, QuincenasDTO.class);

            ObjectMapper mapper = new ObjectMapper();
            String jsonS = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);

           System.out.println(uri);
            System.out.println("SALIDA JSON: \n" + jsonS);
        } catch (HttpClientErrorException | JSONException jsone) {
            dtoRespuesta = errorWebService();
        }
        return dtoRespuesta;
    }
     
     public static QuincenasDTO quincenaActual() {
        JSONObject json;
        QuincenasDTO dto = new QuincenasDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_QUINCENA_ACTUAL), paramMap);
            dto = TEMPLATE.getForObject(uri, QuincenasDTO.class);
            return dto;
        } catch (JSONException | RestClientException e) {
            System.err.println("-->Error: No se puede obtener la Quincena Actual");
            e.printStackTrace();
            return dto;
        }
    }
    
        
    private static QuincenasDTO errorWebService() {
        QuincenasDTO dto = new QuincenasDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }
     
    
}

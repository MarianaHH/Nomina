/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.mbn.sinod.model.dto.SumaDesgloseDTO;
import com.mbn.sinod.model.entidades.Tsgnomempquincena;
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
 * @author torre
 */
public class SumaDesgloseWSClient {
    
    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(SumaDesgloseWSClient.class);
    
     public static List<Tsgnomempquincena> sumaDesglose(Integer empleado, Integer cabecera) {
      JSONObject json;
      SumaDesgloseDTO dto = new SumaDesgloseDTO();
      try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("empleado", empleado);
            paramMap.put("cabecera", cabecera);
            //System.out.println("-->Empledos > Param: " + paramMap );
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_SUMA_DETALLE_DESGLOSE), paramMap);
            //System.out.println("-->Empleados > URI: " + uri );
             dto = TEMPLATE.postForObject(uri, dto, SumaDesgloseDTO.class);
            //System.out.println("-->Empleados > DTO obtenido ");
            return dto.getListConceptosSum();
        } catch (JSONException | RestClientException e) {
            System.err.println("-->Error: No se pueden listar el total");
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }//end try catch
    }//end listar
     
     private static SumaDesgloseDTO errorWebService() {
        SumaDesgloseDTO dto = new SumaDesgloseDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }
}

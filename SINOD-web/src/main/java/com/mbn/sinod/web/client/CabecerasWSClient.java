/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mbn.sinod.model.dto.CabeceraDTO;
import com.mbn.sinod.model.dto.EmpQuincenaPorCabeceraDTO;
import com.mbn.sinod.model.entidades.Tsgnomcabecera;
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
 * @author eduardotorres
 */
public class CabecerasWSClient {

    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(CabecerasWSClient.class.getName());

    public static List<Tsgnomcabecera> listaCabecera() {
        JSONObject json;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTA_CABECERAS), paramMap);
            System.out.println("-->todos cabeceras > URI: " + uri );
            CabeceraDTO dto = TEMPLATE.getForObject(uri, CabeceraDTO.class);
            return dto.getListarCabecera();
        } catch (JSONException | RestClientException e) {
            logger.error(e.getMessage());
            System.err.println("-->Error: No se pueden listar las cabeceras");
            e.printStackTrace();
            return null;
        }
    }

    public static CabeceraDTO guardarCabecera(CabeceraDTO dto) throws JsonProcessingException {
        JSONObject json;
        CabeceraDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_GUARDAR_CABECERAS), paramMap);
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, CabeceraDTO.class);
        } catch (HttpClientErrorException | JSONException jsone) {
            logger.error(jsone.getMessage());
            dtoRespuesta = errorWebService();
        }
        return dtoRespuesta;
    }

    public static CabeceraDTO cabeceraPorId(Integer id) {
        JSONObject json;
        CabeceraDTO dto = new CabeceraDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("cabeceraId", id);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_OBTENER_CABECERA_POR_ID), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, CabeceraDTO.class);
        } catch (HttpServerErrorException | JSONException hsee) {
            logger.error(hsee.getMessage());
            dto = errorWebService();
        }
        return dto;
    }

    public static CabeceraDTO calculoNomina(Integer id) throws JsonProcessingException {
        JSONObject json;
        CabeceraDTO dto = new CabeceraDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("cabeceraid_fk", id);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_CALCULA_NOMINA), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, CabeceraDTO.class);
        } catch (HttpServerErrorException | JSONException hsee) {
            logger.error(hsee.getMessage());
            dto = errorWebService();
        }
        return dto;
    }

    public static List<EmpQuincenaPorCabeceraDTO> listarEmpleadosCabecera(Integer id) throws JsonProcessingException {
        JSONObject json;
        EmpQuincenaPorCabeceraDTO dto = new EmpQuincenaPorCabeceraDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("cabeceraid", id);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTAR_EMPLEADOS_CABECERA), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, EmpQuincenaPorCabeceraDTO.class);
        } catch (HttpServerErrorException | JSONException hsee) {
            logger.error(hsee.getMessage());
            errorWebService();
        }
        return dto.getListaEmpQuincenaPorCabeceraDTO();
    }

    public static CabeceraDTO eliminarCabecera(Integer cabeceraId) throws JsonProcessingException {
        JSONObject json;
        CabeceraDTO dto = new CabeceraDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("cabeceraId", cabeceraId);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_ELIMINAR_CABECERA), paramMap);
            System.out.println("ss " + uri);
            dto = TEMPLATE.postForObject(uri, dto, CabeceraDTO.class);
        } catch (HttpServerErrorException | JSONException hsee) {
            logger.error(hsee.getMessage());
            dto = errorWebService();
        }
        return dto;
    }

    public static CabeceraDTO validaPagosNomina(Integer cabeceraId)  {
        JSONObject json;
        CabeceraDTO dto = new CabeceraDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("cabeceraId", cabeceraId);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_VALIDAR_PAGOS_NOMINA), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, CabeceraDTO.class);
        } catch (HttpServerErrorException | JSONException hsee) {
            logger.error(hsee.getMessage());
            dto = errorWebService();
        }
        return dto;
    }

    public static CabeceraDTO cargarImss(String archivo, Integer cabeceraId)  {
        JSONObject json;
        CabeceraDTO dto = new CabeceraDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("archivo", archivo);
            paramMap.put("cabeceraId", cabeceraId);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_CARGAR_IMSS), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, CabeceraDTO.class);
        } catch (HttpServerErrorException | JSONException hsee) {
            logger.error(hsee.getMessage());
            dto = errorWebService();
        }
        return dto;
    }

    private static CabeceraDTO errorWebService() {
        CabeceraDTO dto = new CabeceraDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }
}

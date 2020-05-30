package com.mbn.sinod.web.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbn.sinod.model.dto.ArgumentoDTO;
import com.mbn.sinod.model.entidades.Tsgnomargumento;
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
 * @author mariana
 */
public class ArgumentoWSClient {

    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(ArgumentoWSClient.class.getName());

    public static List<Tsgnomargumento> listarArgumentos() {
        JSONObject json;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTAR_ARGUMENTOS), paramMap);
            ArgumentoDTO dto = TEMPLATE.getForObject(uri, ArgumentoDTO.class);
            return dto.getListaArgumentos();
        } catch (JSONException | RestClientException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }//end try catch
    }//end listar

    public static List<Tsgnomargumento> listarArgumentosConstantes() {
        JSONObject json;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTAR_ARGUMENTOS_CONSTANTES), paramMap);
            ArgumentoDTO dto = TEMPLATE.getForObject(uri, ArgumentoDTO.class);
            return dto.getListaArgumentos();
        } catch (JSONException | RestClientException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }//end try catch
    }//end listar

    public static List<Tsgnomargumento> listarArgumentosVariables() {
        JSONObject json;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_LISTAR_ARGUMENTOS_VARIABLES), paramMap);
            ArgumentoDTO dto = TEMPLATE.getForObject(uri, ArgumentoDTO.class);
            return dto.getListaArgumentos();
        } catch (JSONException | RestClientException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }//end try catch
    }//end listar

    public static ArgumentoDTO guardarArgumento(ArgumentoDTO dto) throws JsonProcessingException {
        JSONObject json;
        ArgumentoDTO dtoRespuesta;
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, TokenController.getTokenValue(json));
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_GUARDAR_ARGUMENTO), paramMap);
            dtoRespuesta = TEMPLATE.postForObject(uri, dto, ArgumentoDTO.class);
            ObjectMapper mapper = new ObjectMapper();
        } catch (HttpClientErrorException | JSONException jsone) {
            logger.error(jsone.getMessage());
            dtoRespuesta = errorWebService();
        }
        return dtoRespuesta;
    }

    public static ArgumentoDTO eliminarArgumento(Integer id) throws JsonProcessingException {
        JSONObject json;
        ArgumentoDTO dto = new ArgumentoDTO();
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("argumentoid", id);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_ELIMINAR_ARGUMENTO), paramMap);
            dto = TEMPLATE.postForObject(uri, dto, ArgumentoDTO.class);
        } catch (HttpServerErrorException | JSONException hsee) {
            logger.error(hsee.getMessage());
            dto = errorWebService();
        }
        return dto;
    }

    private static ArgumentoDTO errorWebService() {
        ArgumentoDTO dto = new ArgumentoDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }
}

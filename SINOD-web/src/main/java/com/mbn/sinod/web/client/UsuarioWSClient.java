
package com.mbn.sinod.web.client;

import com.mbn.sinod.model.dto.UsuarioDTO;
import com.mbn.sinod.model.entidades.Usuario;
import com.mbn.sinod.web.util.ResourceBundles;
import com.mbn.sinod.web.util.StaticsConstants;
import com.mbn.sinod.web.util.TokenController;
import com.mbn.sinod.web.util.URIBuilder;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import org.primefaces.json.JSONObject;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author MBN USER
 */
public class UsuarioWSClient {

    private static final RestTemplate TEMPLATE = new RestTemplate();
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(UsuarioWSClient.class.getName());

    public static Usuario obtenerUsuarioPorId(Integer usuarioId) {
        JSONObject json;
        
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(StaticsConstants.ACCESS_TOKEN, json.get(StaticsConstants.ACCESS_VALUE));
            paramMap.put("usuarioId", usuarioId);
            URI uri = URIBuilder.buildWSUri(BUNDLE.getString(StaticsConstants.WS_OBTENER_USUARIO_ID), paramMap);
            UsuarioDTO dto = new UsuarioDTO();
            Usuario usuario = new Usuario();
            usuario.setCod_usuario(usuarioId);
            dto.setUsuario(usuario);
            dto = TEMPLATE.postForObject(uri, dto, UsuarioDTO.class);
            return dto.getUsuario();
        } catch (Exception e) {
            logger.error("Error consultando usuario por id: ", e);
            e.printStackTrace();
            return null;
        }
    }
}


package com.mbn.sinod.web.client;

import com.mbn.sinod.model.dto.CatalogosDTO;
import com.mbn.sinod.web.util.ResourceBundles;
import com.mbn.sinod.web.util.StaticsConstants;
import com.mbn.sinod.web.util.TokenController;
import com.mbn.sinod.web.util.URIBuilder;
import java.io.Serializable;
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
 * Clase que contiene los clientes para los web services de catalogos
 * @author Francisco Rolando Muñoz
 */
public class CatalogosWSClient implements Serializable {

   
    private static final long serialVersionUID = 4125505312260534349L;
    private static final ResourceBundle bundle = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final Logger logger = Logger.getLogger(CatalogosWSClient.class);
    private static final RestTemplate template = new RestTemplate();
    
      /**
       * Cliente para Web service de tipo rest que permite obtener los datos de un catalogo
       * 
       * @param clazz
       * @return 
       */
      public static CatalogosDTO obtenerCatalogo(Class clazz) {
        JSONObject json;
        CatalogosDTO dto = new CatalogosDTO();
        dto.setClazz(clazz);
        try {
            json = new JSONObject(TokenController.getAccessToken());
            Map<Integer, Object> paramMap = new HashMap<>();
            String token = StaticsConstants.ACCESS_TOKEN + "=" + json.get(StaticsConstants.ACCESS_VALUE).toString();
            URI uri = URIBuilder.buildWSUriMap(bundle.getString(StaticsConstants.WS_OBETENER_CATALOGO), paramMap, token);
            dto = template.postForObject(uri, dto, CatalogosDTO.class);
         } catch (HttpServerErrorException | JSONException hsee) {
            logger.error(hsee.getMessage());            
            errorWebService();
        }
        return dto;
    }
      
      
       private static CatalogosDTO errorWebService() {
        CatalogosDTO dto = new CatalogosDTO();
        dto.setTipoMensaje(0);
        dto.setCodigoMensaje("E999");
        return dto;
    }
}

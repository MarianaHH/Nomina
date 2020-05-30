package com.mbn.sinod.web.util;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class TokenController {

    private static final ResourceBundle bundle = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private static final RestTemplate template = new RestTemplate();

    public static String getAccessToken() {
        //Build the param map
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("grant_type", StaticsConstants.GRANT_PASSWORD);
        paramMap.put("client_id", bundle.getString(StaticsConstants.TOKEN_CLIENTID));
        paramMap.put("client_secret", bundle.getString(StaticsConstants.TOKEN_SECRET));
        paramMap.put("username", bundle.getString(StaticsConstants.TOKEN_USER));
        paramMap.put("password", bundle.getString(StaticsConstants.TOKEN_PWD));

        //Build URI to call oauth/token Web Service
        URI uri = URIBuilder.buildWSUri(bundle.getString(StaticsConstants.TOKEN_PATH), paramMap);

        return template.getForObject(uri, String.class);
    }
    
     public static String getTokenValue(JSONObject json){
        String tokenValue = null;
        try {
            tokenValue = json.getString("value");
        } catch (JSONException ex) {
            try {
                tokenValue = json.getString("access_token");
            } catch (JSONException ex1) {
                Logger.getLogger(TokenController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return tokenValue;
    }
    
}

package com.mbn.sinod.web.util;

import java.net.URI;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.web.util.UriComponentsBuilder;

public class URIBuilder {
	private static final ResourceBundle bundle = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
	
	public static URI buildWSUri(String path, Map<String, Object> paramMap){
		UriComponentsBuilder ucb = UriComponentsBuilder.fromUriString(bundle.getString(StaticsConstants.WS_URL_HOST));
		ucb.path(path);
		for(String key : paramMap.keySet()){
			ucb.queryParam(key, paramMap.get(key));
		}
		return ucb.build().toUri();
	}
        
        
        public static URI buildWSUriMap(String path, Map<Integer, Object> parametros,String token){
		UriComponentsBuilder ucb = UriComponentsBuilder.fromUriString(bundle.getString(StaticsConstants.WS_URL_HOST));
		for (Integer lIindice : parametros.keySet()) {
                    path+= "/"+parametros.get(lIindice);
                }
                ucb.path(path);
                ucb.query(token);
		return ucb.build().toUri();
	}
}

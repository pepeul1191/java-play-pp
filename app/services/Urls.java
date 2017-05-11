package services;

import java.util.HashMap;
import java.util.Map;

public final class Urls {			
	public static String getStaticURL() {
        return "http://localhost:8001/html-unify/";
    }
	
	public static String getBaseURL() {
        return "http://localhost:9000/";
    }
	
	public static String getUrlServicio(String servicio){
		Map<String, String> urlServicios = new HashMap<String, String>();
		urlServicios.put("cipher", "http://localhost/cipher/");
		urlServicios.put("accesos", "http://localhost/accesos/");
		
		return urlServicios.get(servicio);
	}
}

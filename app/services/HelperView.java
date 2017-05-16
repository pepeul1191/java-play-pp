package services;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class HelperView {
	public static String getNombreApp() {
        return "SISTEMA_ACCESOS";
    }
	
	public static String loadCSS(String[] csss){
		String rpta = "";
		
		if(csss != null){
			for(String css : csss){
				rpta = rpta + "<link rel='stylesheet' type='text/css' href='" + Urls.getStaticURL() + css + ".css'/>";
			}
		}
		
		return rpta;
	}
	
	public static String loadJS(String[] jss){
		String rpta = "";
		
		if(jss != null){
			for(String js : jss){
				rpta = rpta + "<script src='" + Urls.getStaticURL() + js + ".js' type='text/javascript' /></script>";
			}
		}
		
		return rpta;		
	}
	
	public static String menuModulos(String nombreModulo){
		String rpta = "";
		String url = Urls.getUrlServicio("accesos") + "modulo/listar_menu?sistema=" + getNombreApp();
		Httparty httparty = new Httparty(url, "GET");
		httparty.action();
		
		JsonParser parser = new JsonParser();
		JsonElement menusElement = parser.parse(httparty.getRpta());
		JsonArray menus = menusElement .getAsJsonArray();
		
		for(JsonElement menu : menus){
			JsonObject menuJsonObject = menu.getAsJsonObject();
			
			if(menuJsonObject.get("nombre").getAsString().equalsIgnoreCase(nombreModulo)){
				rpta = rpta + "<li class='dropdown active'><a href='" + Urls.getBaseURL() + menuJsonObject.get("url").getAsString() + 
						"' class='dropdown-toggle' data-toggle='dropdown'>" + menuJsonObject.get("nombre").getAsString() + "</a></li>";
			}else{
				rpta = rpta + "<li class='dropdown'><a href='" + Urls.getBaseURL() + menuJsonObject.get("url").getAsString() + 
						"' class='dropdown-toggle' data-toggle='dropdown'>" + menuJsonObject.get("nombre").getAsString() + "</a></li>";
			}
		}
		
		return rpta;
	}
	
	public static String menuSubmodulos(String nombreModulo){
		String rpta = "";
		
		return rpta;
	}
}

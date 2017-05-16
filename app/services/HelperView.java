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
	
	public static String menuSubModulos(String nombreModulo){
		String rpta = "<ul class='list-group sidebar-nav-v1' id='sidebar-nav'>";
		String url = Urls.getUrlServicio("accesos") + "item/listar/menu/?sistema=" + getNombreApp() + "&nombre_modulo=" + nombreModulo;
		System.out.println(url);
		Httparty httparty = new Httparty(url, "GET");
		httparty.action();
		
		JsonParser parser = new JsonParser();
		JsonElement menusElement = parser.parse(httparty.getRpta());
		JsonArray menus = menusElement .getAsJsonArray();
		
		for(JsonElement menu : menus){
			JsonObject menuJsonObject = menu.getAsJsonObject();
			
			rpta = rpta + "<li class='list-group-item list-toggle'><span>" + menuJsonObject.get("subtitulo").getAsString() +"</span>";
			rpta = rpta + "<ul id='collapse-forms' class='collapse in' aria-expanded='true'>";
			
			JsonArray itemsArray = menuJsonObject.get("items").getAsJsonArray();
			
			for(JsonElement item : itemsArray){
				JsonObject itemJsonObject = item.getAsJsonObject();
				
				//$rpta = $rpta . '<li><a href="' . Url::base_url() . $item->{'url'} . '">' . $item->{'item'} . '</a></li>';
				rpta = rpta + "<li><a href='" + Urls.getBaseURL() +itemJsonObject.get("url").getAsString() + "'>" + itemJsonObject.get("item").getAsString() + "</a></li>";
			}
			
			rpta = rpta + "</ul>";
		}
		
		rpta = rpta + "</ul>";
		
		return rpta;
	}
}

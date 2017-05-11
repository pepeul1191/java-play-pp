package services;

public class HelperView {
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
		
		return rpta;
	}
	
	public static String menuSubmodulos(String nombreModulo){
		String rpta = "";
		
		return rpta;
	}
}

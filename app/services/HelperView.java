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
		
		/*
		 $rpta = '';

        foreach ($array_js as &$js) {
            $temp = '<script src="' . Url::statics() . $js . '.js" type="text/javascript"></script>';
            $rpta = $rpta . $temp;
        }

        return $rpta;
		 * */
		
	}
}

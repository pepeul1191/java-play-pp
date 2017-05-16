package controllers;

import java.util.HashMap;
import java.util.Map;

import play.mvc.*;

//import views.html.*;
import views.html.home.*;

public class HomeController extends Controller {

    public Result index() {
    	Map<String, String> labels = new HashMap<String, String>();
        labels.put("titulo", "Home");
        labels.put("tituloSitio", "Home");
        labels.put("nombreModulo", "");
        
        String titulo = "Home";
        String[] csss = {"assets/login/css/index"};
        String[] jss = {"assets/login/js/index"};
                
    	return ok(views.html.home.index.render(titulo, csss, jss, labels));
    }

}

package controllers;

import java.util.HashMap;
import java.util.Map;

import play.mvc.*;

//import views.html.*;
import views.html.home.*;

public class HomeController extends Controller {

    public Result index() {
    	Map<String, String> labels = new HashMap<String, String>();
        labels.put("titulo", "Bienvenido");
        
        String titulo = "Bienvenido";
        String[] csss = {"assets/login/css/index"};
        String[] jss = {"assets/login/js/index"};
                
    	return ok(views.html.home.index.render(labels, csss, jss));
    	//return ok(index.render("Your new application is ready???."));
    }

}

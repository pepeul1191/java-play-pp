package controllers;

import java.util.HashMap;
import java.util.Map;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import services.Httparty;
import services.Urls;
import views.html.login.*;

public class LoginController extends Controller {

    public Result index() {
    	Map<String, String> labels = new HashMap<String, String>();
        labels.put("mensaje", "0");
        boolean mensaje = false;
        String titulo = "Bienvenido";
        String[] csss = {"assets/login/css/index"};
        String[] jss = {"assets/login/js/index"};
                
    	return ok(views.html.login.index.render(titulo, csss, jss, labels, mensaje));
    }
    
    public Result acceder() {
    	DynamicForm dynamicForm = Form.form().bindFromRequest();
    	String usuario = dynamicForm.get("usuario");
    	String contrasenia = dynamicForm.get("contrasenia");
    	
    	Map<String, String> labels = new HashMap<String, String>();
    	String url = Urls.getUrlServicio("accesos") + "usuario/validar?usuario=" + usuario + "&contrasenia=" + contrasenia;
		Httparty httparty = new Httparty(url, "POST");
		httparty.action();
		 		 
		if(httparty.getRpta().equalsIgnoreCase("1")){
			//ok("HOME").as("text/html");
			return redirect(Urls.getBaseURL());
		}else{
			labels.put("mensaje", "1");
	        boolean mensaje = true;
	        String titulo = "Bienvenido";
	        String[] csss = {"assets/login/css/index"};
	        String[] jss = {"assets/login/js/index"};
	                
	    	return ok(views.html.login.index.render(titulo, csss, jss, labels, mensaje));
		}
    }
}

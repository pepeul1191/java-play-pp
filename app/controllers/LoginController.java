package controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			
			session("autenticado", String.valueOf(true));
			session("usuario", usuario);
			session("tiempo", date.toString());
						
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
    
    public Result ver(){
    	String rpta = "usuario : " + session("usuario") + "</br> estado : " + session("autenticado") + "</br>tiempo : " + session("tiempo") ;
    	
    	return ok(rpta).as("text/html; charset=iso-8859-1");
    }
}

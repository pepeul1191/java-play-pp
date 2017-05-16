package controllers.accesos;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import play.data.Form;
import play.mvc.*;
import services.Httparty;
import services.Urls;
import views.html.home.*;
import play.data.DynamicForm;
import play.data.Form;

public class SistemaController extends Controller {

    public Result index() {
    	Map<String, String> labels = new HashMap<String, String>();
        labels.put("titulo", "Home");
        labels.put("tituloSitio", "Gestión de Usuarios");
        labels.put("nombreModulo", "Accesos");
        
        String titulo = "Home";
        String[] csss = {"bower_components/swp-plugins/assets/css/mootools.grid"};
        String[] jss = {"bower_components/swp-plugins/assets/js/mootools.dao", "bower_components/swp-plugins/assets/js/mootools.form", 
        		"bower_components/swp-plugins/assets/js/mootools.observer", "bower_components/swp-plugins/assets/js/mootools.grid", 
        		"bower_components/swp-plugins/assets/js/mootools.chain", "assets/accesos/sistema/js/index"};
                
    	return ok(views.html.accesos.sistema.index.render(titulo, csss, jss, labels));
    }
    
    public Result listar() {
    	String url = Urls.getUrlServicio("accesos") + "sistema/listar";
		Httparty httparty = new Httparty(url, "GET");
		httparty.action();
		
    	return ok(httparty.getRpta()).as("text/html; charset=iso-8859-1");
    }

    public Result guardar(){
    	DynamicForm dynamicForm = Form.form().bindFromRequest();
    	String data = dynamicForm.get("data");
    	String url = Urls.getUrlServicio("accesos") + "sistema/guardar?data=" + data;
		Httparty httparty = new Httparty(url, "POST");
		httparty.action();
    	
    	return ok(httparty.getRpta()).as("text/html; charset=iso-8859-1");
    }
}

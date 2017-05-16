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

public class UsuarioController extends Controller {

    public Result index() {
    	Map<String, String> labels = new HashMap<String, String>();
        labels.put("titulo", "Home");
        labels.put("tituloSitio", "Gestión de Usuarios");
        labels.put("nombreModulo", "Accesos");
        
        String titulo = "Home";
        String[] csss = {"bower_components/swp-plugins/assets/css/mootools.grid"};
        String[] jss = {"bower_components/swp-plugins/assets/js/mootools.dao", "bower_components/swp-plugins/assets/js/mootools.form", 
        		"bower_components/swp-plugins/assets/js/mootools.observer", "bower_components/swp-plugins/assets/js/mootools.grid", 
        		"bower_components/swp-plugins/assets/js/mootools.chain", "assets/accesos/usuarios/js/index"};
                
    	return ok(views.html.accesos.usuario.index.render(titulo, csss, jss, labels));
    }
    
    public Result listar() {
    	String url = Urls.getUrlServicio("accesos") + "usuario/listar";
		Httparty httparty = new Httparty(url, "GET");
		httparty.action();
		
    	return ok(httparty.getRpta()).as("text/html; charset=iso-8859-1");
    }

    public Result verAccesos(){        
        String tituloModal = "Ver Accesos";
        String[] csssModal= {"bower_components/swp-plugins/assets/css/mootools.grid"};
        String[] jssModal = {"assets/accesos/usuarios/js/accesos"};
                
    	return ok(views.html.accesos.usuario.accesos.render(tituloModal, csssModal, jssModal));
    }
    
    public Result listarAccesos(Long usuarioId){
    	String url = Urls.getUrlServicio("accesos") + "usuario/listar_accesos/" + usuarioId;
		Httparty httparty = new Httparty(url, "GET");
		httparty.action();
		
    	return ok(httparty.getRpta()).as("text/html; charset=iso-8859-1");
    }
    
    public Result verRolesPermisos(){
    	String tituloModal = "Gestione los Roles y Permisos del Usuario";
    	String[] csssModal= {""};
        String[] jssModal = {"assets/accesos/usuarios/js/roles_permisos"};
                
    	return ok(views.html.accesos.usuario.roles_permisos.render(tituloModal, csssModal, jssModal));
    }
    
    public Result listarRoles(Long usuarioId){
    	String url = Urls.getUrlServicio("accesos") + "usuario/listar_permisos/" + usuarioId;
		Httparty httparty = new Httparty(url, "GET");
		httparty.action();
		
    	return ok(httparty.getRpta()).as("text/html; charset=iso-8859-1");
    }
    
    public Result listarPermisos(Long usuarioId){
    	String url = Urls.getUrlServicio("accesos") + "usuario/listar_roles/" + usuarioId;
		Httparty httparty = new Httparty(url, "GET");
		httparty.action();
    	return ok(httparty.getRpta()).as("text/html; charset=iso-8859-1");
    }
    
    public Result asociarPermisos(){
    	DynamicForm dynamicForm = Form.form().bindFromRequest();
    	String data = dynamicForm.get("data");
    	String url = Urls.getUrlServicio("accesos") + "usuario/asociar_permisos?data=" + data;
		Httparty httparty = new Httparty(url, "POST");
		httparty.action();
    	
    	return ok(httparty.getRpta()).as("text/html; charset=iso-8859-1");
    }
    
    public Result asociarRoles(){
    	DynamicForm dynamicForm = Form.form().bindFromRequest();
    	String data = dynamicForm.get("data");
    	String url = Urls.getUrlServicio("accesos") + "usuario/asociar_roles?data=" + data;
		Httparty httparty = new Httparty(url, "POST");
		httparty.action();
    	
    	return ok(httparty.getRpta()).as("text/html; charset=iso-8859-1");
    }
}

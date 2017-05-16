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

public class SubtituloController extends Controller {
    public Result listar(Long moduloId) {
    	String url = Urls.getUrlServicio("accesos") + "subtitulo/listar/" + moduloId;
		Httparty httparty = new Httparty(url, "GET");
		httparty.action();
		
    	return ok(httparty.getRpta()).as("text/html; charset=iso-8859-1");
    }

    public Result guardar(){
    	DynamicForm dynamicForm = Form.form().bindFromRequest();
    	String data = dynamicForm.get("data");
    	String url = Urls.getUrlServicio("accesos") + "subtitulo/guardar?data=" + data;
		Httparty httparty = new Httparty(url, "POST");
		httparty.action();
    	
    	return ok(httparty.getRpta()).as("text/html; charset=iso-8859-1");
    }
}

package controllers;

import play.mvc.*;

//import views.html.*;
import views.html.home.*;

public class HomeController extends Controller {

    public Result index() {
        //return ok(index.render("Your new application is ready???."));
    	return ok(index.render());
    }

}

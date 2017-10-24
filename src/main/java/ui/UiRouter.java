package ui;

import conf.Enviroment;
import spark.Router;
import spark.Spark;

public class UiRouter implements Router {

    private final String appContext = Enviroment.APP_CONTEXT.getProperty();

    @Override
    public void routeServices() {
        Spark.redirect.any("/" + appContext, "/" + appContext + "/");
    }


}

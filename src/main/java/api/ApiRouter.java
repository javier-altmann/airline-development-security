package api;

import conf.Enviroment;
import spark.Router;
import spark.Spark;

import javax.inject.Inject;

import static spark.Spark.get;


public class ApiRouter implements Router {

    private final ApiService apiService;
    private final String appContext = Enviroment.APP_CONTEXT.getProperty();
    private final String appVersion = Enviroment.APP_VERSION.getProperty();

    @Inject
    public ApiRouter(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void routeServices() {

        Spark.get("/" + appContext + "/version", (req, res) -> appVersion);

        Spark.get("/HolaVale", (req, res) -> apiService.saludar());

    }

}

package api;

import conf.ConnectionDB;
import conf.Enviroment;
import spark.Router;
import spark.Spark;

import javax.inject.Inject;

public class ApiRouter implements Router {

    private final ApiService apiService;
    private ConnectionDB connection;


    private final String apiContext = Enviroment.API_CONTEXT.getProperty();
    private final String appVersion = Enviroment.APP_VERSION.getProperty();

    @Inject
    public ApiRouter(ApiService apiService, ConnectionDB connection) {

        this.apiService = apiService;
        this.connection = connection;
    }

    @Override
    public void routeServices() {

        Spark.get("/" + apiContext + "/version", (req, res) -> appVersion);

        Spark.get("/" + apiContext + "/destinations", (req, res) -> apiService.getDestination(connection.getConnection()));


    }
}

package api;

import conf.ConnectionDB;
import conf.Enviroment;
import spark.Router;
import spark.Spark;

import javax.inject.Inject;

public class ApiRouter implements Router {

    private final ApiService apiService;
    private ConnectionDB connection;


    private final String appContext = Enviroment.APP_CONTEXT.getProperty();
    private final String appVersion = Enviroment.APP_VERSION.getProperty();

    @Inject
    public ApiRouter(ApiService apiService, ConnectionDB connection) {

        this.apiService = apiService;
        this.connection = connection;
    }

    @Override
    public void routeServices() {

        Spark.get("/" + appContext + "/version", (req, res) -> appVersion);

        Spark.get("/" + appContext + "/destinations", (req, res) -> apiService.getDestination(connection.getConnection()));
    }

}

package api;

import com.google.gson.Gson;
import conf.ConnectionDB;
import conf.Enviroment;
import models.*;


import javax.inject.Inject;

import spark.Router;

import static spark.Spark.*;

public class ApiRouter implements Router {

    private final ApiService apiService;
    private ConnectionDB connection;

    private final String apiContext = Enviroment.API_CONTEXT.getProperty();
    private final String appVersion = Enviroment.APP_VERSION.getProperty();
    private Gson jsonParser;
    private String response;

    @Inject
    public ApiRouter(ApiService apiService, ConnectionDB connection, Gson jsonParser) {
        this.apiService = apiService;
        this.connection = connection;
        this.jsonParser = jsonParser;
    }

    @Override
    public void routeServices() {

        options("/*",
                (request, response) -> {

                    String accessControlRequestHeaders = request
                            .headers("Access-Control-Request-Headers");
                    if (accessControlRequestHeaders != null) {
                        response.header("Access-Control-Allow-Headers",
                                accessControlRequestHeaders);
                    }

                    String accessControlRequestMethod = request
                            .headers("Access-Control-Request-Method");
                    if (accessControlRequestMethod != null) {
                        response.header("Access-Control-Allow-Methods",
                                accessControlRequestMethod);
                    }

                    return "OK";
                });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        get("/" + apiContext + "/version/", (req, res) -> appVersion);


        // ----------------------- API /LOGIN
        post("/" + apiContext + "/login/", (req, res) -> {
                    response = apiService.authenticateUser(connection.getConnection(), jsonParser.fromJson(req.body(), UserDTO.class));
                    return response;
                }
        );

    }
}

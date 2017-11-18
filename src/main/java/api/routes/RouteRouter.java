package api.routes;

import com.google.gson.Gson;
import conf.ConnectionDB;
import conf.Enviroment;
import models.RouteDTO;
import spark.Router;

import javax.inject.Inject;

import static spark.Spark.get;
import static spark.Spark.post;

public class RouteRouter implements Router {

    private final RouteService routeService;
    private ConnectionDB connection;

    private final String apiContext = Enviroment.API_CONTEXT.getProperty();
    private Gson jsonParser;
    private String response;

    @Inject
    public RouteRouter(RouteService routeService, ConnectionDB connection, Gson jsonParser) {
        this.routeService = routeService;
        this.connection = connection;
        this.jsonParser = jsonParser;
    }

    @Override
    public void routeServices() {

        // ----------------------- API /ROUTES
        get("/" + apiContext + "/routes", (req, res) -> {
            response = routeService.getRoutes(connection.getConnection());
            return response;
        });

        post("/" + apiContext + "/routes/create", (req, res) -> {
                    response = routeService.createRoute(connection.getConnection(), jsonParser.fromJson(req.body(), RouteDTO.class));
                    return response;
                }
        );
    }
}

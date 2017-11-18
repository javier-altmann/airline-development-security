package api.destinations;

import com.google.gson.Gson;
import conf.ConnectionDB;
import conf.Enviroment;
import models.DestinationDTO;
import spark.Router;

import javax.inject.Inject;

import static spark.Spark.get;
import static spark.Spark.post;


public class DestinationRouter implements Router {

    private final DestinationService destinationService;
    private ConnectionDB connection;

    private final String apiContext = Enviroment.API_CONTEXT.getProperty();
    private Gson jsonParser;
    private String response;

    @Inject
    public DestinationRouter(DestinationService destinationService, ConnectionDB connection, Gson jsonParser) {
        this.destinationService = destinationService;
        this.connection = connection;
        this.jsonParser = jsonParser;
    }

    @Override
    public void routeServices() {

        get("/" + apiContext + "/destinations", (req, res) -> {
                    response = destinationService.getDestinations(connection.getConnection());
                    return response;
                }
        );

        post("/" + apiContext + "/destinations/create", (req, res) -> {
                    response = destinationService.createDestination(connection.getConnection(), jsonParser.fromJson(req.body(), DestinationDTO.class));
                    return response;
                }
        );


    }
}

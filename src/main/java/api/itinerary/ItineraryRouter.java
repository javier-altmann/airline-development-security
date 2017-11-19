package api.itinerary;

import com.google.gson.Gson;
import conf.ConnectionDB;
import conf.Enviroment;
import models.ItineraryDTO;
import spark.Router;

import javax.inject.Inject;

import static spark.Spark.get;
import static spark.Spark.post;

public class ItineraryRouter implements Router {

    private final ItineraryService routeService;
    private ConnectionDB connection;

    private final String apiContext = Enviroment.API_CONTEXT.getProperty();
    private Gson jsonParser;
    private String response;

    @Inject
    public ItineraryRouter(ItineraryService itineraryService, ConnectionDB connection, Gson jsonParser) {
        this.routeService = itineraryService;
        this.connection = connection;
        this.jsonParser = jsonParser;
    }

    @Override
    public void routeServices() {

        get("/" + apiContext + "/itineraries/", (req, res) -> {
            response = routeService.getItineraries(connection.getConnection());
            return response;
        });

        get("/" + apiContext + "/itinerary/:id/", (req, res) -> {
            response = routeService.getItinerary(connection.getConnection(), Integer.parseInt(req.params(":id")));
            return response;
        });

        post("/" + apiContext + "/itinerary/", (req, res) -> {
                    response = routeService.createItinerary(connection.getConnection(), jsonParser.fromJson(req.body(), ItineraryDTO.class));
                    return response;
                }
        );
    }
}

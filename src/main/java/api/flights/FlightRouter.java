package api.flights;

import com.google.gson.Gson;
import conf.ConnectionDB;
import conf.Enviroment;
import models.*;
import spark.Router;

import javax.inject.Inject;

import static spark.Spark.get;
import static spark.Spark.post;


public class FlightRouter implements Router {

    private final FlightService flightService;
    private ConnectionDB connection;

    private final String apiContext = Enviroment.API_CONTEXT.getProperty();
    private Gson jsonParser;
    private String response;

    @Inject
    public FlightRouter(FlightService flightService, ConnectionDB connection, Gson jsonParser) {
        this.flightService = flightService;
        this.connection = connection;
        this.jsonParser = jsonParser;
    }

    @Override
    public void routeServices() {

        get("/" + apiContext + "/flights/", (req, res) -> {
                    response = flightService.getFlights(connection.getConnection());
                    return response;
                }
        );

        post("/" + apiContext + "/flight/", (req, res) -> {
                    response = flightService.createFlight(connection.getConnection(), jsonParser.fromJson(req.body(), FlightDTO.class));
                    return response;
                }
        );
        get("/" + apiContext + "/flight/:id/", (req, res) -> {
                    response = flightService.getFlight(connection.getConnection(), Integer.parseInt(req.params(":id")));
                    return response;
                }
        );

        get("/" + apiContext + "/flight/:id/seats-available/", (req, res) -> {
                    response = flightService.getSeatsAvailableFromFlight(connection.getConnection(), Integer.parseInt(req.params(":id")));
                    return response;
                }
        );

        get("/" + apiContext + "/flights/itinerary/", (req, res) -> {
                    response = flightService.getFlightsWithItinerary(connection.getConnection());
                    return response;
                }
        );

        get("/" + apiContext + "/flight/:id/itinerary/", (req, res) -> {
                    response = flightService.getFlightWithItinerary(connection.getConnection(), Integer.parseInt(req.params(":id")));
                    return response;
                }
        );



/*
        post("/" + apiContext + "/flights/schedule", (req, res) ->

        );

        post("/" + apiContext + "/flights/close", (req, res) ->

        );

        post("/" + apiContext + "/flights/sell", (req, res) ->

        );
*/


    }
}

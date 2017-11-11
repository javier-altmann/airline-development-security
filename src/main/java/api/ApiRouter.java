package api;

import com.google.gson.Gson;
import conf.ConnectionDB;
import conf.Enviroment;
import models.AircraftDTO;
import models.FlightDTO;


import javax.inject.Inject;

import models.UserDTO;
import spark.Router;


import static spark.Spark.get;
import static spark.Spark.post;

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

        get("/" + apiContext + "/version", (req, res) -> appVersion);


        // ----------------------- API /LOGIN
        post("/" + apiContext + "/login", (req, res) -> {
                    response = apiService.authenticateUser(connection.getConnection(), jsonParser.fromJson(req.body(), UserDTO.class));
                    return response;
                }
        );


        // ----------------------- API /FLIGHTS
        get("/" + apiContext + "/flights", (req, res) -> {
                    response = apiService.getFlights(connection.getConnection());
                    return response;
                }
        );

        post("/" + apiContext + "/flights/create", (req, res) -> {
                    response = apiService.createFlight(connection.getConnection(), jsonParser.fromJson(req.body(), FlightDTO.class));
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


        // ----------------------- API /AIRCRAFT
        get("/" + apiContext + "/aircrafts", (req, res) -> {
                    response = apiService.getAircrafts(connection.getConnection());
                    return response;
                }
        );

        post("/" + apiContext + "/aircrafts/create", (req, res) -> {
                    response = apiService.createAircraft(connection.getConnection(), jsonParser.fromJson(req.body(), AircraftDTO.class));
                    return response;
                }
        );

/*
        // ----------------------- API /DESTINATIONS
        get("/" + apiContext + "/destinations", (req, res) ->

        ));

        post("/" + apiContext + "/destinations/create", (req, res) ->

        ));

        // ----------------------- API /ROUTES
        post("/" + apiContext + "/routes", (req, res) ->

        ));

        post("/" + apiContext + "/routes/create", (req, res) ->

        ));*/

    }
}

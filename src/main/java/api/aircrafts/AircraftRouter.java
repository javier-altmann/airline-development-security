package api.aircrafts;

import com.google.gson.Gson;
import conf.ConnectionDB;
import conf.Enviroment;
import models.AircraftDTO;
import spark.Router;

import javax.inject.Inject;

import static spark.Spark.get;
import static spark.Spark.post;

public class AircraftRouter implements Router {

    private final AircraftService aicraftService;
    private ConnectionDB connection;

    private final String apiContext = Enviroment.API_CONTEXT.getProperty();
    private Gson jsonParser;
    private String response;

    @Inject
    public AircraftRouter(AircraftService aicraftService, ConnectionDB connection, Gson jsonParser) {
        this.aicraftService = aicraftService;
        this.connection = connection;
        this.jsonParser = jsonParser;
    }

    @Override
    public void routeServices() {


        get("/" + apiContext + "/aircrafts", (req, res) -> {
                    response = aicraftService.getAircrafts(connection.getConnection());
                    return response;
                }
        );

        post("/" + apiContext + "/aircrafts/create", (req, res) -> {
                    response = aicraftService.createAircraft(connection.getConnection(), jsonParser.fromJson(req.body(), AircraftDTO.class));
                    return response;
                }
        );


    }
}

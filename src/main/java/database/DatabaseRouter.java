package database;

import conf.ConnectionDB;
import spark.Router;
import spark.Spark;

import javax.inject.Inject;

public class DatabaseRouter implements Router {

    private ConnectionDB connection;

    @Inject
    public DatabaseRouter(ConnectionDB connection) {
        this.connection = connection;
    }

    @Override
    public void routeServices() {

        Spark.get("/database/healthcheck", (req, res) ->
                connection.getConnection().isClosed() ? "Sin conexión" : "Conx conexión"
        );


    }

}

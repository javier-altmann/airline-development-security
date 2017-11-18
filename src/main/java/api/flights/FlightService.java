package api.flights;

import models.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FlightService {

    private String response;
    private Statement st;
    private ResultSet rs;
    private String query;

    public String getFlights(Connection connection) {
        query = "SELECT array_to_json(array_agg(flight)) FROM flight";
        try {

            st = connection.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                response = rs.getString(1);
            }
            rs.close();
            st.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;

    }

    public String createFlight(Connection connection, FlightDTO flight) {
        query = "INSERT INTO public.flight\n" +
                "            (id_flight, id_aircraft, id_itinerary, id_passenger)\n" +
                "    VALUES" +
                "(" + flight.getId_flight() + ", " + flight.getId_aircraft() + "," + flight.getId_itinerary() + "," + flight.getId_passenger() + ");";
        try {

            st = connection.createStatement();

            if (st.executeUpdate(query) == 1) {
                response = "Vuelo cargado correctamente";
            } else {
                response = "No se puedo cargar";

            }
            st.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;

    }

}

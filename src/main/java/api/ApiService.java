package api;

import models.AircraftDTO;
import models.FlightDTO;
import models.UserDTO;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApiService {

    private String response;
    private Statement st;
    private ResultSet rs;
    private String query;

    public String getDestination(Connection connection) {

        query = "SELECT array_to_json(array_agg(destination)) FROM destination";
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                response = rs.getString(1);
            }

            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    public String authenticateUser(Connection connection, UserDTO user) {
        query = "select row_to_json(\"user\") from \"user\" " +
                "where username = '" + user.getUsername() + "' and password = '" + user.getPassword() + "'";
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


    public String getAircrafts(Connection connection) {
        query = "SELECT array_to_json(array_agg(aircraft)) FROM aircraft";
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

    public String createAircraft(Connection connection, AircraftDTO aircraft) {
        query = "INSERT INTO public.aircraft\n" +
                "(id_aircraft, brand, model, id_seat, \"registrationNumber\")\n" +
                "VALUES("
                + aircraft.getId_aircraft() + ", '"
                + aircraft.getBrand() + "', '"
                + aircraft.getModel() + "', "
                + aircraft.getId_seat() + ", '"
                + aircraft.getRegistrationNumber() + "');\n";
        try {

            st = connection.createStatement();

            if (st.executeUpdate(query) == 1) {
                response = "Avion cargado correctamente";
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

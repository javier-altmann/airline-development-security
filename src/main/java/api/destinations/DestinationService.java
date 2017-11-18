package api.destinations;

import models.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DestinationService {

    private String response;
    private Statement st;
    private ResultSet rs;
    private String query;

    public String getDestinations(Connection connection) {

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

    public String createDestination(Connection connection, DestinationDTO destination) {
        query = "INSERT INTO public.destination\n" +
                "(id_destination, \"name\")\n" +
                "VALUES("
                + destination.getId_destination() + ", '"
                + destination.getName() + "');";
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

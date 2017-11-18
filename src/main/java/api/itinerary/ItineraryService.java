package api.itinerary;

import models.ItineraryDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItineraryService {

    private String response;
    private Statement st;
    private ResultSet rs;
    private String query;


    public String getItineraries(Connection connection) {

        query = "with routesOrdered as (\n" +
                "\twith itinerary as (\t\n" +
                "\t\t(\n" +
                "\t\t\tselect \n" +
                "\t\t\t\t\t'from' \"ruta\",\n" +
                "\t\t\t\t\titinerary.id_itinerary,\n" +
                "\t\t\t\t   \tdestination.\"name\"\n" +
                "\t\t\t\t   \n" +
                "\t\t\tfrom itinerary\n" +
                "\t\t\t\n" +
                "\t\t\tinner join destination\n" +
                "\t\t\t\ton destination.id_destination = itinerary.id_from_destination\n" +
                "\t\t)\n" +
                "\t\tunion all\n" +
                "\t\t(\n" +
                "\t\t\tselect \n" +
                "\t\t\t\t\t'to' \"ruta\",\n" +
                "\t\t\t\t\titinerary.id_itinerary,\n" +
                "\t\t\t\t   \tdestination.\"name\"\n" +
                "\t\t\t\t   \n" +
                "\t\t\tfrom itinerary\n" +
                "\t\t\t\n" +
                "\t\t\tinner join destination\n" +
                "\t\t\t\ton destination.id_destination = itinerary.id_to_destination\n" +
                "\t\t)\n" +
                "\t)\n" +
                "\t\n" +
                "\t\tselect \n" +
                "\t\tDISTINCT\n" +
                "\t\t\tid_itinerary,\n" +
                "\t\t\t(\n" +
                "\t\t\t\tselect \"name\" from itinerary as \"from\"\n" +
                "\t\t\t\twhere \"from\".id_itinerary=routesParent.id_itinerary and ruta='from' limit 1\n" +
                "\t\t\t) \"from\",\n" +
                "\t\t\t(\n" +
                "\t\t\t\tselect \"name\" from itinerary as \"from\"\n" +
                "\t\t\t\twhere \"from\".id_itinerary=routesParent.id_itinerary and ruta='to' limit 1\n" +
                "\t\t\t) \"to\"\n" +
                "\t\t\t\t\n" +
                "\t\tfrom itinerary as routesParent\n" +
                "\t\torder by id_itinerary\n" +
                ")\n" +
                "\n" +
                "SELECT array_to_json(array_agg(routesOrdered)) FROM routesOrdered ";
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

    public String createItinerary(Connection connection, ItineraryDTO route) {
        query = " INSERT INTO public.itinerary (id_itinerary, cost_ticket, id_from_destination, id_to_destination)" +
                " VALUES(" +
                route.getId_itinerary() + "," +
                route.getCost_ticket() + "," +
                route.getId_from_destination() + ","
                + route.getId_to_destination()
                + ")";

        try {

            st = connection.createStatement();

            if (st.executeUpdate(query) == 1) {
                response = "Itinerario cargada correctamente";
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

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

    public String getFlight(Connection connection, int id_flight) {
        query = "SELECT array_to_json(array_agg(flight)) FROM flight where id_flight= " + id_flight;
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

    public String getSeatsAvailableFromFlight(Connection connection, int id_flight) {
        query = "\n" +
                "with seatsAvailable as (\n" +
                "\tselect \n" +
                "\t\taircraft.*,\n" +
                "\t\tseat.*\n" +
                "\tfrom aircraft\n" +
                "\t\n" +
                "\tinner join seat\n" +
                "\t\ton aircraft.id_seat = seat.id_seat\n" +
                "\t\n" +
                "\tinner join flight\n" +
                "\t\ton flight.id_aircraft = aircraft.id_aircraft\n" +
                "\t\t\n" +
                "\tleft join passenger\n" +
                "\t\ton passenger.seat = seat.seat\n" +
                "\t\t\n" +
                "\twhere passenger.id_passenger is null\n" +
                "\t\t\tand flight.id_flight = " + id_flight +
                ")\n" +
                "\n" +
                "select array_to_json(array_agg(seatsAvailable)) from seatsAvailable";
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

    public String getFlightsWithItinerary(Connection connection) {
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
                "\t\t\troutesParent.id_itinerary,\n" +
                "\t\t\tflight.id_flight,\n" +
                "\t\t\t(\n" +
                "\t\t\t\tselect \"name\" from itinerary as \"from\"\n" +
                "\t\t\t\twhere \"from\".id_itinerary=routesParent.id_itinerary and ruta='from' limit 1\n" +
                "\t\t\t) \"from\",\n" +
                "\t\t\t(\n" +
                "\t\t\t\tselect \"name\" from itinerary as \"from\"\n" +
                "\t\t\t\twhere \"from\".id_itinerary=routesParent.id_itinerary and ruta='to' limit 1\n" +
                "\t\t\t) \"to\",\n" +
                "\t\t\t\n" +
                "\t\t\taircraft.*\n" +
                "\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\n" +
                "\t\tfrom itinerary as routesParent\n" +
                "\t\t\n" +
                "\t\tinner join flight \n" +
                "\t\t\ton flight.id_itinerary = routesParent.id_itinerary\n" +
                "\t\t\t\n" +
                "\t\tinner join aircraft \n" +
                "\t\t\ton aircraft.id_aircraft = flight.id_aircraft\n" +
                "\t\t\t\n" +
                "\t\t\n" +
                "\t\torder by routesParent.id_itinerary\n" +
                ")\n" +
                "\n" +
                "\n" +
                "\n" +
                "SELECT array_to_json(array_agg(routesOrdered)) FROM routesOrdered";
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

    public String getFlightWithItinerary(Connection connection, int id_flight) {
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
                "\t\t\troutesParent.id_itinerary,\n" +
                "\t\t\tflight.id_flight,\n" +
                "\t\t\t(\n" +
                "\t\t\t\tselect \"name\" from itinerary as \"from\"\n" +
                "\t\t\t\twhere \"from\".id_itinerary=routesParent.id_itinerary and ruta='from' limit 1\n" +
                "\t\t\t) \"from\",\n" +
                "\t\t\t(\n" +
                "\t\t\t\tselect \"name\" from itinerary as \"from\"\n" +
                "\t\t\t\twhere \"from\".id_itinerary=routesParent.id_itinerary and ruta='to' limit 1\n" +
                "\t\t\t) \"to\",\n" +
                "\t\t\t\n" +
                "\t\t\taircraft.*\n" +
                "\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\n" +
                "\t\tfrom itinerary as routesParent\n" +
                "\t\t\n" +
                "\t\tinner join flight \n" +
                "\t\t\ton flight.id_itinerary = routesParent.id_itinerary\n" +
                "\t\t\t\n" +
                "\t\tinner join aircraft \n" +
                "\t\t\ton aircraft.id_aircraft = flight.id_aircraft\n" +
                "\t\t\t\n" +
                "\t\twhere flight.id_flight = '" + id_flight + "'\n" +
                "\t\torder by routesParent.id_itinerary\n" +
                ")\n" +
                "\n" +
                "\n" +
                "\n" +
                "SELECT to_json(routesOrdered) FROM routesOrdered ";
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
                "            (id_flight, id_aircraft, id_itinerary, id_passenger_list,status)\n" +
                "    VALUES" +
                "(" + flight.getId_flight() + ", " + flight.getId_aircraft() + "," + flight.getId_itinerary() + "," + flight.getId_passenger_list() + ",'open');";
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

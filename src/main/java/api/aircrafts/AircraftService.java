package api.aircrafts;

import models.AircraftDTO;
import models.DestinationDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AircraftService {

    private String response;
    private Statement st;
    private ResultSet rs;
    private String query;


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

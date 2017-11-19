package api.aircrafts;

import models.AircraftDTO;

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

    public String createAircraft(Connection connection, AircraftDTO aircraft) throws SQLException {

        query = "INSERT INTO public.aircraft\n" +
                "(id_aircraft, brand, model, \"registrationNumber\",id_seat)\n" +
                "VALUES("
                + aircraft.getId_aircraft() + ", '"
                + aircraft.getBrand() + "', '"
                + aircraft.getModel() + "', '"
                + aircraft.getRegistrationNumber() + "', '"
                + aircraft.getId_seat() + "');\n";


        try {

            st = connection.createStatement();

            if (st.executeUpdate(query) == 1) {
                response = "Avion cargado correctamente";
            } else {
                response = "No se puedo cargar";
            }
            st.close();
        } catch (SQLException e)

        {
            e.printStackTrace();
        }


        for (int i = 1; i <= Integer.parseInt(aircraft.getMax_seats()); i++) {
            query = "INSERT INTO public.seat(id_seat, max_seats, seat)\n" +
                    "VALUES("
                    + aircraft.getId_seat() + ","
                    + aircraft.getMax_seats() + ","
                    + i + ");\n ";
            try {

                st = connection.createStatement();

                if (st.executeUpdate(query) == 1) {
                    response = "Avion cargado correctamente";
                } else {
                    response = "No se puedo cargar";
                }

            } catch (SQLException e)

            {
                e.printStackTrace();
            }
        }
        st.close();
        connection.close();
        return response;
    }


}

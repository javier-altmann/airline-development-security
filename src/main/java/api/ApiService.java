package api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApiService {

    private String response;
    private Statement st;
    private ResultSet rs;

    String getDestination(Connection connection) throws SQLException {

        st = connection.createStatement();
        rs = st.executeQuery("SELECT array_to_json(array_agg(destination)) FROM destination");
        while (rs.next()) {
            response = rs.getString(1);
        }
        rs.close();
        st.close();
        return response;
    }

}

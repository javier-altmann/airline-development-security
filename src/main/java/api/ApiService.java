package api;

import models.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApiService {

    private String response;
    private Statement st;
    private ResultSet rs;
    private String query;


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


}

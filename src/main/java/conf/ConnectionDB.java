package conf;

import com.google.inject.Singleton;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Singleton
public class ConnectionDB {

    private Connection connection;
    final Logger logger = LoggerFactory.getLogger(ConnectionDB.class);

    public ConnectionDB() throws SQLException {

        connection = DriverManager.getConnection(
                "jdbc:postgresql://ec2-54-225-88-199.compute-1.amazonaws.com:5432/d4svgafc2bp0m2?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory",
                "ljqiappficucik",
                "fbdb621e34dcaab9de17dbd9c6e89cead74c6e1db0503b9cdab6173a66e030e0");

    }

    public Connection getConnection() {
        return connection;
    }
}

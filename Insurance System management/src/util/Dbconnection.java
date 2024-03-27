package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
    private static final String CONNECTION_STRING = Propertyutil.getPropertyString();
    private static Connection connection = null;

    private Dbconnection() {
        // Private constructor to prevent instantiation
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(CONNECTION_STRING);
        }
        return connection;
    }
}

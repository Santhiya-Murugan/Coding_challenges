package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Propertyutil {
	private static final String PROPERTY_FILE = "db.properties";

    public static String getPropertyString() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(PROPERTY_FILE)) {
            properties.load(fileInputStream);
            String host = properties.getProperty("localhost");
            String dbName = properties.getProperty("insurance");
            String username = properties.getProperty("root");
            String password = properties.getProperty("Santhiya@25");
            String port = properties.getProperty("3306");

            return "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?user=" + username + "&password=" + password;
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Handle the exception appropriately
        }
    }
}



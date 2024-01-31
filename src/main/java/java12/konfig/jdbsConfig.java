package java12.konfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbsConfig {
    private final static String url = "jdbc:postgresql://localhost:5432/house";
    public final static String username = "postgres";
    public final static String password = "1234";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}


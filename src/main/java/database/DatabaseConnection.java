package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public DatabaseConnection() {
    }

    private static final String URL = "jdbc:postgresql://localhost:5432/listOfUsers";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123qwe";
    private static final String DRIVER_CLASS = "org.postgresql.Driver";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException | NullPointerException e) {
            System.out.println("Failed to load driver");
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("connection established");
        } else {
            System.out.println("connection lost");
        }
        return connection;
    }
}

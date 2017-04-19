package main.models.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by admin on 19.04.2017.
 */
public class DBConnection {

    public static Connection initConnection() {
        java.sql.Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/shopping_planning", "postgres", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

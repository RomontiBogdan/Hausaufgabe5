package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCRepo {
    private static String dbhost = "jdbc:mysql://localhost:3306/hausaufgabe5";
    private static String username = "root";
    private static String password = "1234";
    private static Connection conn;

    @SuppressWarnings("finally")
    public static Connection createDBconnection() {
        try  {
            conn = DriverManager.getConnection(
                    dbhost, username, password);
        } catch (SQLException e) {
            System.out.println("Cannot create database connection");
            e.printStackTrace();
        } finally {
            return conn;
        }
    }
}
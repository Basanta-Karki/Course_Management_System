package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnection {
	static final String DB_URL = "jdbc:mysql://localhost:3307/student";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            System.out.println("Attempting to connect to the database...");
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database successfully!");
            return connection;
        } catch (SQLException e) {
            System.err.println("Error connecting to the database:");
            e.printStackTrace();
            throw e; // Rethrow the exception to indicate connection failure
        }
        
    }
    
}

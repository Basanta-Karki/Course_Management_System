package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class databaseOperation {

    public static int getTotalCourses() {
        return getTotal("courses");
    }

    public static int getTotalTutors() {
        return getTotal("tutors");
    }
    public static int getTotalTutors1() {
        // Retrieve the count of students without any condition
        return getTotal("userinfo");
    }
    

    public static int getTotalStudents() {
        return getTotal("students");
    }
    public static int getTotalStudents1() {
        // Retrieve the count of students without any condition
        return getTotal("userinfo");
    }

    public static int getTotalStudentsWithCondition() {
        // Retrieve the count of students with a specific condition
        String studentQuery = "SELECT COUNT(*) FROM userinfo WHERE mode = 'Student'";
        return getTotal(studentQuery);
    }
    
    public static int getTotalStudentsWithCondition1() {
        // Retrieve the count of students with a specific condition
        String studentQuery = "SELECT COUNT(*) FROM userinfo WHERE mode = 'Tutor'";
        return getTotal(studentQuery);
    }
    public static int getTotalTutorWithCondition1() {
        // Retrieve the count of students with a specific condition
        String studentQuery = "SELECT COUNT(*) FROM userinfo WHERE mode = 'Tutor'";
        return getTotal(studentQuery);
    }

    private static int getTotal(String tableName) {
        String query = "SELECT COUNT(*) FROM " + tableName;
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt(1); // Assuming the count is in the first column
            }

        } catch (SQLException e) {
            System.err.println("Error executing query for table " + tableName);
            e.printStackTrace();
        }

        return 0; // Return 0 if there's an error or no records found
    }
    public static int getTotalUser(String mode) {
        String query = "SELECT COUNT(*) FROM userinfo WHERE mode ='" + mode + "'";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt(1); // Assuming the count is in the first column
            }

        } catch (SQLException e) {
            System.err.println("Error executing query for table " + mode);
            e.printStackTrace();
        }

        return 0; // Return 0 if there's an error or no records found
    }

	
    
}

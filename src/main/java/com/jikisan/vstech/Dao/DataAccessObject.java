
package com.jikisan.vstech.Dao;

import com.jikisan.vstech.Model.NurseModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataAccessObject {
    
    // Database connection details
    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/your_database"; // Change to your database
        String user = "your_user"; // Change to your user
        String password = "your_password"; // Change to your password
        return DriverManager.getConnection(url, user, password);
    }

    // Function to register user in the database
    private static void registerUser(NurseModel nurse) throws SQLException {
//        String sql = "INSERT INTO users : +(name, age, department, license_number) +" VALUES (?, ?, ?, ?)";
        String sql = "INSERT INTO users : + "("name, age, department, license_number) +" VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, age);
            pstmt.setString(3, department);
            pstmt.setString(4, licenseNumber);

            pstmt.executeUpdate(); // Execute the SQL query to insert data into the database
        }
    }
    
    
}

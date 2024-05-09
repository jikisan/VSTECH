package com.jikisan.vstech.DAO;

import com.jikisan.vstech.Model.NurseListModel;
import com.jikisan.vstech.Model.NurseModel;

import java.sql.*;

public class NurseDao {
    private Connection conn;

    public NurseDao(Connection conn) {
        this.conn = conn;
    }

    public ResultSet getAllUsers() throws SQLException {
        String query = "SELECT * FROM Nurse";
        Statement statement = conn.createStatement();
        return statement.executeQuery(query);
    }

    public boolean authenticate(String username, String password) throws SQLException {
        String query = "SELECT * FROM Nurse WHERE username = ? AND password = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, password);

        ResultSet rs = statement.executeQuery();
        boolean isAuthenticated = rs.next();  // If there's a result, authentication is successful

        if (isAuthenticated) {
            NurseModel.getInstance(rs.getString("fullName"), rs.getString("age"), rs.getString("department"), rs.getString("licenseNumber"), rs.getString("username"), rs.getString("password"));
        }

        rs.close();
        statement.close();

        return isAuthenticated;
    }


    public static void createNurseTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Nurse (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "fullName TEXT NOT NULL," +
                "age TEXT NOT NULL," +
                "department TEXT NOT NULL," +
                "licenseNumber TEXT NOT NULL," +
                "username TEXT NOT NULL," +
                "password TEXT NOT NULL" +
                ")";

        try (
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql); // Execute the CREATE TABLE command
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions
        }

    }
}
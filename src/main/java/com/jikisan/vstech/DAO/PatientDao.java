package com.jikisan.vstech.DAO;

import java.sql.*;

public class PatientDao {
    private Connection conn;

    public PatientDao() {
        this.conn = DbConn.ConnectDb();
    }

    public ResultSet getAllPatients() throws SQLException {
        String query = "SELECT * FROM Patient";
        Statement statement = conn.createStatement();
        return statement.executeQuery(query);
    }

    // Retrieve patients by age
    public ResultSet getPatientsByAge(int age) throws SQLException {
        String query = "SELECT * FROM Patient WHERE age = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, age);
        return statement.executeQuery();
    }

    // Retrieve patient by ID
    public ResultSet getPatientById(int id) throws SQLException {
        String query = "SELECT * FROM Patient WHERE id = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, id);
        return statement.executeQuery();
    }

    public static void createPatientTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Patient (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "caseNumber TEXT NOT NULL," +
                "age TEXT NOT NULL," +
                "diagnosis TEXT," +
                "photoName TEXT NOT NULL," +
                "tempData TEXT," +
                "hrData TEXT," +
                "prData TEXT," +
                "bpData TEXT," +
                "o2Data TEXT," +
                "dates TEXT NOT NULL," +
                "rrData TEXT" +
                ")";


        try (
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql); // Execute the CREATE TABLE command
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions
        }

    }

    // Method to update employee salary based on employee ID
    public static void updatePatientData(Connection conn, int employeeId, String data, String name) {
        String sql = "UPDATE Patient SET "+ name +" = ? WHERE id = ?"; // The SQL UPDATE statement

        try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the parameters for the prepared statement
            pstmt.setString(1, data);
            pstmt.setInt(2, employeeId);

            pstmt.executeUpdate(); // Execute the update

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

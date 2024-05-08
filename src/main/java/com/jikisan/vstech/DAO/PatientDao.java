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

}

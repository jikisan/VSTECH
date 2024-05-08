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
            System.out.println(NurseModel.getActiveNurse());
        }

        rs.close();
        statement.close();

        return isAuthenticated;
    }

}
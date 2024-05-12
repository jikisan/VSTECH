package com.jikisan.vstech.DAO;

import com.jikisan.vstech.Model.NursingManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class NursingManagementDao {

    public static void createNursingManagementTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS NursingManagementDb (" +
                "id INTEGER NOT NULL UNIQUE, " +
                "nurseId INTEGER NOT NULL, " +
                "patientId INTEGER NOT NULL, " +
                "plot INTEGER NOT NULL, " +
                "diagnosis TEXT NOT NULL, " +
                "abnormalFinding TEXT NOT NULL, " +
                "isDiagnosisChecked INTEGER NOT NULL, " +
                "intervention TEXT NOT NULL, " +
                "isInterventionChecked INTEGER NOT NULL, " +
                "dateSaved TEXT NOT NULL, " +
                "dateTime TEXT NOT NULL, " +
                "PRIMARY KEY(id AUTOINCREMENT)" +
                ");";


        try (
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql); // Execute the CREATE TABLE command
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions
        }

    }

    public static void addNursingRecord(Connection conn, NursingManagement record) {

        String sql = "INSERT INTO NursingManagementDb (nurseId, plot, diagnosis, isDiagnosisChecked, " +
                "intervention, isInterventionChecked, dateSaved, dateTime) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, record.getNurseId());
            pstmt.setInt(2, record.getPlot());
            pstmt.setString(3, record.getDiagnosis());
            pstmt.setInt(4, record.getIsDiagnosisChecked());
            pstmt.setString(5, record.getIntervention());
            pstmt.setInt(6, record.getIsInterventionChecked());
            pstmt.setString(7, record.getDateSaved());
            pstmt.setString(8, record.getDateTime());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

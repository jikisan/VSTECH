package com.jikisan.vstech.DAO;

import com.jikisan.vstech.Model.DiagnosisModel;
import com.jikisan.vstech.Model.InterventionModel;
import com.jikisan.vstech.Model.NursingManagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NursingManagementDao {

    public static void createNursingManagementDb(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS  NursingManagementDb (" +
                "id INTEGER NOT NULL UNIQUE, " +
                "nurseId INTEGER NOT NULL, " +
                "patientId INTEGER NOT NULL, " +
                "plot INTEGER NOT NULL, " +
                "abnormalFinding TEXT NOT NULL, " +
                "dateSaved TEXT NOT NULL, " +
                "dateTime TEXT NOT NULL, " +
                "PRIMARY KEY(id)" +
                ");";

        try (
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql); // Execute the CREATE TABLE command
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions
        }

    }

    public static void createDiagnoseDb(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS DiagnosisDb (" +
                "id INTEGER NOT NULL UNIQUE PRIMARY KEY AUTOINCREMENT, " +
                "nursingManagementId INTEGER NOT NULL, " +
                "diagnosis TEXT NOT NULL, " +
                "isDiagnosisChecked INTEGER NOT NULL, " +
                "plot INTEGER NOT NULL" +
                ");";

        try (
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql); // Execute the CREATE TABLE command
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions
        }

    }

    public static void createInterventionDb(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS InterventionDb (" +
                "id INTEGER NOT NULL UNIQUE PRIMARY KEY AUTOINCREMENT, " +
                "nursingManagementId INTEGER NOT NULL, " +
                "intervention TEXT NOT NULL, " +
                "isInterventionChecked INTEGER NOT NULL, " +
                "plot INTEGER NOT NULL" +
                ");";

        try (
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql); // Execute the CREATE TABLE command
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions
        }

    }

    public static void addNursingManagement(Connection conn, NursingManagement record) {

        String sql = "INSERT INTO NursingManagementDb (id, nurseId, patientId, plot, abnormalFinding, dateSaved, dateTime) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, record.getId());
            pstmt.setInt(2, record.getNurseId());
            pstmt.setInt(3, record.getPatientId());
            pstmt.setInt(4, record.getPlot());
            pstmt.setString(5, record.getAbnormalFinding());
            pstmt.setString(6, record.getDateSaved());
            pstmt.setString(7, record.getDateTime());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addDiagnosis(Connection conn, DiagnosisModel record) {
        String sql = "INSERT INTO DiagnosisDb (nursingManagementId, diagnosis, isDiagnosisChecked, plot) " +
                "VALUES (?, ?, ?, ?)";

        try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, record.getNursingManagementId());
            pstmt.setString(2, record.getDiagnosis());
            pstmt.setInt(3, record.getIsDiagnosisChecked());
            pstmt.setInt(4, record.getPlot());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addIntervention(Connection conn, InterventionModel intervention) {
        String sql = "INSERT INTO InterventionDb (nursingManagementId, intervention, isInterventionChecked, plot) " +
                "VALUES (?, ?, ?, ?)";

        try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, intervention.getNursingManagementId());
            pstmt.setString(2, intervention.getIntervention());
            pstmt.setInt(3, intervention.getIsInterventionChecked());
            pstmt.setInt(4, intervention.getPlot());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getNursingManagementData(Connection conn) {
        String sql = "SELECT * FROM NursingManagementDb";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int nurseId = rs.getInt("nurseId");
                int patientId = rs.getInt("patientId");
                int plot = rs.getInt("plot");
                String abnormalFinding = rs.getString("abnormalFinding");
                String dateSaved = rs.getString("dateSaved");
                String dateTime = rs.getString("dateTime");

                // Process the retrieved data here
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getDiagnosisData(Connection conn) {
        String sql = "SELECT * FROM DiagnosisDb";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int nursingManagementId = rs.getInt("nursingManagementId");
                String diagnosis = rs.getString("diagnosis");
                int isDiagnosisChecked = rs.getInt("isDiagnosisChecked");

                // Process the retrieved data here
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getInterventionData(Connection conn) {
        String sql = "SELECT * FROM InterventionDb";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int nursingManagementId = rs.getInt("nursingManagementId");
                String intervention = rs.getString("intervention");
                int isInterventionChecked = rs.getInt("isInterventionChecked");

                // Process the retrieved data here
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<NursingManagement> getNursingManagementDataByPatientId(Connection conn, int patientId) {
        String sql = "SELECT * FROM NursingManagementDb WHERE patientId = " + patientId + " ORDER BY id";
        List<NursingManagement> nursingRecords = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int nurseId = rs.getInt("nurseId");
                int plot = rs.getInt("plot");
                String abnormalFinding = rs.getString("abnormalFinding");
                String dateSaved = rs.getString("dateSaved");
                String dateTime = rs.getString("dateTime");

                NursingManagement nm = new NursingManagement(
                        id, nurseId, patientId, plot, abnormalFinding, dateSaved, dateTime
                );

                nursingRecords.add(nm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nursingRecords;
    }

    public static List<DiagnosisModel> getDiagnosisByNmId(Connection conn, int nursingManagementId) {
        String sql = "SELECT * FROM DiagnosisDb WHERE nursingManagementId = " + nursingManagementId;
        List<DiagnosisModel> records = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String diagnosis = rs.getString("diagnosis");
                int isDiagnosisChecked = rs.getInt("isDiagnosisChecked");
                int plot = rs.getInt("plot");

                DiagnosisModel nm = new DiagnosisModel(
                        nursingManagementId, diagnosis, isDiagnosisChecked, plot
                );

                records.add(nm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return records;
    }

    public static List<InterventionModel> getInterventionByNmId(Connection conn, int nursingManagementId) {
        List<InterventionModel> interventions = new ArrayList<>();
        String sql = "SELECT * FROM InterventionDb WHERE nursingManagementId = " + nursingManagementId;

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String intervention = rs.getString("intervention");
                int isInterventionChecked = rs.getInt("isInterventionChecked");
                int plot = rs.getInt("plot");

                InterventionModel interventionObj = new InterventionModel(
                        nursingManagementId, intervention, isInterventionChecked, plot
                );
                interventions.add(interventionObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return interventions;
    }

    public static void updateDiagnosisChecked(Connection conn, int nursingManagementId, boolean isSelected) {
        String sql = "UPDATE DiagnosisDb SET isDiagnosisChecked = ? WHERE nursingManagementId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, isSelected ? 1 : 0);
            pstmt.setInt(2, nursingManagementId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateInterventionChecked(Connection conn, int nursingManagementId, boolean isSelected) {
        String sql = "UPDATE InterventionDb SET isInterventionChecked = ? WHERE nursingManagementId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, isSelected ? 1 : 0);
            pstmt.setInt(2, nursingManagementId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

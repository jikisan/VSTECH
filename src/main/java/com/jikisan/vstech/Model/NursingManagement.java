package com.jikisan.vstech.Model;

public class NursingManagement {
    private int id;
    private int nurseId;
    private int patientId;
    private int plot;
    private String abnormalFinding;
    private String dateSaved;
    private String dateTime;

    public NursingManagement(int id, int nurseId, int patientId, int plot, String abnormalFinding, String dateSaved, String dateTime) {
        this.id = id;
        this.nurseId = nurseId;
        this.patientId = patientId;
        this.plot = plot;
        this.abnormalFinding = abnormalFinding;
        this.dateSaved = dateSaved;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPlot() {
        return plot;
    }

    public void setPlot(int plot) {
        this.plot = plot;
    }

    public String getAbnormalFinding() {
        return abnormalFinding;
    }

    public void setAbnormalFinding(String abnormalFinding) {
        this.abnormalFinding = abnormalFinding;
    }

    public String getDateSaved() {
        return dateSaved;
    }

    public void setDateSaved(String dateSaved) {
        this.dateSaved = dateSaved;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}

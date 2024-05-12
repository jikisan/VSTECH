package com.jikisan.vstech.Model;

public class NursingManagement {
    private int id;
    private int nurseId;
    private int patientId;
    private int plot;
    private String abnormalFinding;
    private String diagnosis;
    private int isDiagnosisChecked;
    private String intervention;
    private int isInterventionChecked;
    private String dateSaved;
    private String dateTime;

    public NursingManagement() {

    }

    public NursingManagement(int nurseId, int patientId, int plot, String abnormalFinding, String diagnosis, int isDiagnosisChecked,
                             String intervention, int isInterventionChecked, String dateSaved, String dateTime) {
        this.nurseId = nurseId;
        this.patientId = patientId;
        this.plot = plot;
        this.abnormalFinding = abnormalFinding;
        this.diagnosis = diagnosis;
        this.isDiagnosisChecked = isDiagnosisChecked;
        this.intervention = intervention;
        this.isInterventionChecked = isInterventionChecked;
        this.dateSaved = dateSaved;
        this.dateTime = dateTime;
    }



    public void setAbnormalFinding(String abnormalFinding) {
        this.abnormalFinding = abnormalFinding;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public void setPlot(int plot) {
        this.plot = plot;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setIsDiagnosisChecked(int isDiagnosisChecked) {
        this.isDiagnosisChecked = isDiagnosisChecked;
    }

    public void setIntervention(String intervention) {
        this.intervention = intervention;
    }

    public void setIsInterventionChecked(int isInterventionChecked) {
        this.isInterventionChecked = isInterventionChecked;
    }

    public void setDateSaved(String dateSaved) {
        this.dateSaved = dateSaved;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }


    public String getAbnormalFinding() {
        return abnormalFinding;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getId() {
        return id;
    }

    public int getNurseId() {
        return nurseId;
    }

    public int getPlot() {
        return plot;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public int getIsDiagnosisChecked() {
        return isDiagnosisChecked;
    }

    public String getIntervention() {
        return intervention;
    }

    public int getIsInterventionChecked() {
        return isInterventionChecked;
    }

    public String getDateSaved() {
        return dateSaved;
    }

    public String getDateTime() {
        return dateTime;
    }
}

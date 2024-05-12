package com.jikisan.vstech.Model;

public class DiagnosisModel {
    private int id;
    private int nursingManagementId;
    private String diagnosis;
    private int isDiagnosisChecked;
    private int plot;

    public DiagnosisModel(int nursingManagementId, String diagnosis, int isDiagnosisChecked, int plot) {
        this.nursingManagementId = nursingManagementId;
        this.diagnosis = diagnosis;
        this.isDiagnosisChecked = isDiagnosisChecked;
        this.plot = plot;
    }

    public int getPlot() {
        return plot;
    }

    public void setPlot(int plot) {
        this.plot = plot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNursingManagementId() {
        return nursingManagementId;
    }

    public void setNursingManagementId(int nursingManagementId) {
        this.nursingManagementId = nursingManagementId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getIsDiagnosisChecked() {
        return isDiagnosisChecked;
    }

    public void setIsDiagnosisChecked(int isDiagnosisChecked) {
        this.isDiagnosisChecked = isDiagnosisChecked;
    }
}


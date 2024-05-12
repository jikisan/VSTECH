package com.jikisan.vstech.Model;

public class InterventionModel {
    private int id;
    private int nursingManagementId;
    private String intervention;
    private int isInterventionChecked;
    private int plot;

    public InterventionModel(int nursingManagementId, String intervention, int isInterventionChecked, int plot) {
        this.nursingManagementId = nursingManagementId;
        this.intervention = intervention;
        this.isInterventionChecked = isInterventionChecked;
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

    public String getIntervention() {
        return intervention;
    }

    public void setIntervention(String intervention) {
        this.intervention = intervention;
    }

    public int getIsInterventionChecked() {
        return isInterventionChecked;
    }

    public void setIsInterventionChecked(int isInterventionChecked) {
        this.isInterventionChecked = isInterventionChecked;
    }
}

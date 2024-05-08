package com.jikisan.vstech.Model;

public class ActivePatient {

    private PatientModel patient;
    private static ActivePatient instance;

    private ActivePatient() {
    }

    public static ActivePatient getInstance() {
        if (instance == null) {
            instance = new ActivePatient();
        }
        return instance;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public PatientModel getPatient() {
        return patient;
    }

}

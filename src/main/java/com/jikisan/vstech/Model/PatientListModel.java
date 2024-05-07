package com.jikisan.vstech.Model;

import java.util.ArrayList;

public class PatientListModel {

    private static PatientListModel instance; // The single instance of the class
    private ArrayList<PatientModel> patientList = new ArrayList<PatientModel>();

    // Private constructor to prevent instantiation from outside the class
    private PatientListModel() {
        // You can initialize default values here if needed
    }

    // Public method to get the single instance of the class
    public static synchronized PatientListModel getInstance() {
        if (instance == null) { // Create the instance if it doesn't exist
            instance = new PatientListModel();
        }
        return instance; // Return the single instance
    }

    public void addPatient(PatientModel patient) {
        patientList.add(patient);
    }

    public ArrayList<PatientModel> getNurseList() {
        return patientList;
    }
}

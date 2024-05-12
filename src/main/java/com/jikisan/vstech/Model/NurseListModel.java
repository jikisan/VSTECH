package com.jikisan.vstech.Model;

import java.util.ArrayList;

public class NurseListModel {

    private static NurseListModel instance; // The single instance of the class
    private LoggedInNurseModel nurse;
    private ArrayList<LoggedInNurseModel> nurseList = new ArrayList<LoggedInNurseModel>();

    // Private constructor to prevent instantiation from outside the class
    private NurseListModel() {
        // You can initialize default values here if needed
    }

    // Public method to get the single instance of the class
    public static synchronized NurseListModel getInstance() {
        if (instance == null) { // Create the instance if it doesn't exist
            instance = new NurseListModel();
        }
        return instance; // Return the single instance
    }

    public void setActiveNurse(LoggedInNurseModel nurse) {
        this.nurse = nurse;
    }


    public LoggedInNurseModel getActiveNurse() {
        return this.nurse;
    }
}

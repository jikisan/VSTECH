package com.jikisan.vstech.Model;

public class DataPointsModel {

    private static DataPointsModel instance; // The single instance of the class

    // Define the instance variables as you have done before
    private int[] dateXpoint;
    private int[] tempYpoint;
    private int[] prYpoint;
    private int[] rrYpoint;



    // Public method to get the single instance of the class
    public static synchronized DataPointsModel getInstance() {
        if (instance == null) { // Create the instance if it doesn't exist
            instance = new DataPointsModel();
        }
        return instance; // Return the single instance
    }

}

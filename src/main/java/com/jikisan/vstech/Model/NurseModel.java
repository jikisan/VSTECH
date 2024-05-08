
package com.jikisan.vstech.Model;

public class NurseModel {
    private static NurseModel instance;  // Private static instance variable
    private String fullName;
    private String age;
    private String department;
    private String licenseNumber;
    private String username;
    private String password;

    private NurseModel(String fullName, String age, String department, String licenseNumber, String username, String password) {
        this.fullName = fullName;
        this.age = age;
        this.department = department;
        this.licenseNumber = licenseNumber;
        this.username = username;
        this.password = password;
    }

    public static NurseModel getInstance(String fullName, String age, String department, String licenseNumber, String username, String password) {
        if (instance == null) { // Check if instance already exists
            instance = new NurseModel(fullName, age, department, licenseNumber, username, password); // Create the first instance if not
        }
        return instance;
    }

    public static NurseModel getActiveNurse() {
        return instance;
    }


    public String getFullName() {
        return fullName;
    }

    public String getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

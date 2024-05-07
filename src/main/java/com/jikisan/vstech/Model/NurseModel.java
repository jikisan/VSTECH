
package com.jikisan.vstech.Model;

public class NurseModel {
    private String fullName;
    private String age;
    private String department;
    private String licenseNumber;
    private String username;
    private String password;

    public NurseModel(String fullName, String age, String department, String licenseNumber, String username, String password) {
        this.fullName = fullName;
        this.age = age;
        this.department = department;
        this.licenseNumber = licenseNumber;
        this.username = username;
        this.password = password;
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
}

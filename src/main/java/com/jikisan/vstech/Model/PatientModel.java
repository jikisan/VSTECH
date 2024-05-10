package com.jikisan.vstech.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PatientModel {

    private int id;
    private String name;
    private String caseNumber;
    private String age;
    private String diagnosis;
    private String photo;

    private String tempData;
    private String hrData;
    private String prData;
    private String bpData;
    private String o2Data;
    private String dates;
    private String rrData;

    public PatientModel(int id, String name, String caseNumber, String age, String diagnosis, String photo, String dates, String tempData, String hrData, String rrData, String prData, String bpData, String o2Data) {
        this.id = id;
        this.name = name;
        this.caseNumber = caseNumber;
        this.age = age;
        this.diagnosis = diagnosis;
        this.photo = photo;
        this.tempData = tempData;
        this.hrData = hrData;
        this.prData = prData;
        this.bpData = bpData;
        this.o2Data = o2Data;
        this.dates = dates;
        this.rrData = rrData;
    }

    public PatientModel(int id, String name, String caseNumber, String age, String diagnosis, String photo, String dates) {
        this.id = id;
        this.name = name;
        this.caseNumber = caseNumber;
        this.age = age;
        this.diagnosis = diagnosis;
        this.photo = photo;
        this.dates = dates;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public String getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getPhoto() {
        return photo;
    }

    public String getTempData() {
        return tempData;
    }

    public String getHrData() {
        return hrData;
    }

    public String getPrData() {
        return prData;
    }

    public String getBpData() {
        return bpData;
    }

    public String getO2Data() {
        return o2Data;
    }

    public String getDates() {
        return dates;
    }

    public String getRrData() {
        return rrData;
    }

    public void setTempData(String tempData) {
        this.tempData = tempData;
    }

    public void setHrData(String hrData) {
        this.hrData = hrData;
    }

    public void setPrData(String prData) {
        this.prData = prData;
    }

    public void setBpData(String bpData) {
        this.bpData = bpData;
    }

    public void setO2Data(String o2Data) {
        this.o2Data = o2Data;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public void setRrData(String rrData) {
        this.rrData = rrData;
    }
}

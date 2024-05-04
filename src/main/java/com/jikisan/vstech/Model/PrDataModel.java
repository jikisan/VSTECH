package com.jikisan.vstech.Model;

public class PrDataModel {

    private String Date;
    private String Hour;
    private String PR;

    public PrDataModel(String Date, String Hour, String PR) {
        this.Date = Date;
        this.Hour = Hour;
        this.PR = PR;
    }

    public String getHour() {
        return Hour;
    }

    public void setHour(String Hour) {
        this.Hour = Hour;
    }
    
    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getPR() {
        return PR;
    }

    public void setPR(String PR) {
        this.PR = PR;
    }

}

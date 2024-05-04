package com.jikisan.vstech.Model;

public class RrDataModel {

    private String Date;
    private String Hour;
    private String RR;

    public RrDataModel(String Date, String Hour, String RR) {
        this.Date = Date;
        this.Hour = Hour;
        this.RR = RR;
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

    public String getRR() {
        return RR;
    }

    public void setRR(String RR) {
        this.RR = RR;
    }

}

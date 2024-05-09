
package com.jikisan.vstech.Model;

public class BpDataModel {
    private String Date;
    private String Hour;
    private String Bp;

    public BpDataModel(String Date, String Hour, String Bp) {
        this.Date = Date;
        this.Hour = Hour;
        this.Bp = Bp;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getHour() {
        return Hour;
    }

    public void setHour(String Hour) {
        this.Hour = Hour;
    }

    public String getBp() {
        return Bp;
    }

    public void setBp(String Bp) {
        this.Bp = Bp;
    }
    
    
}

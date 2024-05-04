
package com.jikisan.vstech.Model;

public class BpDataModel {
    private String Date;
    private String Hour;
    private String Temp;

    public BpDataModel(String Date, String Hour, String Temp) {
        this.Date = Date;
        this.Hour = Hour;
        this.Temp = Temp;
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

    public String getTemp() {
        return Temp;
    }

    public void setTemp(String Temp) {
        this.Temp = Temp;
    }
    
    
}

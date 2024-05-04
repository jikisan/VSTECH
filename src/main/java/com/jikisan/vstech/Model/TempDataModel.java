package com.jikisan.vstech.Model;

public class TempDataModel {

    private String Date;
    private String Hour;
    private String Temp;

    public TempDataModel(String Date, String Hour, String Temp) {
        this.Date = Date;
        this.Hour = Hour;
        this.Temp = Temp;
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

    public String getTemp() {
        return Temp;
    }

    public void setTemp(String Temp) {
        this.Temp = Temp;
    }

}

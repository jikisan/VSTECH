package com.jikisan.vstech.Model;

import com.jikisan.vstech.Model.BpDataModel;
import com.jikisan.vstech.Model.DateListModel;
import com.jikisan.vstech.Model.PrDataModel;
import com.jikisan.vstech.Model.RrDataModel;
import com.jikisan.vstech.Model.TempDataModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DataModel {

    private List<TempDataModel> tempData;
    private List<PrDataModel> prData;
    private List<RrDataModel> rrData;
    private List<BpDataModel> bpData;
    private DateListModel dateList;

    public DataModel(List<TempDataModel> tempData, List<PrDataModel> prData, List<RrDataModel> rrData, List<BpDataModel> bpData) {
        this.tempData = tempData;
        this.prData = prData;
        this.rrData = rrData;
        this.bpData = bpData;
        this.dateList = new DateListModel(generateDates());
    }

    public DateListModel getDateList() {
        return dateList;
    }

    public List<TempDataModel> getTempData() {
        return tempData;
    }

    public List<PrDataModel> getPrData() {
        return prData;
    }

    public List<RrDataModel> getRrData() {
        return rrData;
    }

    public List<BpDataModel> getBpData() {
        return bpData;
    }

    private String[] generateDates() {
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMM d");
        String[] days = new String[5];
        LocalDate currentDate = LocalDate.now();

        for (int i = 0; i < 5; i++) {
            days[i] = currentDate.plusDays(i).format(FORMATTER).toString();
        }

        return null;
    }

}

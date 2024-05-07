package com.jikisan.vstech.Model;

import com.jikisan.vstech.Model.BpDataModel;
import com.jikisan.vstech.Model.DateListModel;
import com.jikisan.vstech.Model.PrDataModel;
import com.jikisan.vstech.Model.RrDataModel;
import com.jikisan.vstech.Model.TempDataModel;
import java.util.ArrayList;
import java.util.List;

public class DataModel {

    private List<TempDataModel> tempData;
    private List<PrDataModel> prData;
    private List<RrDataModel> rrData;
    private List<BpDataModel> bpData;
    private DateListModel dateList;

    public DataModel(List<TempDataModel> tempData, List<PrDataModel> prData, List<RrDataModel> rrData, List<BpDataModel> bpData, DateListModel dateList) {
        this.tempData = tempData;
        this.prData = prData;
        this.rrData = rrData;
        this.bpData = bpData;
        this.dateList = dateList;
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

}

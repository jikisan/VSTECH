package com.jikisan.vstech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapper {

    private List<String> dateTimeList = new ArrayList<String>();
    private static List<String> combinedDateTimes = new ArrayList<>();


    public static Map<String, Integer> getXpointsMap(String[] dateArray) {
        String[] timeArray = new String[]{"12", "4", "8"};
        
        // For each date, we first process AM times, then PM times
        for (String date : dateArray) {
            // Process all AM times in the correct order
            for (String time : timeArray) {
                String dateTime = date + "-" + time + "-AM";
                combinedDateTimes.add(dateTime);
            }

            // Process all PM times in the correct order
            for (String time : timeArray) {
                String dateTime = date + "-" + time + "-PM";
                combinedDateTimes.add(dateTime);
            }
        }
            System.out.println("dateTimeMap value:" + combinedDateTimes);

        return mapDateTime(combinedDateTimes);
    }

    private static Map<String, Integer> mapDateTime(List<String> combinedDateTimes) {

        final Map<String, Integer> dateTimeMap = new HashMap<>();
//        int baseXPoint = 6;
//        int step = 1;
//
//        for (int i = 0; i <= combinedDateTimes.size(); i++) {
//            dateTimeMap.put(combinedDateTimes.get(i), baseXPoint);
//            baseXPoint += step;
//            System.out.println("dateTimeMap value:" + dateTimeMap.get(combinedDateTimes.get(i)));
//        }

        return dateTimeMap;
    }

}

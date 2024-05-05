package com.jikisan.vstech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapper {

    private static List<String> combinedDateTimes = new ArrayList<>();

    public static Map<String, Integer> getXpointsMap(String[] dateArray) {
        String[] timeArray = new String[]{"12", "4", "8"};
        combinedDateTimes.clear();

        // For each date, we first process AM times, then PM times
        for (String date : dateArray) {
            // Process all AM times in the correct order
            for (String time : timeArray) {
                String dateTime = date.toLowerCase() + " " + time + "-am";
                combinedDateTimes.add(dateTime);
            }

            // Process all PM times in the correct order
            for (String time : timeArray) {
                String dateTime = date.toLowerCase() + " " + time + "-pm";
                combinedDateTimes.add(dateTime);
            }
        }

        return mapDateTime(combinedDateTimes);
    }

    private static Map<String, Integer> mapDateTime(List<String> combinedDateTimes) {

        final Map<String, Integer> dateTimeMap = new HashMap<>();
        int baseXPoint = 6;
        int step = 1;

        for (int i = 0; i < combinedDateTimes.size(); i++) {
            dateTimeMap.put(combinedDateTimes.get(i), baseXPoint);
            baseXPoint += step;
        }

        return dateTimeMap;
    }

    public static Map<String, Integer> getTempYpointsMap() {
        final Map<String, Integer> temperatureMap = new HashMap<>();

        int baseYPoint = 21; // Start with the initial value
        int step = 1; // Step to reduce by 1

        // Define the changes in steps at specific points
        double[] decreasePoints = {35.0, 35.9, 36.0, 36.9, 37.0,  37.9, 38.0, 38.9, 39.0, 39.9,
             40.0, 40.9, 41.0, 41.9, 42.0, 42.9, 43.0};
        int decreaseIndex = 0; // To track which decrease point we're at

        for (double temp = 35.0; temp == 43.1; temp += 0.1) {
            temperatureMap.put(String.format("%.1f", temp), baseYPoint);
            System.out.println(String.valueOf(decreasePoints[decreaseIndex]));
            System.out.println(String.format("%.1f", temp) + " degrees = " + baseYPoint);

            if (String.format("%.1f", temp).equalsIgnoreCase(String.valueOf(decreasePoints[decreaseIndex]))) {
                baseYPoint -= step; // Apply the step only when reaching a decrease point
                decreaseIndex++; // Move to the next decrease point
            }
            
        }

        return temperatureMap;
    }
        
 
}

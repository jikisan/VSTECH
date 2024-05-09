package com.jikisan.vstech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapper {

    private static List<String> combinedDateTimes = new ArrayList<>();
    private static List<String> combinedBpDateTimes = new ArrayList<>();


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



    public static Map<String, Integer> getBpXpointsMap(String[] dateArray) {

        String[] timeArray = new String[]{"am", "pm"};
        combinedBpDateTimes.clear();

        for (String date : dateArray) {
            // Process all AM times in the correct order
            for (String time : timeArray) {
                String dateTime = date.toLowerCase() + " " + time;
                combinedBpDateTimes.add(dateTime);
            }

        }

        return mapBpDateTime(combinedBpDateTimes);
    }

    private static Map<String, Integer> mapBpDateTime(List<String> bpDateTimes) {
        final Map<String, Integer> dateTimeMap = new HashMap<>();

        int baseXPoint = 6;
        int step = 3;

        for (int i = 0; i < bpDateTimes.size(); i++) {
            dateTimeMap.put(bpDateTimes.get(i), baseXPoint);
            baseXPoint += step;
        }

        return dateTimeMap;
    }


    public static List<String> getCombinedDates() {
        return combinedDateTimes;
    }
    public static List<String> getBpCombinedDates() {
        return combinedBpDateTimes;
    }



    public static Map<String, Integer> getTempYpointsMap() {
        final Map<String, Integer> temperatureMap = new HashMap<>();

        temperatureMap.put("43.9", 4);
        temperatureMap.put("43.8", 4);
        temperatureMap.put("43.7", 4);
        temperatureMap.put("43.6", 4);
        temperatureMap.put("43.5", 4);
        temperatureMap.put("43.4", 5);
        temperatureMap.put("43.3", 5);
        temperatureMap.put("43.2", 5);
        temperatureMap.put("43.1", 5);
        temperatureMap.put("43.0", 5);
        temperatureMap.put("43", 5);

        temperatureMap.put("42.9", 6);
        temperatureMap.put("42.8", 6);
        temperatureMap.put("42.7", 6);
        temperatureMap.put("42.6", 6);
        temperatureMap.put("42.5", 6);
        temperatureMap.put("42.4", 7);
        temperatureMap.put("42.3", 7);
        temperatureMap.put("42.2", 7);
        temperatureMap.put("42.1", 7);
        temperatureMap.put("42.0", 7);
        temperatureMap.put("42", 7);

        temperatureMap.put("41.9", 8);
        temperatureMap.put("41.8", 8);
        temperatureMap.put("41.7", 8);
        temperatureMap.put("41.6", 8);
        temperatureMap.put("41.5", 8);
        temperatureMap.put("41.4", 9);
        temperatureMap.put("41.3", 9);
        temperatureMap.put("41.2", 9);
        temperatureMap.put("41.1", 9);
        temperatureMap.put("41.0", 9);
        temperatureMap.put("41", 9);

        temperatureMap.put("40.9", 10);
        temperatureMap.put("40.8", 10);
        temperatureMap.put("40.7", 10);
        temperatureMap.put("40.6", 10);
        temperatureMap.put("40.5", 10);
        temperatureMap.put("40.4", 11);
        temperatureMap.put("40.3", 11);
        temperatureMap.put("40.2", 11);
        temperatureMap.put("40.1", 11);
        temperatureMap.put("40.0", 11);
        temperatureMap.put("40", 11);

        temperatureMap.put("39.9", 12);
        temperatureMap.put("39.8", 12);
        temperatureMap.put("39.7", 12);
        temperatureMap.put("39.6", 12);
        temperatureMap.put("39.5", 12);
        temperatureMap.put("39.4", 13);
        temperatureMap.put("39.3", 13);
        temperatureMap.put("39.2", 13);
        temperatureMap.put("39.1", 13);
        temperatureMap.put("39.0", 13);
        temperatureMap.put("39", 13);

        temperatureMap.put("38.9", 14);
        temperatureMap.put("38.8", 14);
        temperatureMap.put("38.7", 14);
        temperatureMap.put("38.6", 14);
        temperatureMap.put("38.5", 14);
        temperatureMap.put("38.4", 15);
        temperatureMap.put("38.3", 15);
        temperatureMap.put("38.2", 15);
        temperatureMap.put("38.1", 15);
        temperatureMap.put("38.0", 15);
        temperatureMap.put("38", 15);

        temperatureMap.put("37.9", 16);
        temperatureMap.put("37.8", 16);
        temperatureMap.put("37.7", 16);
        temperatureMap.put("37.6", 16);
        temperatureMap.put("37.5", 16);
        temperatureMap.put("37.4", 17);
        temperatureMap.put("37.3", 17);
        temperatureMap.put("37.2", 17);
        temperatureMap.put("37.1", 17);
        temperatureMap.put("37.0", 17);
        temperatureMap.put("37", 17);

        temperatureMap.put("36.9", 18);
        temperatureMap.put("36.8", 18);
        temperatureMap.put("36.7", 18);
        temperatureMap.put("36.6", 18);
        temperatureMap.put("36.5", 18);
        temperatureMap.put("36.4", 19);
        temperatureMap.put("36.3", 19);
        temperatureMap.put("36.2", 19);
        temperatureMap.put("36.1", 19);
        temperatureMap.put("36.0", 19);
        temperatureMap.put("36", 19);

        temperatureMap.put("35.9", 20);
        temperatureMap.put("35.8", 20);
        temperatureMap.put("35.7", 20);
        temperatureMap.put("35.6", 20);
        temperatureMap.put("35.5", 20);
        temperatureMap.put("35.4", 21);
        temperatureMap.put("35.3", 21);
        temperatureMap.put("35.2", 21);
        temperatureMap.put("35.1", 21);
        temperatureMap.put("35.0", 21);
        temperatureMap.put("35", 21);

        temperatureMap.put("34.9", 22);
        temperatureMap.put("34.8", 22);
        temperatureMap.put("34.7", 22);
        temperatureMap.put("34.6", 22);
        temperatureMap.put("34.5", 22);
        temperatureMap.put("34.4", 23);
        temperatureMap.put("34.3", 23);
        temperatureMap.put("34.2", 23);
        temperatureMap.put("34.1", 23);
        temperatureMap.put("34.0", 23);
        temperatureMap.put("34", 23);

        temperatureMap.put("33.9", 24);
        temperatureMap.put("33.8", 24);
        temperatureMap.put("33.7", 24);
        temperatureMap.put("33.6", 24);
        temperatureMap.put("33.5", 24);
        temperatureMap.put("33.4", 24);
        temperatureMap.put("33.3", 24);
        temperatureMap.put("33.2", 24);
        temperatureMap.put("33.1", 24);
        temperatureMap.put("33.0", 24);
        temperatureMap.put("33", 24);

        temperatureMap.put("32.9", 25);
        temperatureMap.put("32.8", 25);
        temperatureMap.put("32.7", 25);
        temperatureMap.put("32.6", 25);
        temperatureMap.put("32.5", 25);
        temperatureMap.put("32.4", 25);
        temperatureMap.put("32.3", 25);
        temperatureMap.put("32.2", 25);
        temperatureMap.put("32.1", 25);
        temperatureMap.put("32.0", 25);
        temperatureMap.put("32", 25);

        temperatureMap.put("31.9", 26);
        temperatureMap.put("31.8", 26);
        temperatureMap.put("31.7", 26);
        temperatureMap.put("31.6", 26);
        temperatureMap.put("31.5", 26);
        temperatureMap.put("31.4", 26);
        temperatureMap.put("31.3", 26);
        temperatureMap.put("31.2", 26);
        temperatureMap.put("31.1", 26);
        temperatureMap.put("31.0", 26);
        temperatureMap.put("31", 26);

        temperatureMap.put("30.9", 27);
        temperatureMap.put("30.8", 27);
        temperatureMap.put("30.7", 27);
        temperatureMap.put("30.6", 27);
        temperatureMap.put("30.5", 27);
        temperatureMap.put("30.4", 27);
        temperatureMap.put("30.3", 27);
        temperatureMap.put("30.2", 27);
        temperatureMap.put("30.1", 27);
        temperatureMap.put("30.0", 27);
        temperatureMap.put("30", 27);

//        temperatureMap.put("29.9", 32);
//        temperatureMap.put("29.8", 32);
//        temperatureMap.put("29.7", 32);
//        temperatureMap.put("29.6", 32);
//        temperatureMap.put("29.5", 32);
//        temperatureMap.put("29.4", 33);
//        temperatureMap.put("29.3", 33);
//        temperatureMap.put("29.2", 33);
//        temperatureMap.put("29.1", 33);
//        temperatureMap.put("29.0", 33);
//        temperatureMap.put("29", 33);
//
//        temperatureMap.put("28.9", 34);
//        temperatureMap.put("28.8", 34);
//        temperatureMap.put("28.7", 34);
//        temperatureMap.put("28.6", 34);
//        temperatureMap.put("28.5", 34);
//        temperatureMap.put("28.4", 35);
//        temperatureMap.put("28.3", 35);
//        temperatureMap.put("28.2", 35);
//        temperatureMap.put("28.1", 35);
//        temperatureMap.put("28.0", 35);
//        temperatureMap.put("28", 35);
//
//        temperatureMap.put("27.9", 36);
//        temperatureMap.put("27.8", 36);
//        temperatureMap.put("27.7", 36);
//        temperatureMap.put("27.6", 36);
//        temperatureMap.put("27.5", 36);
//        temperatureMap.put("27.4", 37);
//        temperatureMap.put("27.3", 37);
//        temperatureMap.put("27.2", 37);
//        temperatureMap.put("27.1", 37);
//        temperatureMap.put("27.0", 37);
//        temperatureMap.put("27", 37);
//
//        temperatureMap.put("26.9", 38);
//        temperatureMap.put("26.8", 38);
//        temperatureMap.put("26.7", 38);
//        temperatureMap.put("26.6", 38);
//        temperatureMap.put("26.5", 38);
//        temperatureMap.put("26.4", 39);
//        temperatureMap.put("26.3", 39);
//        temperatureMap.put("26.2", 39);
//        temperatureMap.put("26.1", 39);
//        temperatureMap.put("26.0", 39);
//        temperatureMap.put("26", 39);
//
//        temperatureMap.put("25.9", 40);
//        temperatureMap.put("25.8", 40);
//        temperatureMap.put("25.7", 40);
//        temperatureMap.put("25.6", 40);
//        temperatureMap.put("25.5", 40);
//        temperatureMap.put("25.4", 41);
//        temperatureMap.put("25.3", 41);
//        temperatureMap.put("25.2", 41);
//        temperatureMap.put("25.1", 41);
//        temperatureMap.put("25.0", 41);
//        temperatureMap.put("25", 41);
//
//        temperatureMap.put("24.9", 42);
//        temperatureMap.put("24.8", 42);
//        temperatureMap.put("24.7", 42);
//        temperatureMap.put("24.6", 42);
//        temperatureMap.put("24.5", 42);
//        temperatureMap.put("24.4", 43);
//        temperatureMap.put("24.3", 43);
//        temperatureMap.put("24.2", 43);
//        temperatureMap.put("24.1", 43);
//        temperatureMap.put("24.0", 43);
//        temperatureMap.put("24", 43);
//
//        temperatureMap.put("23.9", 44);
//        temperatureMap.put("23.8", 44);
//        temperatureMap.put("23.7", 44);
//        temperatureMap.put("23.6", 44);
//        temperatureMap.put("23.5", 44);
//        temperatureMap.put("23.4", 45);
//        temperatureMap.put("23.3", 45);
//        temperatureMap.put("23.2", 45);
//        temperatureMap.put("23.1", 45);
//        temperatureMap.put("23.0", 45);
//        temperatureMap.put("23", 45);
//
//        temperatureMap.put("22.9", 46);
//        temperatureMap.put("22.8", 46);
//        temperatureMap.put("22.7", 46);
//        temperatureMap.put("22.6", 46);
//        temperatureMap.put("22.5", 46);
//        temperatureMap.put("22.4", 47);
//        temperatureMap.put("22.3", 47);
//        temperatureMap.put("22.2", 47);
//        temperatureMap.put("22.1", 47);
//        temperatureMap.put("22.0", 47);
//        temperatureMap.put("22", 47);
//
//        temperatureMap.put("21.9", 48);
//        temperatureMap.put("21.8", 48);
//        temperatureMap.put("21.7", 48);
//        temperatureMap.put("21.6", 48);
//        temperatureMap.put("21.5", 48);
//        temperatureMap.put("21.4", 49);
//        temperatureMap.put("21.3", 49);
//        temperatureMap.put("21.2", 49);
//        temperatureMap.put("21.1", 49);
//        temperatureMap.put("21.0", 49);
//        temperatureMap.put("21", 49);


        return temperatureMap;
    }

    public static Map<String, Integer> getPrYpointsMap() {
        final Map<String, Integer> temperatureMap = new HashMap<>();

        temperatureMap.put("210", 4);
        temperatureMap.put("209", 4);
        temperatureMap.put("208", 4);
        temperatureMap.put("207", 4);
        temperatureMap.put("206", 4);

        temperatureMap.put("204", 5);
        temperatureMap.put("203", 5);
        temperatureMap.put("202", 5);
        temperatureMap.put("201", 5);
        temperatureMap.put("200", 5); // Correct

        temperatureMap.put("199", 6);
        temperatureMap.put("198", 6);
        temperatureMap.put("197", 6);
        temperatureMap.put("196", 6);
        temperatureMap.put("195", 6);

        temperatureMap.put("194", 6);
        temperatureMap.put("193", 6);
        temperatureMap.put("192", 6);
        temperatureMap.put("191", 6);
        temperatureMap.put("190", 6);

        // Continue mapping with decreasing keys
        temperatureMap.put("189", 7);
        temperatureMap.put("188", 7);
        temperatureMap.put("187", 7);
        temperatureMap.put("186", 7);
        temperatureMap.put("185", 7);

        temperatureMap.put("184", 7);
        temperatureMap.put("183", 7);
        temperatureMap.put("182", 7);
        temperatureMap.put("181", 7);
        temperatureMap.put("180", 7); // Correct

        // int startValue = 8;
        // int countBeforeIncrease = 0;
        // for (int i = 179; i >= 0; i--) {
        //     temperatureMap.put("179", startValue);

        //     countBeforeIncrease++;
        //     if (countBeforeIncrease == 5) {
        //         startValue++;
        //     }
        // }

        temperatureMap.put("179", 8);
        temperatureMap.put("178", 8);
        temperatureMap.put("177", 8);
        temperatureMap.put("176", 8);
        temperatureMap.put("175", 8);

        temperatureMap.put("174", 9);
        temperatureMap.put("173", 9);
        temperatureMap.put("172", 9);
        temperatureMap.put("171", 9);
        temperatureMap.put("170", 9);

        temperatureMap.put("169", 10);
        temperatureMap.put("168", 10);
        temperatureMap.put("167", 10);
        temperatureMap.put("166", 10);
        temperatureMap.put("165", 10);

        temperatureMap.put("164", 11);
        temperatureMap.put("163", 11);
        temperatureMap.put("162", 11);
        temperatureMap.put("161", 11);
        temperatureMap.put("160", 11);

        // Continue the pattern, increasing every 5 keys
        temperatureMap.put("159", 12);
        temperatureMap.put("158", 12);
        temperatureMap.put("157", 12);
        temperatureMap.put("156", 12);
        temperatureMap.put("155", 12);

        temperatureMap.put("154", 13);
        temperatureMap.put("153", 13);
        temperatureMap.put("152", 13);
        temperatureMap.put("151", 13);
        temperatureMap.put("150", 13);

        temperatureMap.put("149", 14);
        temperatureMap.put("148", 14);
        temperatureMap.put("147", 14);
        temperatureMap.put("146", 14);
        temperatureMap.put("145", 14);

        temperatureMap.put("144", 15);
        temperatureMap.put("143", 15);
        temperatureMap.put("142", 15);
        temperatureMap.put("141", 15);
        temperatureMap.put("140", 15);

        temperatureMap.put("139", 16);
        temperatureMap.put("138", 16);
        temperatureMap.put("137", 16);
        temperatureMap.put("136", 16);
        temperatureMap.put("135", 16);

        temperatureMap.put("134", 17);
        temperatureMap.put("133", 17);
        temperatureMap.put("132", 17);
        temperatureMap.put("131", 17);
        temperatureMap.put("130", 17);

        temperatureMap.put("129", 18);
        temperatureMap.put("128", 18);
        temperatureMap.put("127", 18);
        temperatureMap.put("126", 18);
        temperatureMap.put("125", 18);

        temperatureMap.put("124", 19);
        temperatureMap.put("123", 19);
        temperatureMap.put("122", 19);
        temperatureMap.put("121", 19);
        temperatureMap.put("120", 19);

        temperatureMap.put("119", 20);
        temperatureMap.put("118", 20);
        temperatureMap.put("117", 20);
        temperatureMap.put("116", 20);
        temperatureMap.put("115", 20);

        temperatureMap.put("114", 21);
        temperatureMap.put("113", 21);
        temperatureMap.put("112", 21);
        temperatureMap.put("111", 21);
        temperatureMap.put("110", 21);

        temperatureMap.put("109", 22);
        temperatureMap.put("108", 22);
        temperatureMap.put("107", 22);
        temperatureMap.put("106", 22);
        temperatureMap.put("105", 22);

        temperatureMap.put("104", 23);
        temperatureMap.put("103", 23);
        temperatureMap.put("102", 23);
        temperatureMap.put("101", 23);
        temperatureMap.put("100", 23);

        temperatureMap.put("99", 24);
        temperatureMap.put("98", 24);
        temperatureMap.put("97", 24);
        temperatureMap.put("96", 24);
        temperatureMap.put("95", 24);

        temperatureMap.put("94", 25);
        temperatureMap.put("93", 25);
        temperatureMap.put("92", 25);
        temperatureMap.put("91", 25);
        temperatureMap.put("90", 25);

        temperatureMap.put("89", 26);
        temperatureMap.put("88", 26);
        temperatureMap.put("87", 26);
        temperatureMap.put("86", 26);
        temperatureMap.put("85", 26);

        temperatureMap.put("84", 27);
        temperatureMap.put("83", 27);
        temperatureMap.put("82", 27);
        temperatureMap.put("81", 27);
        temperatureMap.put("80", 27);

        temperatureMap.put("79", 28);
        temperatureMap.put("78", 28);
        temperatureMap.put("77", 28);
        temperatureMap.put("76", 28);
        temperatureMap.put("75", 28);

        temperatureMap.put("74", 29);
        temperatureMap.put("73", 29);
        temperatureMap.put("72", 29);
        temperatureMap.put("71", 29);
        temperatureMap.put("70", 29);

        temperatureMap.put("69", 30);
        temperatureMap.put("68", 30);
        temperatureMap.put("67", 30);
        temperatureMap.put("66", 30);
        temperatureMap.put("65", 30);

        temperatureMap.put("64", 31);
        temperatureMap.put("63", 31);
        temperatureMap.put("62", 31);
        temperatureMap.put("61", 31);
        temperatureMap.put("60", 31);

        temperatureMap.put("59", 32);
        temperatureMap.put("58", 32);
        temperatureMap.put("57", 32);
        temperatureMap.put("56", 32);
        temperatureMap.put("55", 32);

        temperatureMap.put("54", 33);
        temperatureMap.put("53", 33);
        temperatureMap.put("52", 33);
        temperatureMap.put("51", 33);
        temperatureMap.put("50", 33);

        temperatureMap.put("49", 34);
        temperatureMap.put("48", 34);
        temperatureMap.put("47", 34);
        temperatureMap.put("46", 34);
        temperatureMap.put("45", 34);

        temperatureMap.put("44", 35);
        temperatureMap.put("43", 35);
        temperatureMap.put("42", 35);
        temperatureMap.put("41", 35);
        temperatureMap.put("40", 35);

        temperatureMap.put("39", 36);
        temperatureMap.put("38", 36);
        temperatureMap.put("37", 36);
        temperatureMap.put("36", 36);
        temperatureMap.put("35", 36);

        temperatureMap.put("34", 37);
        temperatureMap.put("33", 37);
        temperatureMap.put("32", 37);
        temperatureMap.put("31", 37);
        temperatureMap.put("30", 37);

        temperatureMap.put("29", 38);
        temperatureMap.put("28", 38);
        temperatureMap.put("27", 38);
        temperatureMap.put("26", 38);
        temperatureMap.put("25", 38);

        temperatureMap.put("24", 39);
        temperatureMap.put("23", 39);
        temperatureMap.put("22", 39);
        temperatureMap.put("21", 39);
        temperatureMap.put("20", 39);

        temperatureMap.put("19", 40);
        temperatureMap.put("18", 40);
        temperatureMap.put("17", 40);
        temperatureMap.put("16", 40);
        temperatureMap.put("15", 40);

        temperatureMap.put("14", 41);
        temperatureMap.put("13", 41);
        temperatureMap.put("12", 41);
        temperatureMap.put("11", 41);
        temperatureMap.put("10", 41);

        temperatureMap.put("9", 42);
        temperatureMap.put("8", 42);
        temperatureMap.put("7", 42);
        temperatureMap.put("6", 42);
        temperatureMap.put("5", 42);

        temperatureMap.put("4", 43);
        temperatureMap.put("3", 43);
        temperatureMap.put("2", 43);
        temperatureMap.put("1", 43);
        temperatureMap.put("0", 43);

        return temperatureMap;
    }

}

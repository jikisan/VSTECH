package com.jikisan.vstech;

import java.util.HashMap;
import java.util.Map;

public class TemperatureToYPointMapper {

    // Static map for hardcoded temperature-to-y-point mapping
    private static final Map<Double, Double> temperatureMap = new HashMap<>();

    static {
        // Populate the map with temperatures from 35 to 45 degrees
        double baseYPoint = 25.0; // Starting y-point for 35 degrees
        double step = -1.0; // Decrease by 1 for each 0.1 degrees increase in temperature

        // Fill the map from 35.0 to 45.0 degrees
        for (double temp = 35.0; temp <= 45.0; temp += 0.1) {
            temperatureMap.put(temp, baseYPoint);
            baseYPoint += step; // Move to the next y-point
        }
    }

    public double getYPoint(double temperature) {
        if (temperatureMap.containsKey(temperature)) {
            return temperatureMap.get(temperature);
        } else {
            throw new IllegalArgumentException("Temperature not in the predefined range.");
        }
    }

    public static void main(String[] args) {
        TemperatureToYPointMapper mapper = new TemperatureToYPointMapper();

        // Test with some temperatures
        try {
            System.out.println("Y-Point for 35 degrees: " + mapper.getYPoint(35.0));
            System.out.println("Y-Point for 36.5 degrees: " + mapper.getYPoint(36.5));
            System.out.println("Y-Point for 40 degrees: " + mapper.getYPoint(40.0));
            System.out.println("Y-Point for 45 degrees: " + mapper.getYPoint(45.0));

            // This will throw an exception because it's out of range
            System.out.println("Y-Point for 34 degrees: " + mapper.getYPoint(34.0));
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

package com.eid.temperature.app;

public class ReadingsValidator {

    public boolean isValid(Readings readings) {
        return readings != null && readings.getReadings().stream().noneMatch(x -> x < 0);
    }

}

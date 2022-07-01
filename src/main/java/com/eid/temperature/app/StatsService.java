package com.eid.temperature.app;

import org.springframework.stereotype.Service;

@Service
public class StatsService {
    public Long computeMaxIncrement(Readings readings) {
        MaxIncrementComputer maxIncrementComputer = new MaxIncrementComputer();
        return maxIncrementComputer.compute(readings.getReadings());
    }
}

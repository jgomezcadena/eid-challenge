package com.eid.temperature.app;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Readings {

    @NotNull
    private List<Long> readings = new ArrayList<>();

    public List<Long> getReadings() {
        return readings;
    }

    public void setReadings(List<Long> readings) {
        this.readings = readings;
    }
}

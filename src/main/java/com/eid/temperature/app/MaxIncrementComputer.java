package com.eid.temperature.app;

import java.util.List;

public class MaxIncrementComputer {

    public Long compute(List<Long> numbers) {

        if (numbers.isEmpty()) {
            return 0L;
        }

        long base = numbers.get(0);
        long last = base;
        long currentIncrement = 0L;
        long maxIncrement = currentIncrement;

        for (Long n : numbers) {
            if (n < 0 ) {
                throw new IllegalArgumentException("Negative numbers not allowed.");
            }
            if (n >= last) {
                currentIncrement = n - base;
                last = n;
            } else {
                base = n;
            }

            if (currentIncrement > maxIncrement) {
                maxIncrement = currentIncrement;
            }
        }

        return maxIncrement;
    }

}

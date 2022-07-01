package com.eid.temperature.app;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxIncrementComputerTest {

    @Test
    public void testMaxIncrementComputer1() {

        MaxIncrementComputer mic = new MaxIncrementComputer();
        List<Long> numbers = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 0L, 4L, 1L, 2L, 3L));

        Long maxIncrement = mic.compute(numbers);
        assertEquals(4L, maxIncrement);
    }

    @Test
    public void testMaxIncrementComputer2() {

        MaxIncrementComputer mic = new MaxIncrementComputer();
        List<Long> numbers = new ArrayList<>(Arrays.asList(10L, 15L, 18L, 1L, 8L));

        Long maxIncrement = mic.compute(numbers);
        assertEquals(8L, maxIncrement);
    }

    @Test
    public void testMaxIncrementComputer3() {

        MaxIncrementComputer mic = new MaxIncrementComputer();
        List<Long> numbers = new ArrayList<>(List.of());

        Long maxIncrement = mic.compute(numbers);
        assertEquals(0L, maxIncrement);
    }

    @Test
    public void testMaxIncrementComputer4() {

        MaxIncrementComputer mic = new MaxIncrementComputer();
        List<Long> numbers = new ArrayList<>(List.of(1L));

        Long maxIncrement = mic.compute(numbers);
        assertEquals(0L, maxIncrement);
    }

    @Test
    public void testMaxIncrementComputer5() {

        MaxIncrementComputer mic = new MaxIncrementComputer();
        List<Long> numbers = new ArrayList<>(Arrays.asList(1L, 1L, 1L));

        Long maxIncrement = mic.compute(numbers);
        assertEquals(0L, maxIncrement);
    }

    @Test
    public void testMaxIncrementComputer6() {

        MaxIncrementComputer mic = new MaxIncrementComputer();
        List<Long> numbers = new ArrayList<>(Arrays.asList(1L, 2L, 3L));

        Long maxIncrement = mic.compute(numbers);
        assertEquals(2L, maxIncrement);
    }

    @Test
    public void testMaxIncrementComputer7() {

        MaxIncrementComputer mic = new MaxIncrementComputer();
        List<Long> numbers = new ArrayList<>(Arrays.asList(3L, 2L, 1L));

        Long maxIncrement = mic.compute(numbers);
        assertEquals(0L, maxIncrement);
    }

    @Test
    public void testMaxIncrementComputer8() {

        MaxIncrementComputer mic = new MaxIncrementComputer();
        List<Long> numbers = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 4L));

        Long maxIncrement = mic.compute(numbers);
        assertEquals(3L, maxIncrement);
    }

}

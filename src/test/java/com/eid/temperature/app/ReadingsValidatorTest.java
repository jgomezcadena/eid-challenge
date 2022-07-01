package com.eid.temperature.app;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReadingsValidatorTest {

    @Test
    public void testValidReadings1() {
        ReadingsValidator rv = new ReadingsValidator();
        Readings r = new Readings();
        r.setReadings(Arrays.asList(1L,2L,3L));

        assertTrue(rv.isValid(r));
    }

    @Test
    public void testValidReadings2() {
        ReadingsValidator rv = new ReadingsValidator();
        Readings r = new Readings();
        r.setReadings(new ArrayList<>());

        assertTrue(rv.isValid(r));
    }

    @Test
    public void testValidReadings3() {
        ReadingsValidator rv = new ReadingsValidator();
        Readings r = new Readings();
        r.setReadings(List.of(1L));

        assertTrue(rv.isValid(r));
    }

    @Test
    public void testValidReadings4() {
        ReadingsValidator rv = new ReadingsValidator();
        Readings r = new Readings();
        r.setReadings(Arrays.asList(1L,1L,1L));

        assertTrue(rv.isValid(r));
    }

    @Test
    public void testValidReadings5() {
        ReadingsValidator rv = new ReadingsValidator();
        Readings r = new Readings();
        r.setReadings(Arrays.asList(0L,2L,3L));

        assertTrue(rv.isValid(r));
    }

    @Test
    public void testInvalidReadings() {
        ReadingsValidator rv = new ReadingsValidator();
        Readings r = new Readings();
        r.setReadings(Arrays.asList(1L,-2L,3L));

        assertFalse(rv.isValid(r));
    }
}

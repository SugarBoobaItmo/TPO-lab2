package com.MomsDeveloper.logarithmic;

import com.MomsDeveloper.Mocks;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Log5Test {
    private Ln ln;
    private static Mocks mocks;
    private LogBase log5;

    @BeforeAll
    public static void setUp() {
        mocks = new Mocks();
    }

    @BeforeEach
    public void init() {
        ln = mocks.getLn();
        log5 = new LogBase(ln, 5);
    }

    @Test
    public void testCalculateInvalidParams() {
        assertEquals(Double.NaN, log5.calculate(Double.NaN, 10), 1e-10);
        assertEquals(Double.NaN, log5.calculate(Double.POSITIVE_INFINITY, 10), 1e-10);
        assertEquals(Double.NaN, log5.calculate(Double.NEGATIVE_INFINITY, 10), 1e-10);
    }

    @Test
    public void testCalculateZero() {
        assertEquals(Double.NaN, log5.calculate(0, 10), 1e-10);
    }

    @Test
    public void testCalculateLessThanZero() {
        assertEquals(Double.NaN, log5.calculate(-1, 10), 1e-10);
        assertEquals(Double.NaN, log5.calculate(-10, 10), 1e-10);
    }

    @Test
    public void testCalculateLessThanOne() {
        assertEquals(-0.43067655807339306, log5.calculate(0.5, 10), 1e-3);
        assertEquals(-1, log5.calculate(0.2, 10), 1e-3);
    }

    @Test
    public void testCalculateOne() {
        assertEquals(0.0, log5.calculate(1, 10), 1e-10);
    }

    @Test
    public void testCalculateFives() {
        assertEquals(1.0, log5.calculate(5, 10), 1e-10);
        assertEquals(2.0, log5.calculate(25, 10), 1e-10);
        assertEquals(3.0, log5.calculate(125, 10), 1e-10);
    }

}

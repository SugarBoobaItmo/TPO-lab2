package com.MomsDeveloper.logarithmic;

import com.MomsDeveloper.Mocks;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Log10Test {
    private Ln ln;
    private static Mocks mocks;
    private LogBase log10;

    @BeforeAll
    public static void setUp() {
        mocks = new Mocks();
    }

    @BeforeEach
    public void init() {
        ln = mocks.getLn();
        log10 = new LogBase(ln, 10);
    }

    @Test
    public void testCalculateInvalidParams() {
        assertEquals(Double.NaN, log10.calculate(Double.NaN, 10), 1e-10);
        assertEquals(Double.NaN, log10.calculate(Double.POSITIVE_INFINITY, 10), 1e-10);
        assertEquals(Double.NaN, log10.calculate(Double.NEGATIVE_INFINITY, 10), 1e-10);
    }

    @Test
    public void testCalculateZero() {
        assertEquals(Double.NaN, log10.calculate(0, 10), 1e-10);
    }

    @Test
    public void testCalculateLessThanZero() {
        assertEquals(Double.NaN, log10.calculate(-1, 10), 1e-10);
        assertEquals(Double.NaN, log10.calculate(-10, 10), 1e-10);
    }

    @Test
    public void testCalculateLessThanOne() {
        assertEquals(-0.3010299956639812, log10.calculate(0.5, 10), 1e-3);
        assertEquals(-0.6989700043360189, log10.calculate(0.2, 10), 1e-3);
    }

    @Test
    public void testCalculateOne() {
        assertEquals(0.0, log10.calculate(1, 10), 1e-10);
    }

    @Test
    public void testCalculateTens() {
        assertEquals(1.0, log10.calculate(10, 10), 1e-10);
        assertEquals(2.0, log10.calculate(100, 10), 1e-10);
        assertEquals(3.0, log10.calculate(1000, 10), 1e-10);
    }
}

package com.MomsDeveloper.logarithmic;

import com.MomsDeveloper.Mocks;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Log2Test {
    private Ln ln;
    private static Mocks mocks;
    private LogBase log2;
    
    @BeforeAll
    public static void setUp() {
        mocks = new Mocks();
    }

    @BeforeEach
    public void init() {
        ln = mocks.getLn();
        log2 = new LogBase(ln, 2);
    }

    @Test
    public void testCalculateInvalidParams() {
        assertEquals(Double.NaN, log2.calculate(Double.NaN, 10), 1e-10);
        assertEquals(Double.NaN, log2.calculate(Double.POSITIVE_INFINITY, 10), 1e-10);
        assertEquals(Double.NaN, log2.calculate(Double.NEGATIVE_INFINITY, 10), 1e-10);
    }

    @Test
    public void testCalculateZero() {
        assertEquals(Double.NaN, log2.calculate(0, 10), 1e-10);
    }

    @Test
    public void testCalculateLessThanZero() {
        assertEquals(Double.NaN, log2.calculate(-1, 10), 1e-10);
        assertEquals(Double.NaN, log2.calculate(-10, 10), 1e-10);
    }

    @Test
    public void testCalculateLessThanOne() {
        assertEquals(-1.0, log2.calculate(0.5, 10), 1e-3);
        assertEquals(-2.321928094887362, log2.calculate(0.2, 10), 1e-3);
    }

    @Test
    public void testCalculateOne() {
        assertEquals(0.0, log2.calculate(1, 10), 1e-10);
    }

    @Test
    public void testCalculateTwos() {
        assertEquals(1.0, log2.calculate(2, 10), 1e-10);
        assertEquals(2.0, log2.calculate(4, 10), 1e-10);
        assertEquals(3.0, log2.calculate(8, 10), 1e-10);
    }
}

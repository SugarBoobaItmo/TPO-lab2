package com.MomsDeveloper.logarithmic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LnTest {
    private Ln ln;

    @BeforeEach
    public void init() {
        ln = new Ln();
    }

    @Test
    public void testCalculateInvalidParams() {
        assertEquals(Double.NaN, ln.calculate(Double.NaN, 10), 1e-10);
        assertEquals(Double.NaN, ln.calculate(Double.POSITIVE_INFINITY, 10), 1e-10);
        assertEquals(Double.NaN, ln.calculate(Double.NEGATIVE_INFINITY, 10), 1e-10);
    }

    @Test
    public void testCalculateZero() {
        assertEquals(Double.NaN, ln.calculate(0, 10), 1e-10);
    }

    @Test
    public void testCalculateLessThanZero() {
        assertEquals(Double.NaN, ln.calculate(-1, 10), 1e-10);
        assertEquals(Double.NaN, ln.calculate(-10, 10), 1e-10);
    }

    @Test
    public void testCalculateLessThanOne() {
        assertEquals(-0.6931471805599453, ln.calculate(0.5, 10), 1e-3);
        assertEquals(-1.6094379124341003, ln.calculate(0.2, 10), 1e-3);
    }

    @Test
    public void testCalculateOne() {
        assertEquals(0.0, ln.calculate(1, 10), 1e-10);
    }

    @Test
    public void testCalculateE() {
        assertEquals(1.0, ln.calculate(Math.E, 100), 1e-10);
        assertEquals(2.0, ln.calculate(Math.E * Math.E, 100), 1e-10);
        assertEquals(3.0, ln.calculate(Math.E * Math.E * Math.E, 100), 1e-10);
    }

}

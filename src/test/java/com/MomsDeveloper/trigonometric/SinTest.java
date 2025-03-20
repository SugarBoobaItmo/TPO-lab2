package com.MomsDeveloper.trigonometric;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class SinTest {
    @Test
    public void testCalculateInvalidParams() {
        Sin sin = new Sin();
        assertEquals(Double.NaN, sin.calculate(Double.NaN, 10), 1e-10);
        assertEquals(Double.NaN, sin.calculate(Double.POSITIVE_INFINITY, 10), 1e-10);
        assertEquals(Double.NaN, sin.calculate(Double.NEGATIVE_INFINITY, 10), 1e-10);
    }

    @Test
    public void testCalculateZero() {
        Sin sin = new Sin();
        assertEquals(0.0, sin.calculate(0.0, 10), 1e-10);
        assertEquals(0.0, sin.calculate(2 * Math.PI, 10), 1e-10);
        assertEquals(0.0, sin.calculate(-2 * Math.PI, 10), 1e-10);
    }

    @Test
    public void testCalculatePi() {
        Sin sin = new Sin();
        assertEquals(0.0, sin.calculate(Math.PI, 10), 1e-10);
        assertEquals(0.0, sin.calculate(-Math.PI, 10), 1e-10);
    }

    @Test
    public void testCalculatePiDividedByTwo() {
        Sin sin = new Sin();
        assertEquals(1.0, sin.calculate(Math.PI / 2, 10), 1e-6);
        assertEquals(-1.0, sin.calculate(-Math.PI / 2, 10), 1e-6);
    }

    @Test
    public void testCalculatePiDividedByFour() {
        Sin sin = new Sin();
        assertEquals(Math.sqrt(2) / 2, sin.calculate(Math.PI / 4, 10), 1e-5);
        assertEquals(-Math.sqrt(2) / 2, sin.calculate(-Math.PI / 4, 10), 1e-5);
    }
    
}

package com.MomsDeveloper.trigonometric;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.MomsDeveloper.Mocks;

public class CscTest {
    private Sin sin;
    private static Mocks mocks;
    private Csc csc;

    @BeforeAll
    public static void setUp() {
        mocks = new Mocks();
    }

    @BeforeEach
    public void init() {
        sin = mocks.getSin();
        csc = new Csc(sin);
    }
    
    @Test
    public void testCalculateInvalidParams() {
        assertEquals(Double.NaN, csc.calculate(Double.NaN, 10), 1e-10);
        assertEquals(Double.NaN, csc.calculate(Double.POSITIVE_INFINITY, 10), 1e-10);
        assertEquals(Double.NaN, csc.calculate(Double.NEGATIVE_INFINITY, 10), 1e-10);
    }

    @Test
    public void testCalculateZero() {
        assertEquals(Double.NaN, csc.calculate(0, 10), 1e-10);
        assertEquals(Double.NaN, csc.calculate(2 * Math.PI, 10), 1e-10);
        assertEquals(Double.NaN, csc.calculate(-2 * Math.PI, 10), 1e-10);
    }

    @Test
    public void testCalculatePi() {
        assertEquals(Double.NaN, csc.calculate(Math.PI, 10), 1e-10);
        assertEquals(Double.NaN, csc.calculate(-Math.PI, 10), 1e-10);
    }

    @Test
    public void testCalculatePiDividedByTwo() {
        assertEquals(1.0, csc.calculate(Math.PI / 2, 10), 1e-10);
        assertEquals(-1.0, csc.calculate(-Math.PI / 2, 10), 1e-10);
    }

    @Test
    public void testCalculatePiDividedByFour() {
        assertEquals(Math.sqrt(2), csc.calculate(Math.PI / 4, 10), 1e-10);
        assertEquals(-Math.sqrt(2), csc.calculate(-Math.PI / 4, 10), 1e-10);
    }
}

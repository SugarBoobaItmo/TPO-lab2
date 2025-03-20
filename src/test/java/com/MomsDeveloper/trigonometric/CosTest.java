package com.MomsDeveloper.trigonometric;

import org.junit.jupiter.api.Test;

import com.MomsDeveloper.Mocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class CosTest {
    private Sin sin;
    private Cos cos;
    private static Mocks mocks;

    @BeforeAll
    public static void setUp() {
        mocks = new Mocks();
    }

    @BeforeEach
    public void init() {
        sin = mocks.getSin();
        cos = new Cos(sin);
    }

    @Test
    public void testCalculateInvalidParams() {
        assertEquals(Double.NaN, cos.calculate(Double.NaN, 10), 1e-10);
        assertEquals(Double.NaN, cos.calculate(Double.POSITIVE_INFINITY, 10), 1e-10);
        assertEquals(Double.NaN, cos.calculate(Double.NEGATIVE_INFINITY, 10), 1e-10);
    }

    @Test
    public void testCalculateZero() {
        assertEquals(1.0, cos.calculate(0, 10), 1e-10);
        assertEquals(1.0, cos.calculate(2 * Math.PI, 10), 1e-10);
        assertEquals(1.0, cos.calculate(-2 * Math.PI, 10), 1e-10);
    }

    @Test
    public void testCalculatePi() {
        Cos cos = new Cos(sin);
        assertEquals(-1.0, cos.calculate(Math.PI, 10), 1e-10);
        assertEquals(-1.0, cos.calculate(-Math.PI, 10), 1e-10);
    }

    @Test
    public void testCalculatePiDividedByTwo() {
        Cos cos = new Cos(sin);
        assertEquals(0.0, cos.calculate(Math.PI / 2, 10), 1e-10);
        assertEquals(0.0, cos.calculate(-Math.PI / 2, 10), 1e-10);
    }

    @Test
    public void testCalculatePiDividedByFour() {
        Cos cos = new Cos(sin);
        assertEquals(Math.sqrt(2) / 2, cos.calculate(-Math.PI / 4, 10), 1e-5);
    }

}    

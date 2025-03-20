package com.MomsDeveloper;

import org.junit.jupiter.api.Test;

import com.MomsDeveloper.logarithmic.Ln;
import com.MomsDeveloper.logarithmic.LogBase;
import com.MomsDeveloper.trigonometric.Cos;
import com.MomsDeveloper.trigonometric.Cot;
import com.MomsDeveloper.trigonometric.Csc;
import com.MomsDeveloper.trigonometric.Tan;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class FunctionSystemTest {
    private Csc csc;
    private Tan tan;
    private Cos cos;
    private Cot cot;
    private Ln ln;
    private LogBase log5;
    private LogBase log10;
    private LogBase log2;
    private static Mocks mocks;
    private FunctionSystem functionSystem;

    @BeforeAll
    public static void setUp() {
        mocks = new Mocks();
    }

    @BeforeEach
    public void init() {
        csc = mocks.getCsc();
        tan = mocks.getTan();
        cos = mocks.getCos();
        cot = mocks.getCot();
        ln = mocks.getLn();
        log5 = mocks.getLog5();
        log10 = mocks.getLog10();
        log2 = mocks.getLog2();
        functionSystem = new FunctionSystem(csc, tan, cos, cot, ln, log5, log10, log2);
    }

    @Test
    public void testCalculateInvalidParams() {
        assertEquals(Double.NaN, functionSystem.calculate(Double.NaN, 10), 1e-10);
        assertEquals(Double.NaN, functionSystem.calculate(Double.POSITIVE_INFINITY, 10), 1e-10);
        assertEquals(Double.NaN, functionSystem.calculate(Double.NEGATIVE_INFINITY, 10), 1e-10);
    }

    @Test
    public void testCalculateZero() {
        assertEquals(Double.NaN, functionSystem.calculate(0, 10), 1e-10);
    }

    @Test
    public void testMoreThanZero() {
        assertEquals(Math.PI / 4, functionSystem.calculate(0.41465, 10), 1e-4);
        assertEquals(Math.PI, functionSystem.calculate(3.03169, 10), 1e-4);
        assertEquals(3 * Math.PI / 4, functionSystem.calculate(2.87829, 10), 1e-4);
    }

    @Test
    public void testLessThanZero() {
        assertEquals(-Math.PI / 4, functionSystem.calculate(-0.90502, 10), 1e-4);
        assertEquals(-Math.PI, functionSystem.calculate(-0.30817, 10), 1e-4);
        assertEquals(-3 * Math.PI / 4, functionSystem.calculate(-0.40137, 10), 1e-4);
    }

}

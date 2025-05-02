package com.MomsDeveloper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.MomsDeveloper.trigonometric.*;
import com.MomsDeveloper.logarithmic.*;

public class IntegrationTests {
    @Test
    public void testFunctionSystem(){
        Mocks mocks = new Mocks();
        Sin sin = new Sin();
        Cos cos_mocked = mocks.getCos();
        Cos cos = new Cos(sin);
        Tan tan_mocked = mocks.getTan();
        Tan tan = new Tan(sin, cos);
        Cot cot_mocked = mocks.getCot();
        Cot cot = new Cot(sin, cos);
        Csc csc_mocked = mocks.getCsc();
        Csc csc = new Csc(sin);
        Ln ln_mocked = mocks.getLn();
        Ln ln = new Ln();
        LogBase log2_mocked = mocks.getLog2();
        LogBase log2 = new LogBase(ln, 2);
        LogBase log5_mocked = mocks.getLog5();
        LogBase log5 = new LogBase(ln, 5);
        LogBase log10_mocked = mocks.getLog10();
        LogBase log10 = new LogBase(ln, 10);

        double angel = -Math.PI / 4;
        double value = 8.0;
        double log2_res = Math.log(8) / Math.log(2);
        double log5_res = Math.log(8) / Math.log(5);
        double log10_res = Math.log(8) / Math.log(10);
        double denominator1 = log5_res;
        double denominator2 = ((log2_res + log10_res) + log2_res);

        double expected = Math.pow((log2_res * log5_res) / denominator1 * (log2_res - 0), 3) * (log5_res / denominator2);

        FunctionSystem functionSystem1 = new FunctionSystem(csc, tan_mocked, cos_mocked, cot_mocked, ln_mocked, log5_mocked, log10_mocked, log2_mocked);
        assertEquals(-(Math.sqrt(2) * 1.0) * (Math.sqrt(2) / 2 * 1.0), functionSystem1.calculate(angel, 10), 1e-5, "Function System 1 is incorrect");
        FunctionSystem functionSystem2 = new FunctionSystem(csc_mocked, tan, cos_mocked, cot_mocked, ln_mocked, log5_mocked, log10_mocked, log2_mocked);
        assertEquals(-(Math.sqrt(2) * 1.0) * (Math.sqrt(2) / 2 * 1.0), functionSystem2.calculate(angel, 10), 1e-5, "Function System 2 is incorrect");
        FunctionSystem functionSystem3 = new FunctionSystem(csc_mocked, tan_mocked, cos, cot_mocked, ln_mocked, log5_mocked, log10_mocked, log2_mocked);
        assertEquals(-(Math.sqrt(2) * 1.0) * (Math.sqrt(2) / 2 * 1.0), functionSystem3.calculate(angel, 10), 1e-5, "Function System 3 is incorrect");
        FunctionSystem functionSystem4 = new FunctionSystem(csc_mocked, tan_mocked, cos_mocked, cot, ln_mocked, log5_mocked, log10_mocked, log2_mocked);
        assertEquals(-(Math.sqrt(2) * 1.0) * (Math.sqrt(2) / 2 * 1.0), functionSystem4.calculate(angel, 10), 1e-5, "Function System 4 is incorrect");
        FunctionSystem functionSystem5 = new FunctionSystem(csc_mocked, tan_mocked, cos_mocked, cot_mocked, ln, log5_mocked, log10_mocked, log2_mocked);
        assertEquals(-(Math.sqrt(2) * 1.0) * (Math.sqrt(2) / 2 * 1.0), functionSystem5.calculate(angel, 10), 1e-5, "Function System 5 is incorrect");
        FunctionSystem functionSystem6 = new FunctionSystem(csc_mocked, tan_mocked, cos_mocked, cot_mocked, ln_mocked, log5, log10_mocked, log2_mocked);
        assertEquals(expected, functionSystem6.calculate(value, 100), 1e-5, "Function System 6 is incorrect");
        FunctionSystem functionSystem7 = new FunctionSystem(csc_mocked, tan_mocked, cos_mocked, cot_mocked, ln_mocked, log5_mocked, log10, log2_mocked);
        assertEquals(expected, functionSystem7.calculate(value, 100), 1e-5, "Function System 7 is incorrect");
        FunctionSystem functionSystem8 = new FunctionSystem(csc_mocked, tan_mocked, cos_mocked, cot_mocked, ln_mocked, log5_mocked, log10_mocked, log2);
        assertEquals(expected, functionSystem8.calculate(value, 100), 1e-5, "Function System 8 is incorrect");

    }

    @Test
    @DisplayName("Integration Test: Basic Trigonometric Functions")
    public void testBasicTrigonometricFunctions() {
        Sin sin = new Sin();
        Cos cos = new Cos(sin);
        Tan tan = new Tan(sin, cos);
        Cot cot = new Cot(sin, cos);
        Csc csc = new Csc(sin);

        double angle = Math.PI / 4; // 45 degrees
        assertEquals(Math.sqrt(2) / 2, sin.calculate(angle, 10), 1e-5, "Sin value is incorrect");
        assertEquals(Math.sqrt(2) / 2, cos.calculate(angle, 10), 1e-5, "Cos value is incorrect");
        assertEquals(1.0, tan.calculate(angle, 10), 1e-5, "Tan value is incorrect");
        assertEquals(1.0, cot.calculate(angle, 10), 1e-5, "Cot value is incorrect");
        assertEquals(Math.sqrt(2), csc.calculate(angle, 10), 1e-5, "Csc value is incorrect");
    }

    @Test
    @DisplayName("Integration Test: Basic Logarithmic Functions")
    public void testBasicLogarithmicFunctions() {
        Ln ln = new Ln();
        LogBase log2 = new LogBase(ln, 2);
        LogBase log5 = new LogBase(ln, 5);
        LogBase log10 = new LogBase(ln, 10);

        double value = 8.0;
        assertEquals(Math.log(8), ln.calculate(value, 100), 1e-5, "Ln value is incorrect");
        assertEquals(Math.log(8) / Math.log(2), log2.calculate(value, 100), 1e-5, "Log base 2 value is incorrect");
        assertEquals(Math.log(8) / Math.log(5), log5.calculate(value, 100), 1e-5, "Log base 5 value is incorrect");
        assertEquals(Math.log(8) / Math.log(10), log10.calculate(value, 100), 1e-5, "Log base 10 value is incorrect");
    }
    @Test
    @DisplayName("Integration Test: Trigonometric Part of Function System")
    public void testTrigonometricPart() {
        Sin sin = new Sin();
        Cos cos = new Cos(sin);
        Tan tan = new Tan(sin, cos);
        Cot cot = new Cot(sin, cos);
        Csc csc = new Csc(sin);

        FunctionSystem functionSystem = new FunctionSystem(csc, tan, cos, cot, null, null, null, null);

        double angle = Math.PI / 4; // 45 degrees
        double result = functionSystem.calculate(-angle, 10);

        assertEquals(-(Math.sqrt(2) * 1.0) * (Math.sqrt(2) / 2 * 1.0), result, 1e-5, "Trigonometric part is incorrect");
    }

    @Test
    @DisplayName("Integration Test: Logarithmic Part of Function System")
    public void testLogarithmicPart() {
        Ln ln = new Ln();
        LogBase log2 = new LogBase(ln, 2);
        LogBase log5 = new LogBase(ln, 5);
        LogBase log10 = new LogBase(ln, 10);

        FunctionSystem functionSystem = new FunctionSystem(null, null, null, null, ln, log5, log10, log2);

        double value = 8.0;
        double result = functionSystem.calculate(value, 10);

        double log2_res = Math.log(8) / Math.log(2);
        double log5_res = Math.log(8) / Math.log(5);
        double log10_res = Math.log(8) / Math.log(10);
        double denominator1 = log5_res;
        double denominator2 = ((log2_res + log10_res) + log2_res);

        double expected = Math.pow((log2_res * log5_res) / denominator1 * (log2_res - 0), 3) * (log5_res / denominator2);
        assertEquals(expected, result, 1, "Logarithmic part is incorrect");
    }

    @Test
    @DisplayName("Integration Test: CSV Exporter with Function System")
    public void testCSVExporterWithFunctionSystem() {
        Sin sin = new Sin();
        Cos cos = new Cos(sin);
        Tan tan = new Tan(sin, cos);
        Cot cot = new Cot(sin, cos);
        Csc csc = new Csc(sin);
        Ln ln = new Ln();
        LogBase log2 = new LogBase(ln, 2);
        LogBase log5 = new LogBase(ln, 5);
        LogBase log10 = new LogBase(ln, 10);

        FunctionSystem functionSystem = new FunctionSystem(csc, tan, cos, cot, ln, log5, log10, log2);

        double[] testValues = { -Math.PI,  1, Math.PI / 20 };
        CSVExporter.export(testValues[0], testValues[1], testValues[2], 10, "output.csv", functionSystem);

        assertTrue(new java.io.File("output.csv").exists(), "CSV file was not created");
    }

}

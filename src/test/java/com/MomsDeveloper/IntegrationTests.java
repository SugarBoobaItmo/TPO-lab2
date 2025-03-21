package com.MomsDeveloper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.MomsDeveloper.trigonometric.*;
import com.MomsDeveloper.logarithmic.*;

public class IntegrationTests {

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

        double[] testValues = { -4 * Math.PI, 4 * Math.PI, Math.PI / 4 };
        CSVExporter.export(testValues[0], testValues[1], testValues[2], 10, "output.csv", functionSystem);

        assertTrue(new java.io.File("output.csv").exists(), "CSV file was not created");
    }

}

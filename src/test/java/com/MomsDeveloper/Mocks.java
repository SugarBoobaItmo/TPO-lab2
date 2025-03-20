package com.MomsDeveloper;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;
import org.mockito.Mock;

import com.MomsDeveloper.logarithmic.*;
import com.MomsDeveloper.trigonometric.*;

public class Mocks {
    @Mock
    private static Sin sin;

    @Mock
    private static Cos cos;

    @Mock
    private static Tan tan;

    @Mock
    private static Cot cot;

    @Mock
    private static Csc csc;

    @Mock
    private static Ln ln;

    @Mock
    private static LogBase log2;

    @Mock
    private static LogBase log5;

    @Mock
    private static LogBase log10;

    @Mock
    private static FunctionSystem functionSystem;

    static {
        sin = mock(Sin.class);
        cos = mock(Cos.class);
        tan = mock(Tan.class);
        cot = mock(Cot.class);
        csc = mock(Csc.class);
        ln = mock(Ln.class);
        log2 = mock(LogBase.class);
        log5 = mock(LogBase.class);
        log10 = mock(LogBase.class);
        functionSystem = mock(FunctionSystem.class);

        when(sin.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            if (!sin.checkParams((double) args[0], (int) args[1])) return Double.NaN;
            return mockSinValue((double) args[0]);
        });

        when(cos.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            if (!cos.checkParams((double) args[0], (int) args[1])) return Double.NaN;
            return mockCosValue((double) args[0]);
        });

        when(tan.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            if (!tan.checkParams((double) args[0], (int) args[1])) return Double.NaN;
            return mockTanValue((double) args[0]);
        });

        when(cot.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            if (!cot.checkParams((double) args[0], (int) args[1])) return Double.NaN;
            return mockCotValue((double) args[0]);
        });

        when(csc.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            if (!csc.checkParams((double) args[0], (int) args[1])) return Double.NaN;
            return mockCscValue((double) args[0]);
        });

        when(ln.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            if (!ln.checkParams((double) args[0], (int) args[1])) return Double.NaN;
            return mockLnValue((double) args[0]);
        });

        when(log2.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            if (!log2.checkParams((double) args[0], (int) args[1])) return Double.NaN;
            return mockLog2Value((double) args[0]);
        });

        when(log5.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            if (!log5.checkParams((double) args[0], (int) args[1])) return Double.NaN;
            return mockLog5Value((double) args[0]);
        });

        when(log10.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            if (!log10.checkParams((double) args[0], (int) args[1])) return Double.NaN;
            return mockLog10Value((double) args[0]);
        });

        when(functionSystem.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            if (!functionSystem.checkParams((double) args[0], (int)
                    args[1])) return Double.NaN;
            return mockFunctionSystemValue((double) args[0]);
        });
    }

    private static double mockSinValue(double x) {
        if (x == 0) return 0.0;
        if (x == Math.PI / 4) return Math.sqrt(2) / 2;
        if (x == Math.PI / 2) return 1.0;
        if (x == Math.PI) return 0.0;
        if (x == -Math.PI) return 0.0;
        if (x == -Math.PI / 2) return -1.0;
        if (x == -Math.PI / 4) return -Math.sqrt(2) / 2;
        return Math.sin(x);
    }

    private static double mockCosValue(double x) {
        if (x == 0) return 1.0;
        if (x == Math.PI / 4) return Math.sqrt(2) / 2;
        if (x == Math.PI / 2) return 0.0;
        if (x == Math.PI) return -1.0;
        if (x == -Math.PI) return -1.0;
        if (x == -Math.PI / 2) return 0.0;
        if (x == -Math.PI / 4) return Math.sqrt(2) / 2;
        return Math.cos(x);
    }

    private static double mockTanValue(double x) {
        if (x == 0) return 0.0;
        if (x == Math.PI / 4) return 1.0;
        if (x == Math.PI / 2) return Double.NaN;
        if (x == Math.PI) return 0.0;
        if (x == -Math.PI) return 0.0;
        if (x == -Math.PI / 2) return Double.NaN;
        if (x == -Math.PI / 4) return -1.0;
        return Math.tan(x);
    }
    
    private static double mockCotValue(double x) {
        if (x == 0) return Double.NaN;
        if (x == Math.PI / 4) return 1.0;
        if (x == Math.PI / 2) return 0.0;
        if (x == Math.PI) return Double.NaN;
        if (x == -Math.PI) return Double.NaN;
        if (x == -Math.PI / 2) return 0.0;
        if (x == -Math.PI / 4) return -1.0;
        return Math.cos(x) / Math.sin(x);
    }

    private static double mockCscValue(double x) {
        if (x == 0) return Double.NaN;
        if (x == Math.PI / 4) return Math.sqrt(2);
        if (x == Math.PI / 2) return Double.NaN;
        if (x == Math.PI) return Double.NaN;
        if (x == -Math.PI) return Double.NaN;
        if (x == -Math.PI / 2) return Double.NaN;
        if (x == -Math.PI / 4) return -Math.sqrt(2);
        return 1 / Math.sin(x);
    }

    private static double mockLnValue(double x) {
        if (x < 0) return Double.NaN;
        if (x == 0) return Double.NaN;
        if (x == 0.5) return -0.6931471805599453;
        if (x == 1) return 0.0;
        if (x == Math.E) return 1.0;
        if (x == Math.E * Math.E) return 2.0;
        if (x == Math.E * Math.E * Math.E) return 3.0;
        return Math.log(x);
    }

    private static double mockLog2Value(double x) {
        if (x < 0) return Double.NaN;
        if (x == 0) return Double.NaN;
        if (x == 0.5) return -1.0;
        if (x == 1) return 0.0;
        if (x == 2) return 1.0;
        if (x == 4) return 2.0;
        if (x == 8) return 3.0;
        return Math.log(x) / Math.log(2);
    }

    private static double mockLog5Value(double x) {
        if (x < 0) return Double.NaN;
        if (x == 0) return Double.NaN;
        if (x == 0.5) return -0.43067655807339306;
        if (x == 1) return 0.0;
        if (x == 5) return 1.0;
        if (x == 25) return 2.0;
        if (x == 125) return 3.0;
        return Math.log(x) / Math.log(5);
    }

    private static double mockLog10Value(double x) {
        if (x < 0) return Double.NaN;
        if (x == 0) return Double.NaN;
        if (x == 0.5) return -0.3010299956639812;
        if (x == 1) return 0.0;
        if (x == 10) return 1.0;
        if (x == 100) return 2.0;
        if (x == 1000) return 3.0;
        return Math.log(x) / Math.log(10);
    }

    private static double mockTrigFunction(double x){
        double sinValue = mockSinValue(x);
        double cosValue = mockCosValue(x);
        double tanValue = mockTanValue(x);
        double cotValue = mockCotValue(x);
        double cscValue = mockCscValue(x);

        return (sinValue + cosValue + tanValue + cotValue + cscValue);
    }

    private static double mockLogFunction(double x){
        double log5Value = mockLog5Value(x);
        double log10Value = mockLog10Value(x);
        double log2Value = mockLog2Value(x);
        double lnValue = mockLnValue(x);

        double denominator1 = log5Value;
            double denominator2 = ((log2Value + log10Value) + log2Value);

            if (denominator1 == 0 || denominator2 == 0)
                return Double.NaN;

            return (Math.pow((log2Value * log5Value) / denominator1 * (log2Value - (lnValue - lnValue)), 3)
                    * (log5Value / denominator2));
    }

    private static double mockFunctionSystemValue(double x) {
        if (x <= 0) {
            return mockTrigFunction(x);
        } else {
            return mockLogFunction(x);
        }
    }
}

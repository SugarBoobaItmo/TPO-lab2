package com.MomsDeveloper;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.MomsDeveloper.logarithmic.*;
import com.MomsDeveloper.trigonometric.*;

import lombok.Data;

@Data
public class Mocks {
    @Mock
    private Sin sin;

    @Mock
    private Cos cos;

    @Mock
    private Tan tan;

    @Mock
    private Cot cot;

    @Mock
    private Csc csc;

    @Mock
    private Ln ln;

    @Mock
    private LogBase log2;

    @Mock
    private LogBase log5;

    @Mock
    private LogBase log10;

    @Mock
    private FunctionSystem functionSystem;

    public Mocks() {
        MockitoAnnotations.openMocks(this);
        setupMocks();
    }

    private void setupMocks() {
        when(sin.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockSinValue((double) args[0]);
        });

        when(cos.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockCosValue((double) args[0]);
        });

        when(tan.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockTanValue((double) args[0]);
        });

        when(cot.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockCotValue((double) args[0]);
        });

        when(csc.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockCscValue((double) args[0]);
        });

        when(ln.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockLnValue((double) args[0]);
        });

        when(log2.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockLog2Value((double) args[0]);
        });

        when(log5.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockLog5Value((double) args[0]);
        });

        when(log10.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockLog10Value((double) args[0]);
        });

        when(functionSystem.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockFunctionSystemValue((double) args[0]);
        });
    }

    private static double mockSinValue(double x) {
        if (x == 0)
            return 0.0;
        if (x == Math.PI / 4)
            return Math.sqrt(2) / 2;
        if (x == Math.PI / 2)
            return 1.0;
        if (x == Math.PI)
            return 0.0;
        if (x == 3 * Math.PI / 2)
            return -1.0;
        if (x == 3 * Math.PI / 4)
            return Math.sqrt(2) / 2;
        if (x == 2 * Math.PI)
            return 0.0;
        if (x == -2 * Math.PI)
            return 0.0;
        if (x == -3 * Math.PI / 4)
            return -Math.sqrt(2) / 2;
        if (x == -Math.PI / 2)
            return -1.0;
        if (x == -Math.PI)
            return 0.0;
        if (x == -Math.PI / 2)
            return -1.0;
        if (x == -Math.PI / 4)
            return -Math.sqrt(2) / 2;
        return Math.sin(x);
    }

    private static double mockCosValue(double x) {
        if (x == 0.0)
            return 1.0;
        if (x == Math.PI / 4)
            return Math.sqrt(2) / 2;
        if (x == Math.PI / 2)
            return 0.0;
        if (x == Math.PI)
            return -1.0;
        if (x == 3 * Math.PI / 2)
            return 0.0;
        if (x == 3 * Math.PI / 4)
            return -Math.sqrt(2) / 2;
        if (x == 2 * Math.PI)
            return 1.0;
        if (x == -2 * Math.PI)
            return 1.0;
        if (x == -3 * Math.PI / 4)
            return -Math.sqrt(2) / 2;
        if (x == -3 * Math.PI / 2)
            return 0.0;
        if (x == -Math.PI)
            return -1.0;
        if (x == -Math.PI / 2)
            return 0.0;
        if (x == -Math.PI / 4)
            return Math.sqrt(2) / 2;
        return Math.cos(x);
    }

    private static double mockTanValue(double x) {
        if (x == 0)
            return 0.0;
        if (x == Math.PI / 4)
            return 1.0;
        if (x == Math.PI / 2)
            return Double.NaN;
        if (x == Math.PI)
            return 0.0;
        if (x == -Math.PI)
            return 0.0;
        if (x == -Math.PI / 2)
            return Double.NaN;
        if (x == -Math.PI / 4)
            return -1.0;
        return Math.tan(x);
    }

    private static double mockCotValue(double x) {
        if (x == 0)
            return Double.NaN;
        if (x == Math.PI / 4)
            return 1.0;
        if (x == Math.PI / 2)
            return 0.0;
        if (x == Math.PI)
            return Double.NaN;
        if (x == -Math.PI)
            return Double.NaN;
        if (x == -Math.PI / 2)
            return 0.0;
        if (x == -Math.PI / 4)
            return -1.0;
        return 1 / Math.tan(x);
    }

    private static double mockCscValue(double x) {
        if (x == 0)
            return Double.NaN;
        if (x == Math.PI / 4)
            return Math.sqrt(2);
        if (x == Math.PI / 2)
            return Double.NaN;
        if (x == Math.PI)
            return Double.NaN;
        if (x == -Math.PI)
            return Double.NaN;
        if (x == -Math.PI / 2)
            return Double.NaN;
        if (x == -Math.PI / 4)
            return -Math.sqrt(2);
        return 1 / Math.sin(x);
    }

    private static double mockLnValue(double x) {
        if (x < 0)
            return Double.NaN;
        if (x == 0)
            return Double.NaN;
        if (x == 0.5)
            return -0.6931471805599453;
        if (x == 1)
            return 0.0;
        if (x == Math.E)
            return 1.0;
        if (x == Math.E * Math.E)
            return 2.0;
        if (x == Math.E * Math.E * Math.E)
            return 3.0;
        if (x == 10)
            return 2.302585092994046;
        if (x == 2) 
            return 0.6931471805599453;
        if (x == 5)
            return 1.6094379124341003;
        return Math.log(x);
    }

    private static double mockLog2Value(double x) {
        if (x < 0)
            return Double.NaN;
        if (x == 0)
            return Double.NaN;
        if (x == 0.5)
            return -1.0;
        if (x == 1)
            return 0.0;
        if (x == 2)
            return 1.0;
        if (x == 4)
            return 2.0;
        if (x == 8)
            return 3.0;
        return Math.log(x) / Math.log(2);
    }

    private static double mockLog5Value(double x) {
        if (x < 0)
            return Double.NaN;
        if (x == 0)
            return Double.NaN;
        if (x == 0.5)
            return -0.43067655807339306;
        if (x == 1)
            return 0.0;
        if (x == 5)
            return 1.0;
        if (x == 25)
            return 2.0;
        if (x == 125)
            return 3.0;
        return Math.log(x) / Math.log(5);
    }

    private static double mockLog10Value(double x) {
        if (x < 0)
            return Double.NaN;
        if (x == 0)
            return Double.NaN;
        if (x == 0.5)
            return -0.3010299956639812;
        if (x == 1)
            return 0.0;
        if (x == 10)
            return 1.0;
        if (x == 100)
            return 2.0;
        if (x == 1000)
            return 3.0;
        return Math.log10(x);
    }

    private static double mockFunctionSystemValue(double x) {
        if (x == 0)
            return Double.NaN;
        if (x <= 0)
            return Double.NaN;
        return Double.NaN;        
    }
}

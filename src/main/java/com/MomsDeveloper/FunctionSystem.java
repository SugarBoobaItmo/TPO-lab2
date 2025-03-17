package com.MomsDeveloper;

import com.MomsDeveloper.logarithmic.Ln;
import com.MomsDeveloper.trigonometric.Cos;
import com.MomsDeveloper.trigonometric.Cot;
import com.MomsDeveloper.trigonometric.Csc;
import com.MomsDeveloper.trigonometric.Tan;
import com.MomsDeveloper.logarithmic.LogBase;

public class FunctionSystem extends BaseFunction {
    private Csc csc;
    private Tan tan;
    private Cos cos;
    private Cot cot;
    private Ln ln;
    private LogBase log5;
    private LogBase log10;
    private LogBase log2;

    public FunctionSystem(Csc csc, Tan tan, Cos cos, Cot cot, Ln ln, LogBase log5, LogBase log10, LogBase log2) {
        this.csc = csc;
        this.tan = tan;
        this.cos = cos;
        this.cot = cot;
        this.ln = ln;
        this.log5 = log5;
        this.log10 = log10;
        this.log2 = log2;
    }

    public double calculate(double x, double terms) {
        if (!checkParams(x, terms))
            return Double.NaN;
        if (x <= 0) {
            double csc_res = csc.calculate(x, terms);
            double tan_res = tan.calculate(x, terms);
            double cos_res = cos.calculate(x, terms);
            double cot_res = cot.calculate(x, terms);

            return (csc_res * tan_res) * (cos_res * cot_res);
        } else {
            double log5_res = log5.calculate(x, terms);
            double log10_res = log10.calculate(x, terms);
            double log2_res = log2.calculate(x, terms);
            double ln_res = ln.calculate(x, terms);

            double denominator1 = log5_res;
            double denominator2 = ((log2_res + log10_res) + log2_res);

            if (denominator1 == 0 || denominator2 == 0)
                return Double.NaN;

            return (Math.pow((log2_res * log5_res) / denominator1 * (log2_res - (ln_res - ln_res)), 3)
                    * (log5_res / denominator2));
        }
    }
}

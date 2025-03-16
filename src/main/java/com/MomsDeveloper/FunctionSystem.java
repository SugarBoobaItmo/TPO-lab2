package com.MomsDeveloper;

import com.MomsDeveloper.logarithmic.Ln;
import com.MomsDeveloper.trigonometric.Cos;
import com.MomsDeveloper.trigonometric.Cot;
import com.MomsDeveloper.trigonometric.Csc;
import com.MomsDeveloper.trigonometric.Tan;
import com.MomsDeveloper.logarithmic.LogBase;

public class FunctionSystem implements SeriesFunction{
    private Csc csc;
    private Tan tan;
    private Cos cos;
    private Cot cot;
    private Ln ln;
    private LogBase log5;
    private LogBase log10; 
    private LogBase log2;

    public FunctionSystem(){
        this.csc = new Csc();
        this.tan = new Tan();
        this.cos = new Cos();
        this.cot = new Cot();
        this.ln = new Ln();
        this.log5 = new LogBase(5);
        this.log10 = new LogBase(10);
        this.log2 = new LogBase(2);
    }

    public double calculate(double x, double terms) {
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

            return (Math.pow((log2_res * log5_res) / log5_res * (log2_res - (ln_res - ln_res)), 3) * (log5_res / ((log2_res + log10_res) + log2_res)));
        }
    }
}

package com.MomsDeveloper.logarithmic;

import com.MomsDeveloper.SeriesFunction;

public class LogBase implements SeriesFunction{
    private Ln ln;
    private int base;

    public LogBase(int base) {
        this.ln = new Ln();
        this.base = base;
      }

    public double calculate(double x, double terms) {
        double lnx_res = ln.calculate(x, terms);
        double lnb_res = ln.calculate(base, terms);
        if (lnb_res == 0) { 
            return Double.NaN;
        }
        if (Double.isNaN(lnx_res) || Double.isNaN(lnb_res)) {
            return Double.NaN;
        }
        return lnx_res / lnb_res;
    }
}

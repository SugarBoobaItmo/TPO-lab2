package com.MomsDeveloper.logarithmic;

import com.MomsDeveloper.BaseFunction;

public class LogBase extends BaseFunction{
    private Ln ln;
    private int base;

    public LogBase(Ln ln, int base) {
        this.ln = ln;
        this.base = base;
      }

    public double calculate(double x, double terms) {
        if (!checkParams(x, terms)) return Double.NaN;
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

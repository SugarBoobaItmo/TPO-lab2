package com.MomsDeveloper.trigonometric;

import com.MomsDeveloper.BaseFunction;

public class Cot extends BaseFunction {
    private Sin sin;
    private Cos cos;
    public Cot(Sin sin, Cos cos){
        this.sin = sin;
        this.cos = cos;
    }
    public double calculate(double x, double terms) {
        if (!checkParams(x, terms)) return Double.NaN;
        double sin_res = sin.calculate(x, terms);
        double cos_res = cos.calculate(x, terms);
        if (Math.abs(sin_res) < 1e-3)
            return Double.NaN;
        return cos_res / sin_res;
    }
}

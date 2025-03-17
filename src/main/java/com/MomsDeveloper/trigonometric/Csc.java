package com.MomsDeveloper.trigonometric;

import com.MomsDeveloper.BaseFunction;

public class Csc extends BaseFunction{
    private Sin sin;
    public Csc(){
        this.sin = new Sin();
    }

    public double calculate(double x, double terms) {
        if (!checkParams(x, terms)) return Double.NaN;
        double res = sin.calculate(x, terms);
        if (Math.abs(res) < 1e-3)
            return Double.NaN;
        return 1 / res;
    }
}

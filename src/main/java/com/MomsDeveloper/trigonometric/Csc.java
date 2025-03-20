package com.MomsDeveloper.trigonometric;

import com.MomsDeveloper.BaseFunction;

public class Csc extends BaseFunction{
    private Sin sin;
    public Csc(Sin sin){
        this.sin = sin;
    }

    public double calculate(double x, int terms) {
        if (!checkParams(x, terms)) return Double.NaN;  
        double res = sin.calculate(x, terms);
        if (Math.abs(res) < 1e-3)
            return Double.NaN;
        return 1 / res;
    }
}

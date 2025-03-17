package com.MomsDeveloper.trigonometric;

import com.MomsDeveloper.BaseFunction;

public class Cos extends BaseFunction{
    private Sin sin;
    public Cos(Sin sin){
        this.sin = sin;
    }
    public double calculate(double x, double terms){
        if (!checkParams(x, terms)) return Double.NaN;
        double result = sin.calculate(x + Math.PI / 2, terms);
        return result;
    }
}

package com.MomsDeveloper.trigonometric;

import com.MomsDeveloper.BaseFunction;

public class Cos extends BaseFunction{
    private Sin sin;
    public Cos(Sin sin){
        this.sin = sin;
    }
    public double calculate(double x, int terms){
        if (!checkParams(x, terms)) return Double.NaN;   
        x = normalize(x + Math.PI / 2);
        double result = sin.calculate(x, terms);
        return result;
    }

    private double normalize(double x){
        return ((x % (2 * Math.PI)) + 2 * Math.PI) % (2 * Math.PI);
    }
}

package com.MomsDeveloper.trigonometric;

import com.MomsDeveloper.BaseFunction;

public class Sin extends BaseFunction{
    public double calculate(double x, int terms){
        if (!checkParams(x, terms)) return Double.NaN;
        x = normalize(x);
        double term = x, res = x;
        int n = 1;
        for (int i = 0; i < terms; i++) {
            term *= -x * x / ((2 * n) * (2 * n + 1));
            res += term;
            n++;
        }
        return res;
    }

    private double normalize(double x){
        return ((x % (2 * Math.PI)) + 2 * Math.PI) % (2 * Math.PI);
    }
}


package com.MomsDeveloper.trigonometric;

import com.MomsDeveloper.SeriesFunction;

public class Sin implements SeriesFunction{
    public double calculate(double x, double terms){
        x = x % (2 * Math.PI); 
        double term = x, sum = x;
        int n = 1;
        for (int i = 0; i < terms; i++) {
            term *= -x * x / ((2 * n) * (2 * n + 1));
            sum += term;
            n++;
        }
        return sum;
    }
}


package com.MomsDeveloper.trigonometric;

import com.MomsDeveloper.SeriesFunction;

public class Csc implements SeriesFunction{
    private Sin sin;
    public Csc(){
        this.sin = new Sin();
    }

    public double calculate(double x, double terms) {
        double result = sin.calculate(x, terms);
        return 1 / result;
    }
}

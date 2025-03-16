package com.MomsDeveloper.trigonometric;

import com.MomsDeveloper.SeriesFunction;

public class Cos implements SeriesFunction{
    private Sin sin;
    public Cos(){
        this.sin = new Sin();
    }
    public double calculate(double x, double terms){
        double result = sin.calculate(x + Math.PI / 2, terms);
        return result;
    }
}

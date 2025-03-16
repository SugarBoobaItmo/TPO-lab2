package com.MomsDeveloper.trigonometric;

import com.MomsDeveloper.SeriesFunction;

public class Tan implements SeriesFunction{
    private Sin sin;
    private Cos cos;
    public Tan(){
        this.sin = new Sin();
        this.cos = new Cos();
    }
    public double calculate(double x, double terms) {
        double sin_result = sin.calculate(x, terms);
        double cos_result = cos.calculate(x, terms);
        return sin_result / cos_result;
    }
}

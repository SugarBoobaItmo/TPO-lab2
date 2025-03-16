package com.MomsDeveloper.trigonometric;

import com.MomsDeveloper.SeriesFunction;

public class Cot implements SeriesFunction{
    private Sin sin;
    private Cos cos;
    public Cot(){
        this.sin = new Sin();
        this.cos = new Cos();
    }
    public double calculate(double x, double terms) {
        double sin_res = sin.calculate(x, terms);
        double cos_res = cos.calculate(x, terms);
        return cos_res / sin_res;
    }
}

package com.MomsDeveloper.logarithmic;

import com.MomsDeveloper.SeriesFunction;

public class LogBase implements SeriesFunction{
    private Ln ln;
    private int base;

    public LogBase(int base) {
        this.ln = new Ln();
        this.base = base;
      }

    public double calculate(double x, double terms) {
        return ln.calculate(x, terms) / ln.calculate(base, terms);
    }
}

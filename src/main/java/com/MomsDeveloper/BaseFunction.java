package com.MomsDeveloper;

public abstract class BaseFunction implements SeriesFunction {
    public boolean checkParams(double x, double terms) {
        if (Double.isNaN(x) || Double.isNaN(terms) || Double.isInfinite(x) || Double.isInfinite(terms) || terms < 0
                || terms > 1e6) {
            return false;
        }
        return true;
    }
}

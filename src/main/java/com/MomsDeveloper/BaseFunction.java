package com.MomsDeveloper;

public abstract class BaseFunction implements SeriesFunction {
    public boolean checkParams(double x, int terms) {
        if (Double.isNaN(x) || Double.isInfinite(x) || terms < 0 || terms > 1e6) {
            return false;
        }
        return true;
    }
}

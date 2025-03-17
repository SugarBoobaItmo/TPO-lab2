package com.MomsDeveloper.logarithmic;

import com.MomsDeveloper.BaseFunction;

public class Ln extends BaseFunction {
    public double calculate(double x, double terms) {
        if (!checkParams(x, terms)) return Double.NaN;
        if (x <= 0) {
            return Double.NaN;
        }

        double y = (x - 1) / (x + 1);
        double term = y, sum = 2 * y;
        int n = 1;

        for (int i = 0; i < terms; i++) {
            term *= (y * y) * (2 * n - 1) / (2 * n + 1);
            sum += 2 * term;
            n++;
        }

        return sum;
    }

}

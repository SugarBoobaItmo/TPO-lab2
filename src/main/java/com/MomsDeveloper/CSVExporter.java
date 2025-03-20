package com.MomsDeveloper;

import java.io.FileWriter;
import java.io.IOException;

public class CSVExporter {
    public static void exportToCSV(double start, double end, double step, int terms, String filename, SeriesFunction func) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.append("X, Result\n");
            for (double x = start; x <= end; x += step) {
                double result = func.calculate(x, terms);
                writer.append(x + "," + result + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
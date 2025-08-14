package liangChapter9;

import java.util.Scanner;

public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class LinearEquation2 {
    private double a;
    private double b;
    private double e;

    public LinearEquation2(double a, double b, double e) {
        this.a = a;
        this.b = b;
        this.e = e;
    }

    public boolean isSolvable() {
        return true;
    }

    public double getX() {
        LinearEquation2 equation = new LinearEquation2(-a, -b, -e);
        LinearEquation2 equation2 = new LinearEquation2(1, 0, 0);
        double denominator = a * equation2.b - equation2.a * b;
        double x = (e * equation2.b - equation2.e * b) / denominator;
        double y = (a * equation2.e - e * equation2.a) / denominator;
        return x;
    }

    public double getY() {
        LinearEquation2 equation = new LinearEquation2(-a, -b, -e);
        LinearEquation2 equation2 = new LinearEquation2(0, 1, 0);
        double denominator = a * equation2.b - equation2.a * b;
        double x = (e * equation2.b - equation2.e * b) / denominator;
        double y = (a * equation2.e - e * equation2.a) / denominator;
        return y;
    }
}

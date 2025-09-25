package liangCollections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Point implements Comparable<Point>{
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public int compareTo(Point other) {
        if (x != other.x) {
            return Double.compare(x, other.x);
        } else {
            return Double.compare(y, other.y);
        }
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class CompareY implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
        if (p1.getY() != p2.getY()) {
            return Double.compare(p1.getY(), p2.getY());
        } else {
            return Double.compare(p1.getX(), p2.getX());
        }
    }
}


package liangBigONotation;

import java.util.Arrays;
import java.util.Comparator;

import static liangBigONotation.ClosestPair.distance;

public class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class CompareY implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
        if (p1.y < p2.y) {
            return -1;
        } else if (p1.y > p2.y) {
            return 1;
        } else {
            return 0;
        }
    }
}

class Pair {
    Point p1, p2;

    public Pair(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double getDistance() {
        return distance(p1, p2);
    }
}


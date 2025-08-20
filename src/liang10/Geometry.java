package liang10;

import java.util.Scanner;

public class Geometry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter five points: ");
        double[][] points = new double[5][2];
        for (int i = 0; i < points.length; i++) {
            points[i][0] = scanner.nextDouble();
            points[i][1] = scanner.nextDouble();
        }
        MyRectangle2D rectangle = getRectangle(points);
        System.out.println("The bounding rectangle's center (" + rectangle.getX() + ", " + rectangle.getY() + "), width " + rectangle.getWidth() + ", height " + rectangle.getHeight());
    }

    public static MyRectangle2D getRectangle(double[][] points) {
        double minX = points[0][0];
        double minY = points[0][1];
        double maxX = points[0][0];
        double maxY = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] < minX) {
                minX = points[i][0];
            }
            if (points[i][1] < minY) {
                minY = points[i][1];
            }
            if (points[i][0] > maxX) {
                maxX = points[i][0];
            }
            if (points[i][1] > maxY) {
                maxY = points[i][1];
            }
        }
        double x = (minX + maxX) / 2;
        double y = (minY + maxY) / 2;
        double width = maxX - minX;
        double height = maxY - minY;
        return new MyRectangle2D(x, y, width, height);
    }
}

class MyRectangle22D {
    private double x;
    private double y;
    private double width;
    private double height;

    public MyRectangle22D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}

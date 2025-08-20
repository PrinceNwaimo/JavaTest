package liang10;

public class MyPoint2 {
    private double x;
    private double y;

    public MyPoint2() {
        this(0, 0);
    }

    public MyPoint2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    public double distance(MyPoint p) {
        return Math.sqrt(Math.pow(x - p.getX(), 2) + Math.pow(y - p.getY(), 2));
    }
}


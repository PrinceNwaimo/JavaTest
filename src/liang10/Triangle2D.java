package liang10;

public class Triangle2D {
    private MyPoint p1;
    private MyPoint p2;
    private MyPoint p3;

    public Triangle2D() {
        this(new MyPoint(0, 0), new MyPoint(1, 1), new MyPoint(2, 5));
    }

    public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public MyPoint getP1() { return p1; }
    public MyPoint getP2() { return p2; }
    public MyPoint getP3() { return p3; }
    public void setP1(MyPoint p) { this.p1 = p; }
    public void setP2(MyPoint p) { this.p2 = p; }
    public void setP3(MyPoint p) { this.p3 = p; }

    public double getArea() {
        return Math.abs((p1.getX() * (p2.getY() - p3.getY()) +
                p2.getX() * (p3.getY() - p1.getY()) +
                p3.getX() * (p1.getY() - p2.getY())) / 2.0);
    }

    public double getPerimeter() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    public boolean contains(MyPoint p) {
        double A = getArea();
        Triangle2D t1 = new Triangle2D(p, p2, p3);
        Triangle2D t2 = new Triangle2D(p1, p, p3);
        Triangle2D t3 = new Triangle2D(p1, p2, p);
        double A1 = t1.getArea();
        double A2 = t2.getArea();
        double A3 = t3.getArea();
        return Math.abs(A - (A1 + A2 + A3)) < 1e-9;
    }

    public boolean contains(Triangle2D t) {
        return contains(t.getP1()) && contains(t.getP2()) && contains(t.getP3());
    }

    public boolean overlaps(Triangle2D t) {
        if (contains(t) || t.contains(this)) return true;
        if (contains(t.getP1()) || contains(t.getP2()) || contains(t.getP3())) return true;
        if (t.contains(p1) || t.contains(p2) || t.contains(p3)) return true;

        return false;
    }
}

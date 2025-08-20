package liang10;

public class Circle2D {
    private double x;
    private double y;
    private double radius;

    public Circle2D() {
        this(0, 0, 1);
    }

    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public boolean contains(double x, double y) {
        return distance(this.x, this.y, x, y) <= radius;
    }

    public boolean contains(Circle2D circle) {
        return distance(this.x, this.y, circle.x, circle.y) + circle.radius <= radius;
    }

    public boolean overlaps(Circle2D circle) {
        return distance(this.x, this.y, circle.x, circle.y) <= radius + circle.radius;
    }

    private double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        Circle2D c1 = new Circle2D(2, 2, 5.5);
        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());
        System.out.println("Contains point (3, 3): " + c1.contains(3, 3));
        System.out.println("Contains circle (4, 5, 10.5): " + c1.contains(new Circle2D(4, 5, 10.5)));
        System.out.println("Overlaps circle (3, 5, 2.3): " + c1.overlaps(new Circle2D(3, 5, 2.3)));
    }
}

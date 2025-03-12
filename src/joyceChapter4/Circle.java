package joyceChapter4;

public class Circle {
    private double radius;
    private double diameter;
    private double area;


    public Circle() {
        this.radius = 1;
        calculateDiameterAndArea();
    }


    public void setRadius(double radius) {
        this.radius = radius;
        calculateDiameterAndArea();
    }


    public double getRadius() {
        return radius;
    }

    public double getDiameter() {
        return diameter;
    }


    public double getArea() {
        return area;
    }

    private void calculateDiameterAndArea() {
        this.diameter = 2 * this.radius;
        this.area = Math.PI * Math.pow(this.radius, 2);
    }
}

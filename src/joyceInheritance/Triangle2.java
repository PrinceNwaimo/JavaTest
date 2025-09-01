package joyceInheritance;

public class Triangle2 extends GeometricFigure2 implements SidedObject{
    public Triangle2(double height, double width) {
        super(height, width, "Triangle");
        calculateArea();
    }

    @Override
    public void calculateArea() {
        area = (height * width) / 2;
    }

    @Override
    public void displaySides() {
        System.out.println("Number of sides: 3");
    }
}

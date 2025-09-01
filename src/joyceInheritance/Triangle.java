package joyceInheritance;

public class Triangle extends GeometricFigure{
    public Triangle(double height, double width) {
        super(height, width, "Triangle");
        calculateArea();
    }

    @Override
    public void calculateArea() {
        area = (height * width) / 2;
    }
}

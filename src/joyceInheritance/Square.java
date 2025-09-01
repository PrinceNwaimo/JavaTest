package joyceInheritance;

public class Square extends GeometricFigure{
    public Square(double side) {
        super(side, side, "Square");
        calculateArea();
    }

    @Override
    public void calculateArea() {
        area = height * width;
    }
}

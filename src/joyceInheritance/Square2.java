package joyceInheritance;

public class Square2 extends GeometricFigure2 implements SidedObject{
    public Square2(double side) {
        super(side, side, "Square");
        calculateArea();
    }

    @Override
    public void calculateArea() {
        area = height * width;
    }

    @Override
    public void displaySides() {
        System.out.println("Number of sides: 4");
    }
}





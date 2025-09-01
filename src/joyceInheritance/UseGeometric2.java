package joyceInheritance;

public class UseGeometric2 {
    public static void main(String[] args) {
        GeometricFigure2[] figures = new GeometricFigure2[2];

        figures[0] = new Square2(5);
        figures[1] = new Triangle2(4, 6);

        for (GeometricFigure2 figure : figures) {
            figure.display();
            if (figure instanceof SidedObject) {
                ((SidedObject) figure).displaySides();
            }
            System.out.println();
        }
    }
}

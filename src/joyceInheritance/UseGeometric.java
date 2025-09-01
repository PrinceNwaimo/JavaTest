package joyceInheritance;

public class UseGeometric {
    public static void main(String[] args) {
        GeometricFigure[] figures = new GeometricFigure[2];

        figures[0] = new Square(5);
        figures[1] = new Triangle(4, 6);

        for (GeometricFigure figure : figures) {
            figure.display();
            System.out.println();
        }
    }
}

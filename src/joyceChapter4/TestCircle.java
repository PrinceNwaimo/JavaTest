package joyceChapter4;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle();
        Circle circle3 = new Circle();

        circle1.setRadius(5);
        circle2.setRadius(10);

        System.out.println("Circle 1:");
        System.out.println("Radius: " + circle1.getRadius());
        System.out.println("Diameter: " + circle1.getDiameter());
        System.out.println("Area: " + circle1.getArea());
        System.out.println();

        System.out.println("Circle 2:");
        System.out.println("Radius: " + circle2.getRadius());
        System.out.println("Diameter: " + circle2.getDiameter());
        System.out.println("Area: " + circle2.getArea());
        System.out.println();

        System.out.println("Circle 3:");
        System.out.println("Radius: " + circle3.getRadius());
        System.out.println("Diameter: " + circle3.getDiameter());
        System.out.println("Area: " + circle3.getArea());
    }
}

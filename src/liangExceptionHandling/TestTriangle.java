package liangExceptionHandling;

public class TestTriangle {
    public static void main(String[] args) {
        try {
            Triangle triangle = new Triangle(1, 2, 3);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }

        try {
            Triangle triangle = new Triangle(-1, 2, 3);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }

        try {
            Triangle triangle = new Triangle(3, 4, 5);
            System.out.println("Triangle created successfully.");
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}

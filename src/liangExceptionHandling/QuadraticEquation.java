package liangExceptionHandling;

import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        solveQuadratic(a, b, c);
    }

    public static void solveQuadratic(double a, double b, double c) {
        double determinant = b * b - 4 * a * c;

        if (determinant > 0) {
            double root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            double root2 = (-b - Math.sqrt(determinant)) / (2 * a);
            System.out.println("The roots are " + root1 + " and " + root2);
        } else if (determinant == 0) {
            double root = -b / (2 * a);
            System.out.println("The root is " + root);
        } else {
            Complex root1 = new Complex(-b / (2 * a), Math.sqrt(-determinant) / (2 * a));
            Complex root2 = new Complex(-b / (2 * a), -Math.sqrt(-determinant) / (2 * a));
            System.out.println("The roots are " + root1 + " and " + root2);
        }
    }
}

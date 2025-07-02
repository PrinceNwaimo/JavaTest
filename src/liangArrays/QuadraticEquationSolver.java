package liangArrays;

import java.util.Scanner;

public class QuadraticEquationSolver {
    public static int solveQuadratic(double[] eqn, double[] roots) {
        double a = eqn[0];
        double b = eqn[1];
        double c = eqn[2];

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            roots[0] = (-b + Math.sqrt(discriminant)) / (2 * a);
            roots[1] = (-b - Math.sqrt(discriminant)) / (2 * a);
            return 2;
        } else if (discriminant == 0) {
            roots[0] = -b / (2 * a);
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the coefficients a, b, and c for the quadratic equation ax^2 + bx + c = 0: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double[] eqn = {a, b, c};
        double[] roots = new double[2];

        int numRoots = solveQuadratic(eqn, roots);

        System.out.println("The equation " + a + "x^2 + " + b + "x + " + c + " = 0 has ");
        if (numRoots == 2) {
            System.out.println("two real roots: " + roots[0] + " and " + roots[1]);
        } else if (numRoots == 1) {
            System.out.println("one real root: " + roots[0]);
        } else {
            System.out.println("no real roots.");
        }
    }

}

package liangMultiArrays;

import java.util.Scanner;

public class LinearEquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] a = new double[2][2];
        double[] b = new double[2];

        System.out.println("Enter a00, a01, a10, a11:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Enter b0 and b1:");
        for (int i = 0; i < 2; i++) {
            b[i] = scanner.nextDouble();
        }

        double[] solution = linearEquation(a, b);
        if (solution == null) {
            System.out.println("The equation has no solution.");
        } else {
            System.out.println("x = " + solution[0]);
            System.out.println("y = " + solution[1]);
        }
    }

    public static double[] linearEquation(double[][] a, double[] b) {
        double denominator = a[0][0] * a[1][1] - a[0][1] * a[1][0];
        if (denominator == 0) {
            return null;
        }

        double[] solution = new double[2];
        solution[0] = (b[0] * a[1][1] - b[1] * a[0][1]) / denominator;
        solution[1] = (b[1] * a[0][0] - b[0] * a[1][0]) / denominator;
        return solution;
    }

}

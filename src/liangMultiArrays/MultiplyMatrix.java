package liangMultiArrays;

import java.util.Scanner;

public class MultiplyMatrix {
    public static double[][] multiplyMatrix(double[][] a, double[][] b) {
        if (a[0].length != b.length) {
            throw new RuntimeException("Matrices cannot be multiplied");
        }

        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.printf("%.1f ", element);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[][] matrix1 = new double[3][3];
        System.out.println("Enter matrix1:");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = scanner.nextDouble();
            }
        }

        double[][] matrix2 = new double[3][3];
        System.out.println("Enter matrix2:");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = scanner.nextDouble();
            }
        }

        double[][] product = multiplyMatrix(matrix1, matrix2);

        System.out.println("The matrices are multiplied as follows");
        printMatrix(matrix1);
        System.out.println("*");
        printMatrix(matrix2);
        System.out.println("=");
        printMatrix(product);
    }

}

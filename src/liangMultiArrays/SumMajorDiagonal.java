package liangMultiArrays;

import java.util.Scanner;

public class SumMajorDiagonal {
    public static double sumMajorDiagonal(double[][] m) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] matrix = new double[4][4];

        System.out.println("Enter a 4-by-4 matrix row by row:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        double sum = sumMajorDiagonal(matrix);
        System.out.println("Sum of the elements in the major diagonal is " + sum);
    }

}

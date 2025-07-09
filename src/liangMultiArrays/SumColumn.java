package liangMultiArrays;

import java.util.Scanner;

public class SumColumn {
    public static double sumColumn(double[][] m, int columnIndex) {
        double sum = 0;
        for (double[] row : m) {
            sum += row[columnIndex];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] matrix = new double[3][4];

        System.out.println("Enter a 3-by-4 matrix row by row:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            double sum = sumColumn(matrix, j);
            System.out.println("Sum of the elements at column " + j + " is " + sum);
        }
    }

}

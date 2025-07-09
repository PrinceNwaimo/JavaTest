package liangMultiArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ColumnSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] matrix = new double[3][3];

        System.out.println("Enter a 3-by-3 matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        double[][] sortedMatrix = sortColumns(matrix);

        System.out.println("The column-sorted matrix is:");
        for (double[] row : sortedMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static double[][] sortColumns(double[][] m) {
        double[][] sortedMatrix = new double[m.length][m[0].length];

        for (int j = 0; j < m[0].length; j++) {
            double[] column = new double[m.length];
            for (int i = 0; i < m.length; i++) {
                column[i] = m[i][j];
            }
            Arrays.sort(column);
            for (int i = 0; i < m.length; i++) {
                sortedMatrix[i][j] = column[i];
            }
        }

        return sortedMatrix;
    }

}

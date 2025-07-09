package liangMultiArrays;

import java.util.Arrays;
import java.util.Scanner;

public class RowSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] matrix = new double[3][3];

        System.out.println("Enter a 3-by-3 matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        double[][] sortedMatrix = sortRows(matrix);

        System.out.println("The row-sorted matrix is:");
        for (double[] row : sortedMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static double[][] sortRows(double[][] m) {
        double[][] sortedMatrix = new double[m.length][m[0].length];

        for (int i = 0; i < m.length; i++) {
            sortedMatrix[i] = Arrays.copyOf(m[i], m[i].length);
            Arrays.sort(sortedMatrix[i]);
        }

        return sortedMatrix;
    }

}

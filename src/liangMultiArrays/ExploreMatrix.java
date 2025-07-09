package liangMultiArrays;

import java.util.Random;
import java.util.Scanner;

public class ExploreMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size for the matrix: ");
        int size = scanner.nextInt();

        int[][] matrix = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(2);
            }
        }

        // Print the matrix
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        // Check rows
        for (int i = 0; i < size; i++) {
            if (isAllSame(matrix[i])) {
                if (matrix[i][0] == 0) {
                    System.out.println("All 0s on row " + i);
                } else {
                    System.out.println("All 1s on row " + i);
                }
            }
        }

        // Check columns
        boolean hasSame = false;
        for (int j = 0; j < size; j++) {
            if (isAllSame(getColumn(matrix, j))) {
                hasSame = true;
                if (matrix[0][j] == 0) {
                    System.out.println("All 0s on column " + j);
                } else {
                    System.out.println("All 1s on column " + j);
                }
            }
        }
        if (!hasSame) {
            System.out.println("No same numbers on a column");
        }

        // Check major diagonal
        int[] majorDiagonal = getMajorDiagonal(matrix);
        if (isAllSame(majorDiagonal)) {
            if (majorDiagonal[0] == 0) {
                System.out.println("All 0s on the major diagonal");
            } else {
                System.out.println("All 1s on the major diagonal");
            }
        } else {
            System.out.println("No same numbers on the major diagonal");
        }

        // Check sub-diagonal
        int[] subDiagonal = getSubDiagonal(matrix);
        if (isAllSame(subDiagonal)) {
            if (subDiagonal[0] == 0) {
                System.out.println("All 0s on the sub-diagonal");
            } else {
                System.out.println("All 1s on the sub-diagonal");
            }
        } else {
            System.out.println("No same numbers on the sub-diagonal");
        }
    }

    public static boolean isAllSame(int[] array) {
        int first = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] != first) {
                return false;
            }
        }
        return true;
    }

    public static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }

    public static int[] getMajorDiagonal(int[][] matrix) {
        int[] diagonal = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            diagonal[i] = matrix[i][i];
        }
        return diagonal;
    }

    public static int[] getSubDiagonal(int[][] matrix) {
        int[] diagonal = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            diagonal[i] = matrix[i][matrix.length - i - 1];
        }
        return diagonal;
    }

}

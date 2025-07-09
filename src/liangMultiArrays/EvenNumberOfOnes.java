package liangMultiArrays;

import java.util.Random;

public class EvenNumberOfOnes {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix();
        printMatrix(matrix);
        checkEvenOnes(matrix);
    }

    private static int[][] generateMatrix() {
        int[][] matrix = new int[6][6];
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matrix[i][j] = random.nextInt(2);
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void checkEvenOnes(int[][] matrix) {
        boolean rowsEven = true;
        boolean colsEven = true;

        // Check rows
        for (int i = 0; i < 6; i++) {
            int count = 0;
            for (int j = 0; j < 6; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }
            if (count % 2 != 0) {
                rowsEven = false;
                System.out.println("Row " + (i + 1) + " has an odd number of 1s.");
            }
        }

        // Check columns
        for (int j = 0; j < 6; j++) {
            int count = 0;
            for (int i = 0; i < 6; i++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }
            if (count % 2 != 0) {
                colsEven = false;
                System.out.println("Column " + (j + 1) + " has an odd number of 1s.");
            }
        }

        if (rowsEven && colsEven) {
            System.out.println("All rows and columns have an even number of 1s.");
        } else if (rowsEven) {
            System.out.println("All rows have an even number of 1s, but some columns do not.");
        } else if (colsEven) {
            System.out.println("All columns have an even number of 1s, but some rows do not.");
        } else {
            System.out.println("Some rows and columns do not have an even number of 1s.");
        }
    }

}

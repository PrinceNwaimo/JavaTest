package liangMultiArrays;

import java.util.Random;

public class LargestRowAndColumn {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        Random random = new Random();

        // Randomly fill in 0s and 1s into the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(2);
            }
        }

        // Print the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        // Find the first row with the most 1s
        int maxRow = 0;
        int maxRowCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }
            if (count > maxRowCount) {
                maxRowCount = count;
                maxRow = i;
            }
        }

        // Find the first column with the most 1s
        int maxCol = 0;
        int maxColCount = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            int count = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }
            if (count > maxColCount) {
                maxColCount = count;
                maxCol = j;
            }
        }

        System.out.println("The largest row index: " + maxRow);
        System.out.println("The largest column index: " + maxCol);
    }

}

package liangMultiArrays;

import java.util.Scanner;

public class FindFlippedCell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[6][6];

        System.out.println("Enter a 6-by-6 matrix:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[] flippedCell = findFlippedCell(matrix);
        if (flippedCell != null) {
            System.out.println("The flipped cell is at (" + flippedCell[0] + ", " + flippedCell[1] + ")");
        } else {
            System.out.println("No cell was flipped.");
        }
    }

    private static int[] findFlippedCell(int[][] matrix) {
        for (int i = 0; i < 6; i++) {
            int rowCount = 0;
            for (int j = 0; j < 6; j++) {
                if (matrix[i][j] == 1) {
                    rowCount++;
                }
            }
            if (rowCount % 2 != 0) {
                for (int j = 0; j < 6; j++) {
                    int colCount = 0;
                    for (int k = 0; k < 6; k++) {
                        if (matrix[k][j] == 1) {
                            colCount++;
                        }
                    }
                    if (colCount % 2 != 0) {
                        return new int[] {i, j};
                    }
                }
            }
        }

        // If no cell is found, check columns first
        for (int j = 0; j < 6; j++) {
            int colCount = 0;
            for (int i = 0; i < 6; i++) {
                if (matrix[i][j] == 1) {
                    colCount++;
                }
            }
            if (colCount % 2 != 0) {
                for (int i = 0; i < 6; i++) {
                    int rowCount = 0;
                    for (int k = 0; k < 6; k++) {
                        if (matrix[i][k] == 1) {
                            rowCount++;
                        }
                    }
                    if (rowCount % 2 != 0) {
                        return new int[] {i, j};
                    }
                }
            }
        }

        return null;
    }

}

package liangMultiArrays;

import java.util.Scanner;

public class LargestBlock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows in the matrix: ");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        System.out.println("Enter the matrix row by row:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[] result = findLargestBlock(matrix);
        if (result[2] == 0) {
            System.out.println("No square submatrix with all 1s exists.");
        } else {
            System.out.println("The maximum square submatrix is at (" + result[0] + ", " + result[1] + ") with size " + result[2]);
        }
    }

    public static int[] findLargestBlock(int[][] m) {
        int n = m.length;
        int[][] dp = new int[n][n];
        int maxSize = 0;
        int x = 0, y = 0;

        for (int i = 0; i < n; i++) {
            dp[i][0] = m[i][0];
            if (m[i][0] == 1) {
                maxSize = 1;
                x = i;
                y = 0;
            }
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = m[0][j];
            if (m[0][j] == 1) {
                maxSize = 1;
                x = 0;
                y = j;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (m[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    if (dp[i][j] > maxSize) {
                        maxSize = dp[i][j];
                        x = i - maxSize + 1;
                        y = j - maxSize + 1;
                    }
                }
            }
        }

        return new int[]{x, y, maxSize};
    }

}

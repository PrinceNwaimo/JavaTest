package liangInheritance;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LargestRowsAndColumns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the array size n: ");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2);
            }
        }

        System.out.println("The random array is");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        int[] rowCounts = new int[n];
        int[] colCounts = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    rowCounts[i]++;
                    colCounts[j]++;
                }
            }
        }

        int maxRowCount = max(rowCounts);
        int maxColCount = max(colCounts);

        ArrayList<Integer> maxRows = new ArrayList<>();
        ArrayList<Integer> maxCols = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (rowCounts[i] == maxRowCount) {
                maxRows.add(i);
            }
            if (colCounts[i] == maxColCount) {
                maxCols.add(i);
            }
        }

        System.out.println("The largest row index: " + maxRows);
        System.out.println("The largest column index: " + maxCols);
    }

    public static int max(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}

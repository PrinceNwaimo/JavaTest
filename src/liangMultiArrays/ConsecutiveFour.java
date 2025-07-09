package liangMultiArrays;

import java.util.Scanner;

public class ConsecutiveFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        int[][] values = new int[rows][cols];
        System.out.println("Enter the values:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                values[i][j] = scanner.nextInt();
            }
        }

        if (isConsecutiveFour(values)) {
            System.out.println("The array contains four consecutive numbers with the same value.");
        } else {
            System.out.println("The array does not contain four consecutive numbers with the same value.");
        }
    }

    public static boolean isConsecutiveFour(int[][] values) {
        // Check horizontally
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length - 3; j++) {
                if (values[i][j] == values[i][j + 1] && values[i][j] == values[i][j + 2] && values[i][j] == values[i][j + 3]) {
                    return true;
                }
            }
        }

        // Check vertically
        for (int i = 0; i < values.length - 3; i++) {
            for (int j = 0; j < values[i].length; j++) {
                if (values[i][j] == values[i + 1][j] && values[i][j] == values[i + 2][j] && values[i][j] == values[i + 3][j]) {
                    return true;
                }
            }
        }

        // Check diagonally (top-left to bottom-right)
        for (int i = 0; i < values.length - 3; i++) {
            for (int j = 0; j < values[i].length - 3; j++) {
                if (values[i][j] == values[i + 1][j + 1] && values[i][j] == values[i + 2][j + 2] && values[i][j] == values[i + 3][j + 3]) {
                    return true;
                }
            }
        }

        // Check diagonally (bottom-left to top-right)
        for (int i = 3; i < values.length; i++) {
            for (int j = 0; j < values[i].length - 3; j++) {
                if (values[i][j] == values[i - 1][j + 1] && values[i][j] == values[i - 2][j + 2] && values[i][j] == values[i - 3][j + 3]) {
                    return true;
                }
            }
        }

        return false;
    }

}

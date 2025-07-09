package liangMultiArrays;

import java.util.Scanner;

public class LatinSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number n: ");
        int n = scanner.nextInt();
        char[][] latinSquare = new char[n][n];

        System.out.println("Enter " + n + " rows of letters separated by spaces:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                latinSquare[i][j] = scanner.next().charAt(0);
            }
        }

        if (isLatinSquare(latinSquare)) {
            System.out.println("The input array is a Latin square");
        } else {
            System.out.println("The input array is not a Latin square");
        }
    }

    public static boolean isLatinSquare(char[][] latinSquare) {
        int n = latinSquare.length;
        boolean[] rowCheck = new boolean[n];
        boolean[] colCheck = new boolean[n];

        // Check rows
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = latinSquare[i][j];
                if (c < 'A' || c >= 'A' + n) return false;
                if (rowCheck[c - 'A']) return false;
                rowCheck[c - 'A'] = true;
            }
            for (int k = 0; k < n; k++) rowCheck[k] = false;
        }

        // Check columns
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                char c = latinSquare[i][j];
                if (colCheck[c - 'A']) return false;
                colCheck[c - 'A'] = true;
            }
            for (int k = 0; k < n; k++) colCheck[k] = false;
        }

        return true;
    }

}

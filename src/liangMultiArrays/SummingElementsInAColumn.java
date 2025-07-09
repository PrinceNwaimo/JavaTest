package liangMultiArrays;

import java.util.Scanner;

public class SummingElementsInAColumn {
    public static void main(String[] args) {
        int[][] matrix = new int[10][10];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter " + matrix.length+" rows and " + matrix[0].length + " columns");
            for (int column = 0; column < matrix[0].length; column++) {
                int total = 0;
                for (int row = 0; row < matrix.length; row++) {
                    matrix[column][row] = input.nextInt();
                    total += matrix[row][column];
                    System.out.print(matrix[row][column] + " ");
            }

                System.out.println("Sum for column " + column + " is " + total);
        }

    }
}

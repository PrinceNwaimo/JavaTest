package liangMultiArrays;

import java.util.Scanner;

public class NineHeadsAndTails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 511: ");
        int number = scanner.nextInt();

        if (number < 0 || number > 511) {
            System.out.println("Invalid input");
            return;
        }

        String binary = Integer.toBinaryString(number);
        while (binary.length() < 9) {
            binary = "0" + binary;
        }

        char[][] matrix = new char[3][3];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = (binary.charAt(index++) == '0') ? 'H' : 'T';
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}

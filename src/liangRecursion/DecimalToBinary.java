package liangRecursion;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int value = scanner.nextInt();
        scanner.close();
        System.out.println("Binary representation: " + dec2Bin(value));
    }

    public static String dec2Bin(int value) {
        if (value == 0) {
            return "0";
        } else if (value == 1) {
            return "1";
        } else {
            return dec2Bin(value / 2) + (value % 2);
        }
    }
}

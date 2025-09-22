package liangRecursion;

import java.util.Scanner;

public class DecimalToHex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int value = scanner.nextInt();
        scanner.close();
        System.out.println("Hexadecimal representation: " + dec2Hex(value));
    }

    public static String dec2Hex(int value) {
        if (value == 0) {
            return "0";
        } else if (value < 16) {
            return getHexDigit(value);
        } else {
            return dec2Hex(value / 16) + getHexDigit(value % 16);
        }
    }

    private static String getHexDigit(int value) {
        if (value < 10) {
            return String.valueOf(value);
        } else {
            char hexDigit = (char) ('A' + value - 10);
            return String.valueOf(hexDigit);
        }
    }
}

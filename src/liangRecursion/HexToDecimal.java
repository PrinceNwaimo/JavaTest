package liangRecursion;

import java.util.Scanner;

public class HexToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a hex string: ");
        String hexString = scanner.nextLine().toUpperCase();
        scanner.close();
        try {
            System.out.println("Decimal equivalent: " + hex2Dec(hexString));
        } catch (NumberFormatException e) {
            System.out.println("Invalid hex string");
        }
    }

    public static int hex2Dec(String hexString) {
        if (!isHex(hexString)) {
            throw new NumberFormatException("Invalid hex string");
        }
        return hex2Dec(hexString, hexString.length() - 1, 0);
    }

    private static int hex2Dec(String hexString, int index, int decimal) {
        if (index < 0) {
            return decimal;
        } else {
            decimal += getDecimalValue(hexString.charAt(index)) * (int) Math.pow(16, hexString.length() - 1 - index);
            return hex2Dec(hexString, index - 1, decimal);
        }
    }

    private static int getDecimalValue(char hexDigit) {
        if (hexDigit >= '0' && hexDigit <= '9') {
            return hexDigit - '0';
        } else if (hexDigit >= 'A' && hexDigit <= 'F') {
            return 10 + hexDigit - 'A';
        } else {
            throw new NumberFormatException("Invalid hex string");
        }
    }

    private static boolean isHex(String hexString) {
        for (char c : hexString.toUpperCase().toCharArray()) {
            if (!((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F'))) {
                return false;
            }
        }
        return true;
    }
}

package liangRecursion;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary string: ");
        String binaryString = scanner.nextLine();
        scanner.close();
        try {
            System.out.println("Decimal equivalent: " + bin2Dec(binaryString));
        } catch (NumberFormatException e) {
            System.out.println("Invalid binary string");
        }
    }

    public static int bin2Dec(String binaryString) {
        if (!isBinary(binaryString)) {
            throw new NumberFormatException("Invalid binary string");
        }
        return bin2Dec(binaryString, binaryString.length() - 1, 0);
    }

    private static int bin2Dec(String binaryString, int index, int decimal) {
        if (index < 0) {
            return decimal;
        } else {
            decimal += (binaryString.charAt(index) - '0') * (int) Math.pow(2, binaryString.length() - 1 - index);
            return bin2Dec(binaryString, index - 1, decimal);
        }
    }

    private static boolean isBinary(String binaryString) {
        for (char c : binaryString.toCharArray()) {
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }
}

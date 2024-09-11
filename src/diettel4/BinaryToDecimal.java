package diettel4;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a binary number (0s and 1s):");
        int binary = scanner.nextInt();

        int decimal = 0;
        int power = 0;

        while (binary > 0) {
            int digit = binary % 10;
            decimal += digit * Math.pow(2, power);
            binary /= 10;
            power++;
        }

        System.out.println("Decimal equivalent: " + decimal);
    }

}

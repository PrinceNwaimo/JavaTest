package mathsClasses;

import java.util.Scanner;

public class HexToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a hex digit (0-F): ");
        String hex = scanner.next().toUpperCase();

        if (hex.matches("[0-9A-F]")) {
            int decimal = Integer.parseInt(hex, 16);
            String binary = Integer.toBinaryString(decimal);
            System.out.println("The binary representation of '" + hex + "' is: " + binary);
        } else {
            System.out.println("Invalid input. Please enter a hex digit between 0 and F.");
        }
    }

}

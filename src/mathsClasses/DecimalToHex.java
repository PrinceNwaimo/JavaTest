package mathsClasses;

import java.util.Scanner;

public class DecimalToHex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number (0-15): ");
        int decimal = scanner.nextInt();

        if (decimal >= 0 && decimal <= 15) {
            String hex = Integer.toHexString(decimal).toUpperCase();
            System.out.println("The hex number is: " + hex);
        } else {
            System.out.println("Invalid input. Please enter a number between 0 and 15.");
        }
    }

}

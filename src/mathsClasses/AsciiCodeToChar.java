package mathsClasses;

import java.util.Scanner;

public class AsciiCodeToChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an ASCII code (0-127): ");
        int asciiCode = scanner.nextInt();

        if (asciiCode >= 0 && asciiCode <= 127) {
            char character = (char) asciiCode;
            System.out.println("The character for ASCII code " + asciiCode + " is: " + character);
        } else {
            System.out.println("Invalid ASCII code. Please enter a value between 0 and 127.");
        }
    }

}

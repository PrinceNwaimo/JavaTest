package joyceExceptionHandling;

import java.util.Scanner;

public class TryToParseDouble {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = 0;

        try {
            System.out.print("Enter a double value: ");
            number = Double.parseDouble(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Number set to 0.");
        }

        System.out.println("Number: " + number);
    }
}

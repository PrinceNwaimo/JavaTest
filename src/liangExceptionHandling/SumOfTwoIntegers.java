package liangExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = getIntegerInput(scanner, "Enter the first integer: ");
        int num2 = getIntegerInput(scanner, "Enter the second integer: ");

        System.out.println("The sum of " + num1 + " and " + num2 + " is " + (num1 + num2));
    }

    public static int getIntegerInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume the invalid input
            }
        }
    }
}

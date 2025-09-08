package joyceExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DistanceFromAverageWithExceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arraySize = getArraySize(scanner);
        double[] numbers = new double[arraySize];

        getNumbers(numbers, scanner);
        calculateAndDisplayDistances(numbers);
    }

    private static int getArraySize(Scanner scanner) {
        int arraySize = 5; // Default array size
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter the number of values (array size): ");
                arraySize = scanner.nextInt();
                if (arraySize < 0) {
                    throw new NegativeArraySizeException();
                }
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter an integer.");
                scanner.next(); // Clear the invalid input
            } catch (NegativeArraySizeException e) {
                System.out.println("Error: Array size cannot be negative. Using default size of 5.");
            }
        }

        return arraySize;
    }

    private static void getNumbers(double[] numbers, Scanner scanner) {
        for (int i = 0; i < numbers.length; i++) {
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.print("Enter value " + (i + 1) + ": ");
                    numbers[i] = scanner.nextDouble();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                }
            }
        }
    }

    private static void calculateAndDisplayDistances(double[] numbers) {
        double sum = 0;

        for (double number : numbers) {
            sum += number;
        }

        double average = sum / numbers.length;

        System.out.println("Value\tDistance from Average");
        for (double number : numbers) {
            System.out.println(number + "\t" + Math.abs(number - average));
        }
    }
}

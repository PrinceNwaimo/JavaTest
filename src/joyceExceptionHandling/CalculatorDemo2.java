package joyceExceptionHandling;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CalculatorDemo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int num1 = random.nextInt(5000) + 1;
            int num2 = random.nextInt(5000) + 1;

            System.out.println("What is " + num1 + " + " + num2 + "?");
            try {
                int userAnswer = scanner.nextInt();
                int correctAnswer = num1 + num2;
                if (userAnswer == correctAnswer) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. The correct answer is " + correctAnswer);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
    }
}

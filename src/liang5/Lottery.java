package liang5;

import java.util.Random;
import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {
        // Create a Random object
        Random random = new Random();

        // Generate the first digit (0-9)
        int firstDigit = random.nextInt(10); // Generates a number from 0 to 9

        // Generate the second digit (0-9) and ensure it's different from the first
        int secondDigit;
        do {
            secondDigit = random.nextInt(10); // Generate again until it's different
        } while (secondDigit == firstDigit);

        // Display the generated lottery number
        System.out.println("Your lottery number is: " + firstDigit + "" + secondDigit);

        // Prompt user to enter their guess
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your lottery guess (two distinct digits): ");
        String userGuess = scanner.nextLine();

        // Validate the user's guess
        if (userGuess.length() != 2) {
            System.out.println("Invalid input! Please enter exactly two digits.");
            return;
        }

        // Extract digits from user guess
        int userFirstDigit = Character.getNumericValue(userGuess.charAt(0));
        int userSecondDigit = Character.getNumericValue(userGuess.charAt(1));

        // Check for distinct digits
        if (userFirstDigit == userSecondDigit) {
            System.out.println("Digits must be distinct!");
            return;
        }

        // Compare user's guess with the lottery number
        if (userFirstDigit == firstDigit && userSecondDigit == secondDigit) {
            System.out.println("Congratulations! You have won the lottery!");
        } else {
            System.out.println("Sorry, you did not win. The correct number was: " + firstDigit + "" + secondDigit);
        }
    }
}


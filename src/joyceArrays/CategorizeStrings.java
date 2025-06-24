package joyceArrays;

import java.util.Scanner;

public class CategorizeStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] shortStrings = new String[20];
        String[] longStrings = new String[20];
        int shortIndex = 0;
        int longIndex = 0;

        System.out.println("Enter up to 20 strings (or 'done' to finish):");
        while (shortIndex + longIndex < 20) {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            if (input.length() <= 10) {
                shortStrings[shortIndex++] = input;
            } else {
                longStrings[longIndex++] = input;
            }
        }

        while (true) {
            System.out.println("Enter 'short' to display short strings, 'long' to display long strings, or 'quit' to exit:");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("quit")) {
                break;
            }
            if (choice.equals("short")) {
                if (shortIndex == 0) {
                    System.out.println("No short strings entered.");
                } else {
                    System.out.println("Short strings:");
                    for (int i = 0; i < shortIndex; i++) {
                        System.out.println(shortStrings[i]);
                    }
                }
            } else {
                if (longIndex == 0) {
                    System.out.println("No long strings entered.");
                } else {
                    System.out.println("Long strings:");
                    for (int i = 0; i < longIndex; i++) {
                        System.out.println(longStrings[i]);
                    }
                }
            }
        }

        scanner.close();
    }

}

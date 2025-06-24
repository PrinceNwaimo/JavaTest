package joyceArrays;

import java.util.Scanner;

public class CategorizeStrings2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] noSpaces = new String[20];
        String[] oneSpace = new String[20];
        String[] multipleSpaces = new String[20];
        int noSpacesIndex = 0;
        int oneSpaceIndex = 0;
        int multipleSpacesIndex = 0;

        System.out.println("Enter up to 20 strings (or 'done' to finish):");
        while (noSpacesIndex + oneSpaceIndex + multipleSpacesIndex < 20) {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            int spaceCount = countSpaces(input);
            if (spaceCount == 0) {
                noSpaces[noSpacesIndex++] = input;
            } else if (spaceCount == 1) {
                oneSpace[oneSpaceIndex++] = input;
            } else {
                multipleSpaces[multipleSpacesIndex++] = input;
            }
        }

        while (true) {
            System.out.println("Enter 'none' for strings with no spaces, 'one' for strings with one space, 'multiple' for strings with multiple spaces, or 'all' to display all strings:");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("none")) {
                displayStrings(noSpaces, noSpacesIndex, "Strings with no spaces:");
            } else if (choice.equals("one")) {
                displayStrings(oneSpace, oneSpaceIndex, "Strings with one space:");
            } else if (choice.equals("multiple")) {
                displayStrings(multipleSpaces, multipleSpacesIndex, "Strings with multiple spaces:");
            } else {
                System.out.println("All strings:");
                displayStrings(noSpaces, noSpacesIndex, "");
                displayStrings(oneSpace, oneSpaceIndex, "");
                displayStrings(multipleSpaces, multipleSpacesIndex, "");
            }
            if (choice.equals("quit")) {
                break;
            }
        }

        scanner.close();
    }

    public static int countSpaces(String input) {
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == ' ') {
                count++;
            }
        }
        return count;
    }

    public static void displayStrings(String[] strings, int index, String message) {
        if (index == 0) {
            System.out.println("No strings in this category.");
        } else {
            if (!message.isEmpty()) {
                System.out.println(message);
            }
            for (int i = 0; i < index; i++) {
                System.out.println(strings[i]);
            }
        }
    }

}

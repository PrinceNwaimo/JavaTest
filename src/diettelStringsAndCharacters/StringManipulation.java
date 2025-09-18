package diettelStringsAndCharacters;

import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int specialCount = 0, nonSpecialCount = 0;

        System.out.println("Enter strings (# to stop):");
        StringBuilder specialStrings = new StringBuilder();
        StringBuilder nonSpecialStrings = new StringBuilder();

        while (true) {
            input = scanner.nextLine();
            if (input.equals("#")) {
                break;
            }

            String formattedInput = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();

            if (hasSpecialCharacters(input)) {
                specialStrings.append(formattedInput).append("\n");
                specialCount++;
            } else {
                nonSpecialStrings.append(formattedInput).append("\n");
                nonSpecialCount++;
            }
        }

        scanner.close();

        System.out.println("Strings with special characters:");
        System.out.println(specialStrings.toString().trim());
        System.out.println("Count: " + specialCount);

        System.out.println("\nStrings without special characters:");
        System.out.println(nonSpecialStrings.toString().trim());
        System.out.println("Count: " + nonSpecialCount);
    }

    public static boolean hasSpecialCharacters(String str) {
        return !str.matches("[a-zA-Z0-9]+");
    }
}

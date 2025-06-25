package joyceArrays;

import java.util.Scanner;

public class BirthdayReminder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = new String[10];
        String[] birthdates = new String[10];
        int count = 0;

        // Get names and birth dates
        while (count < names.length) {
            System.out.print("Enter name (or 'ZZZ' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("ZZZ")) {
                break;
            }
            System.out.print("Enter birthdate for " + name + ": ");
            String birthdate = scanner.nextLine();

            names[count] = name;
            birthdates[count] = birthdate;
            count++;
        }

        // The user is finished entering names
        System.out.println("You entered " + count + " names.");

        // Display names
        System.out.println("The names are:");
        for (int i = 0; i < count; i++) {
            System.out.println(names[i]);
        }

        // Continuously ask the user to type one of the names
        while (true) {
            System.out.print("Enter a name to display birthdate (or 'ZZZ' to quit): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("ZZZ")) {
                break;
            }

            boolean found = false;
            for (int i = 0; i < count; i++) {
                if (names[i].equalsIgnoreCase(name)) {
                    System.out.println("The birthdate of " + names[i] + " is " + birthdates[i]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Sorry, no birthdate found for " + name);
            }
        }

        scanner.close();
    }

}

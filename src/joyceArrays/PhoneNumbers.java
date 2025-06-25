package joyceArrays;

import java.util.Scanner;

public class PhoneNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = new String[30];
        String[] phoneNumbers = new String[30];
        int count = 0;

        // Initialize the first 10 names and phone numbers
        names[0] = "John"; phoneNumbers[0] = "123-456-7890";
        names[1] = "Jane"; phoneNumbers[1] = "987-654-3210";
        names[2] = "Bob"; phoneNumbers[2] = "555-123-4567";
        names[3] = "Alice"; phoneNumbers[3] = "901-234-5678";
        names[4] = "Mike"; phoneNumbers[4] = "111-222-3333";
        names[5] = "Emma"; phoneNumbers[5] = "444-555-6666";
        names[6] = "David"; phoneNumbers[6] = "777-888-9999";
        names[7] = "Sophia"; phoneNumbers[7] = "2227-3333-4444";
        names[8] = "Michael"; phoneNumbers[8] = "8888-9999-0000";
        names[9] = "Emily"; phoneNumbers[9] = "9999-0000-1111";

        count = 10;

        while (true) {
            System.out.print("Enter a name (or 'quit' to exit): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("quit")) {
                break;
            }

            int index = findName(names, count, name);

            if (index != -1) {
                System.out.println("The phone number of " + name + " is " + phoneNumbers[index]);
            } else {
                if (count < names.length) {
                    System.out.print("Name not found. Please enter phone number for " + name + ": ");
                    String phoneNumber = scanner.nextLine();
                    names[count] = name;
                    phoneNumbers[count] = phoneNumber;
                    count++;
                    System.out.println("Name and phone number added successfully.");
                } else {
                    System.out.println("Phone directory is full. Cannot add new entries.");
                }
            }
        }

        scanner.close();
    }

    public static int findName(String[] names, int count, String name) {
        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

}

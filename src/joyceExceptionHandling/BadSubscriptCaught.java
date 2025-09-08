package joyceExceptionHandling;

import java.util.Scanner;

public class BadSubscriptCaught {
    public static void main(String[] args) {
        String[] names = {"John", "Mary", "David", "Emily", "Michael", "Sarah", "William", "Olivia"};

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter an integer between 0 and " + (names.length - 1) + ": ");
            int index = scanner.nextInt();
            System.out.println("Name at index " + index + " is " + names[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of range. Please enter a number between 0 and " + (names.length - 1) + ".");
        }
    }
}

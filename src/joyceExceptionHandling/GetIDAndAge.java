package joyceExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetIDAndAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        int id = 0;
        int age = 0;

        while (!validInput) {
            try {
                System.out.print("Enter ID (0-999) or 0 to quit: ");
                id = scanner.nextInt();
                if (id < 0 || id > 999) {
                    throw new DataEntryException("Invalid ID. ID should be between 0 and 999.");
                }
                System.out.print("Enter age (0-119) or 0 to quit: ");
                age = scanner.nextInt();
                if (age < 0 || age > 119) {
                    throw new DataEntryException("Invalid age. Age should be between 0 and 119.");
                }
                if (id == 0 && age == 0) {
                    validInput = true;
                } else {
                    System.out.println("ID: " + id + ", Age: " + age);
                }
            } catch (DataEntryException e) {
                System.out.println(e.getMessage());
                scanner.next();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }
}

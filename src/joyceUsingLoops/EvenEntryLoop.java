package joyceUsingLoops;

import java.util.Scanner;

public class EvenEntryLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;

        while (true) {
            System.out.print("Enter an even number (or 999 to stop): ");
            input = scanner.nextInt();

            if (input == 999) {
                break;
            } else if (input % 2 == 0) {
                System.out.println("Good job!");
            } else {
                System.out.println("Error: You did not enter an even number.");
            }
        }

        scanner.close();
    }
}




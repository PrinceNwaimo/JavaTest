package joyceUsingLoops;

import java.util.Scanner;

public class Inbetween {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();

        int smaller = Math.min(num1, num2);
        int larger = Math.max(num1, num2);

        if (larger - smaller <= 1) {
            System.out.println("There are no integers between the entered values.");
        } else {
            System.out.println("Integers between " + smaller + " and " + larger + " are:");
            for (int i = smaller + 1; i < larger; i++) {
                System.out.println(i);
            }
        }

        scanner.close();
    }

}

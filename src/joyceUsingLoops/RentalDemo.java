package joyceUsingLoops;

import joyceUsingIfAndElse.Rental;

import java.util.Scanner;

public class RentalDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rental rental1 = new Rental(34,4,30);
        Rental rental2 = new Rental(25,4,30);
        Rental rental3 = new Rental(24,4,30);

        setRentalDetails(scanner, rental1);
        setRentalDetails(scanner, rental2);
        setRentalDetails(scanner, rental3);

        System.out.println("Rental 1 details:");
        rental1.toString();

        System.out.println("Rental 2 details:");
        rental2.toString();

        System.out.println("Rental 3 details:");
        rental3.toString();

        System.out.println("Coupons for Rental 3:");
        for (int i = 0; i < rental3.getMinutes() / 60; i++) {
            System.out.println("Coupon good for 10 percent off next rental");
        }

        scanner.close();
    }

    public static void setRentalDetails(Scanner scanner, Rental rental) {
        int minutes;
        while (true) {
            System.out.print("Enter number of minutes (60-7200): ");
            minutes = scanner.nextInt();
            if (minutes >= 60 && minutes <= 7200) {
                break;
            }
            System.out.println("Invalid number of minutes. Please enter a value between 60 and 7200.");
        }
        rental.getMinutes();
    }

}

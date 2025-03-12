package joyceChapter3;

import java.util.Scanner;

public class SammysRentalPriceWithMethods {
    public static void main(String[] args) {
        int minutes = getMinutesRented();
        displayMotto();
        displayRentalDetails(minutes);
    }

    public static int getMinutesRented() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of minutes rented: ");
        int minutes = scanner.nextInt();
        scanner.close();
        return minutes;
    }

    public static void displayMotto() {
        System.out.println("*********************************");
        System.out.println("* Sammy's makes it fun in the *");
        System.out.println("* sun!                          *");
        System.out.println("*********************************");
    }

    public static void displayRentalDetails(int minutes) {
        final int MINUTES_IN_HOUR = 60;
        final int HOURLY_RATE = 40;

        int hours = minutes / MINUTES_IN_HOUR;
        int extraMinutes = minutes % MINUTES_IN_HOUR;
        double price = (hours * HOURLY_RATE) + (extraMinutes * 1.0);

        System.out.println("Hours: " + hours);
        System.out.println("Extra minutes: " + extraMinutes);
        System.out.println("Hourly rate: $" + HOURLY_RATE);
        System.out.println("Total price: $" + price);
    }
}

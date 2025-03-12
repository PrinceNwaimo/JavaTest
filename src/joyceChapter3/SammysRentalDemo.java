package joyceChapter3;

import java.util.Scanner;

public class SammysRentalDemo {
    public static void main(String[] args) {
        Rental rental = new Rental();
        rental.setContractNumber(getContractNumber());
        rental.setHoursAndMinutes(getMinutesRented());

        SammysRentalPriceWithMethods.displayMotto();
        displayRentalDetails(rental);
    }

    public static String getContractNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the contract number: ");
        String contractNumber = scanner.next();
        scanner.close();
        return contractNumber;
    }

    public static int getMinutesRented() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of minutes rented: ");
        int minutes = scanner.nextInt();
        scanner.close();
        return minutes;
    }

    public static void displayRentalDetails(Rental rental) {
        System.out.println("Contract Number: " + rental.getContractNumber());
        System.out.println("Hours: " + rental.getHours());
        System.out.println("Extra minutes: " + rental.getExtraMinutes());
        System.out.println("Hourly rate: $" + Rental.HOURLY_RATE);
        System.out.println("Total price: $" + rental.getPrice());
    }
}

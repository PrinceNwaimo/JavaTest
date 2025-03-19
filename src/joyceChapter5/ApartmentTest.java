package joyceChapter5;

import java.util.Scanner;

public class ApartmentTest {
    public static void main(String[] args) {
        Apartment[] apartments = new Apartment[5];
        apartments[0] = new Apartment(101, 2, 1, 1000);
        apartments[1] = new Apartment(102, 1, 1, 800);
        apartments[2] = new Apartment(103, 3, 2, 1500);
        apartments[3] = new Apartment(104, 2, 2, 1200);
        apartments[4] = new Apartment(105, 1, 1, 900);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter minimum number of bedrooms: ");
        int minBedrooms = scanner.nextInt();

        System.out.print("Enter minimum number of baths: ");
        int minBaths = scanner.nextInt();

        System.out.print("Enter maximum rent: ");
        double maxRent = scanner.nextDouble();

        boolean found = false;

        for (Apartment apartment : apartments) {
            if (apartment.getBedrooms() >= minBedrooms &&
                    apartment.getBaths() >= minBaths &&
                    apartment.getRent() <= maxRent) {
                System.out.println("\nApartment " + apartment.getApartmentNumber() + ":");
                System.out.println("Bedrooms: " + apartment.getBedrooms());
                System.out.println("Baths: " + apartment.getBaths());
                System.out.println("Rent: $" + apartment.getRent());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No apartments found that meet your criteria.");
        }
    }

}

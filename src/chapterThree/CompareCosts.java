package chapterThree;

import java.util.Scanner;

public class CompareCosts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get weight and price for package 1
        System.out.print("Enter weight of package 1 (in pounds): ");
        double weight1 = scanner.nextDouble();
        System.out.print("Enter price of package 1: ");
        double price1 = scanner.nextDouble();

        // Get weight and price for package 2
        System.out.print("Enter weight of package 2 (in pounds): ");
        double weight2 = scanner.nextDouble();
        System.out.print("Enter price of package 2: ");
        double price2 = scanner.nextDouble();

        // Calculate price per pound for each package
        double pricePerPound1 = price1 / weight1;
        double pricePerPound2 = price2 / weight2;

        // Compare prices and display result
        if (pricePerPound1 < pricePerPound2) {
            System.out.println("Package 1 has the better price: $" + pricePerPound1 + " per pound");
        } else if (pricePerPound1 > pricePerPound2) {
            System.out.println("Package 2 has the better price: $" + pricePerPound2 + " per pound");
        } else {
            System.out.println("Both packages have the same price: $" + pricePerPound1 + " per pound");
        }
    }

}

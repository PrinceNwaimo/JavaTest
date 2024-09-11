package diettel4;

import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int citizenCount = 0;

        while (citizenCount < 3) {
            System.out.println("Enter citizen's name:");
            String name = scanner.next();

            System.out.println("Enter citizen's earnings:");
            double earnings = scanner.nextDouble();

            double tax;
            if (earnings <= 30000) {
                tax = earnings * 0.15;
            } else {
                tax = 30000 * 0.15 + (earnings - 30000) * 0.20;
            }

            System.out.printf("%s's total tax is: $%.2f%n", name, tax);

            citizenCount++;
        }
    }

}

package mathsClasses;

import java.util.Scanner;

public class ComputeChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount (e.g., 11.56): ");
        String amount = scanner.next();

        int decimalIndex = amount.indexOf('.');
        int dollars = Integer.parseInt(amount.substring(0, decimalIndex));
        int cents = Integer.parseInt(amount.substring(decimalIndex + 1));

        int quarters = cents / 25;
        cents %= 25;
        int dimes = cents / 10;
        cents %= 10;
        int nickels = cents / 5;
        cents %= 5;

        System.out.println("Dollars: " + dollars);
        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickels: " + nickels);
        System.out.println("Cents: " + cents);
    }

}

package chapterThree;

import java.util.Scanner;

public class CurrencyExchange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter exchange rate from USD to RMB: ");
        double exchangeRate = scanner.nextDouble();

        System.out.print("Enter 0 to convert from USD to RMB, 1 to convert from RMB to USD: ");
        int conversionType = scanner.nextInt();

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        if (conversionType == 0) {
            double convertedAmount = amount * exchangeRate;
            System.out.println(amount + " USD is equal to " + convertedAmount + " RMB");
        } else if (conversionType == 1) {
            double convertedAmount = amount / exchangeRate;
            System.out.println(amount + " RMB is equal to " + convertedAmount + " USD");
        } else {
            System.out.println("Invalid conversion type");
        }
    }

}

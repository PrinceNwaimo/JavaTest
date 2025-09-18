package diettelStringsAndCharacters;

import java.util.Scanner;

public class CheckAmountInWords {
    private static final String[] ones = {"", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
    private static final String[] teens = {"TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN"};
    private static final String[] tens = {"", "", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a check amount (less than $1000): ");
        double amount = scanner.nextDouble();
        scanner.close();

        if (amount >= 1000) {
            System.out.println("Amount is greater than or equal to $1000.");
            return;
        }

        int dollars = (int) amount;
        int cents = (int) Math.round((amount - dollars) * 100);

        System.out.print(getWordEquivalent(dollars) + " and " + String.format("%02d", cents) + "/100");
    }

    private static String getWordEquivalent(int number) {
        if (number == 0) {
            return "ZERO";
        }

        StringBuilder word = new StringBuilder();

        if (number >= 100) {
            word.append(ones[number / 100]).append(" hundred");
            number %= 100;
            if (number > 0) {
                word.append(" ");
            }
        }

        if (number >= 20) {
            word.append(tens[number / 10]);
            number %= 10;
            if (number > 0) {
                word.append(" ");
            }
        }

        if (number >= 10 && number < 20) {
            word.append(teens[number - 10]);
            number = 0;
        }

        if (number > 0) {
            word.append(ones[number]);
        }

        return word.toString().toUpperCase();
    }
}

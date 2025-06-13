package liangChapter6;

import java.util.Scanner;

public class CreditCardValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a credit card number: ");
        long number = scanner.nextLong();
        scanner.close();

        if (isValid(number)) {
            System.out.println(number + " is valid");
            if (prefixMatched(number, 4)) {
                System.out.println("This is a Visa card");
            } else if (prefixMatched(number, 5)) {
                System.out.println("This is a Master card");
            } else if (prefixMatched(number, 37)) {
                System.out.println("This is an American Express card");
            } else if (prefixMatched(number, 6)) {
                System.out.println("This is a Discover card");
            }
        } else {
            System.out.println(number + " is invalid");
        }
    }

    public static boolean isValid(long number) {
        int total = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
        return total % 10 == 0 && (getSize(number) >= 13 && getSize(number) <= 16);
    }

    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String str = Long.toString(number);
        for (int i = str.length() - 2; i >= 0; i -= 2) {
            sum += getDigit(2 * (str.charAt(i) - '0'));
        }
        return sum;
    }

    public static int getDigit(int number) {
        if (number < 10) {
            return number;
        } else {
            return number / 10 + number % 10;
        }
    }

    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String str = Long.toString(number);
        for (int i = str.length() - 1; i >= 0; i -= 2) {
            sum += str.charAt(i) - '0';
        }
        return sum;
    }

    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    public static int getSize(long d) {
        return Long.toString(d).length();
    }

    public static long getPrefix(long number, int k) {
        String str = Long.toString(number);
        if (str.length() < k) {
            return number;
        } else {
            return Long.parseLong(str.substring(0, k));
        }
    }

}

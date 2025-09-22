package liangRecursion;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        long n = scanner.nextLong();
        scanner.close();

        int sum = sumDigits(n);
        System.out.println("The sum of the digits in " + n + " is " + sum);
    }

    public static int sumDigits(long n) {
        if (n < 10 && n >= 0) {
            return (int) n;
        } else if (n < 0) {
            return sumDigits(-n);
        } else {
            return (int) (n % 10) + sumDigits(n / 10);
        }
    }
}

package liangChapter6;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer:");
        long n = scanner.nextLong();

        int sum = sumDigits(n);

        System.out.println("The sum of the digits is: " + sum);

        scanner.close();
    }

    public static int sumDigits(long n) {
        int sum = 0;
        n = Math.abs(n); // handle negative numbers

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

}

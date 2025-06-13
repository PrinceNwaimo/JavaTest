package liangChapter6;

import java.util.Scanner;

public class PalindromeInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer:");
        int number = scanner.nextInt();

        if (isPalindrome(number)) {
            System.out.println(number + " is a palindrome.");
        } else {
            System.out.println(number + " is not a palindrome.");
        }

        scanner.close();
    }

    public static int reverse(int number) {
        int reversed = 0;
        int sign = number < 0 ? -1 : 1;
        number = Math.abs(number);

        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }

        return sign * reversed;
    }

    public static boolean isPalindrome(int number) {
        return number == reverse(number);
    }

}

package diettel6;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a four-digit integer: ");
        int num = scanner.nextInt();
        scanner.close();

        if (num >= 1000 && num <= 9999) {
            int sum = sumOfDigits(num);
            System.out.println("The sum of the digits of " + num + " is: " + sum);
        } else {
            System.out.println("Please enter a valid four-digit integer.");
        }
    }

    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}

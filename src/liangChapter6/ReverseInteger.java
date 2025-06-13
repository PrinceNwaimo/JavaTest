package liangChapter6;

import java.util.Scanner;

public class ReverseInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer:");
        int number = scanner.nextInt();

        System.out.print("The reversal of " + number + " is: ");
        reverse(number);

        scanner.close();
    }

    public static void reverse(int number) {
        int sign = number < 0 ? -1 : 1;
        number = Math.abs(number);

        while (number > 0) {
            System.out.print(number % 10);
            number /= 10;
        }

        System.out.println();
    }

}

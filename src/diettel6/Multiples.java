package diettel6;

import java.util.Scanner;

public class Multiples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the first integer (or 0 to exit): ");
            int num1 = scanner.nextInt();
            if (num1 == 0) {
                break;
            }
            System.out.print("Enter the second integer: ");
            int num2 = scanner.nextInt();

            if (isMultiple(num1, num2)) {
                System.out.println(num2 + " is a multiple of " + num1);
            } else {
                System.out.println(num2 + " is not a multiple of " + num1);
            }
        }
        scanner.close();
    }

    public static boolean isMultiple(int num1, int num2) {
        if (num1 == 0) {
            throw new ArithmeticException("Cannot determine if a number is a multiple of zero");
        }
        return num2 % num1 == 0;
    }

}

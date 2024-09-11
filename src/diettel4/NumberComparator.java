package diettel4;

import java.util.Scanner;

public class NumberComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number:");
        int num1 = scanner.nextInt();

        System.out.println("Enter the second number:");
        int num2 = scanner.nextInt();

        int result = compareNumbers(num1, num2);

        System.out.println(result);
    }

    public static int compareNumbers(int num1, int num2) {
        if (num1 == num2) {
            return 0;
        } else if (num1 > num2) {
            return 1;
        } else {
            return -1;
        }
    }

}

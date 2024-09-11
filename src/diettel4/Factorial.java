package diettel4;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a nonnegative integer:");
        int n = scanner.nextInt();

        long factorial = 1;
        int i = 1;
        while (i <= n) {
            factorial *= i;
            i++;
        }

        System.out.println("Factorial of " + n + " is: " + factorial);
    }

}

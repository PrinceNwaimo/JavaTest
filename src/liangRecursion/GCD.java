package liangRecursion;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first integer: ");
        int m = scanner.nextInt();
        System.out.print("Enter the second integer: ");
        int n = scanner.nextInt();
        scanner.close();

        int gcd = gcd(m, n);
        System.out.println("The GCD of " + m + " and " + n + " is: " + gcd);
    }

    public static int gcd(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return gcd(n, m % n);
        }
    }
}

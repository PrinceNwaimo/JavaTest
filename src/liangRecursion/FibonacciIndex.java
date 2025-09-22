package liangRecursion;

import java.util.Scanner;

public class FibonacciIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an index: ");
        int n = scanner.nextInt();
        scanner.close();

        long startTime = System.nanoTime();
        long fib = fib(n);
        long endTime = System.nanoTime();

        System.out.println("Fibonacci number at index " + n + " is: " + fib);
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
    }

    public static long fib(int n) {
        if (n <= 1) {
            return n;
        }

        long f0 = 0;
        long f1 = 1;
        long currentFib = 0;

        for (int i = 2; i <= n; i++) {
            currentFib = f0 + f1;
            f0 = f1;
            f1 = currentFib;
        }

        return currentFib;
    }
}

package diettelArrays;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        scanner.close();

        long startTime = System.currentTimeMillis();
        long fibonacciNumber = fibonacci(n);
        long endTime = System.currentTimeMillis();

        if (fibonacciNumber == Long.MAX_VALUE) {
            System.out.println("The Fibonacci number is too large to be represented as a long.");
        } else {
            System.out.println("The " + n + "th Fibonacci number is: " + fibonacciNumber);
            System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
        }
    }

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        long[] fib = new long[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (Long.MAX_VALUE - fib[i - 1] < fib[i - 2]) {
                return Long.MAX_VALUE; // overflow
            }
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }

}

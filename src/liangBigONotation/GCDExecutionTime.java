package liangBigONotation;

public class GCDExecutionTime {
    public static void main(String[] args) {
        System.out.println("Index\tListing 22.3 GCD\tListing 22.4 GCD Euclid");
        for (int i = 40; i <= 45; i++) {
            long fib1 = fib(i);
            long fib2 = fib(i + 1);

            // Measure execution time for Listing 22.3 GCD
            long startTime1 = System.currentTimeMillis();
            gcd(fib1, fib2);
            long endTime1 = System.currentTimeMillis();
            long executionTime1 = endTime1 - startTime1;

            // Measure execution time for Listing 22.4 GCD Euclid
            long startTime2 = System.currentTimeMillis();
            gcdEuclid(fib1, fib2);
            long endTime2 = System.currentTimeMillis();
            long executionTime2 = endTime2 - startTime2;

            System.out.println(i + "\t" + executionTime1 + " ms\t\t" + executionTime2 + " ms");
        }
    }

    // Method to calculate Fibonacci number
    public static long fib(long n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // Method to calculate GCD using Listing 22.3 algorithm
    public static long gcd(long m, long n) {
        long gcd = 1;
        for (long k = 2; k <= m && k <= n; k++) {
            if (m % k == 0 && n % k == 0) {
                gcd = k;
            }
        }
        return gcd;
    }

    // Method to calculate GCD using Listing 22.4 Euclid algorithm
    public static long gcdEuclid(long m, long n) {
        if (m % n == 0) {
            return n;
        } else {
            return gcdEuclid(n, m % n);
        }
    }
}

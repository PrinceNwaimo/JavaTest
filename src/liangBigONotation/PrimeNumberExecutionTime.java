package liangBigONotation;

public class PrimeNumberExecutionTime {
    public static void main(String[] args) {
        int[] numbers = {8000000, 10000000, 12000000, 14000000, 16000000, 18000000};

        System.out.println("Number\tListing 22.5\tListing 22.6\tListing 22.7");
        for (int number : numbers) {
            long startTime, endTime;

            // Listing 22.5
            startTime = System.currentTimeMillis();
            primeNumbersListing22_5(number);
            endTime = System.currentTimeMillis();
            long time22_5 = endTime - startTime;

            // Listing 22.6
            startTime = System.currentTimeMillis();
            primeNumbersListing22_6(number);
            endTime = System.currentTimeMillis();
            long time22_6 = endTime - startTime;

            // Listing 22.7
            startTime = System.currentTimeMillis();
            primeNumbersListing22_7(number);
            endTime = System.currentTimeMillis();
            long time22_7 = endTime - startTime;

            System.out.println(number + "\t" + time22_5 + "ms\t" + time22_6 + "ms\t" + time22_7 + "ms");
        }
    }

    // Algorithm in Listing 22.5
    public static void primeNumbersListing22_5(int n) {
        boolean[] primes = new boolean[n + 1];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }
        primes[0] = primes[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
    }

    // Algorithm in Listing 22.6
    public static void primeNumbersListing22_6(int n) {
        boolean[] primes = new boolean[n + 1];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }
        primes[0] = primes[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i + i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
    }

    // Algorithm in Listing 22.7
    public static void primeNumbersListing22_7(int n) {
        boolean[] primes = new boolean[n + 1];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }
        primes[0] = primes[1] = false;
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                for (int j = i + i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
    }
}

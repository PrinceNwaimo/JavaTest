package liang5;

public class PrimeNumbers {
    public static void main(String[] args) {
        final int NUMBER_OF_PRIMES_PER_LINE = 8;  // Display 8 per line
        int count = 0;  // Count the number of prime numbers found

        // Loop through numbers from 2 to 1,000
        for (int number = 2; number <= 1000; number++) {
            if (isPrime(number)) {  // Check if the number is prime
                count++;  // Increment the count of prime numbers
                System.out.print(number + " ");

                // Print a new line after every 8 prime numbers
                if (count % NUMBER_OF_PRIMES_PER_LINE == 0) {
                    System.out.println();
                }
            }
        }
    }
    public static boolean isPrime(int number) {
        // Prime numbers are greater than 1
        if (number <= 1) return false;

        // Check divisibility up to the square root of the number
        for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
            if (number % divisor == 0) {  // If divisible, not prime
                return false;
            }
        }
        return true;  // Prime if no divisors were found
    }
}


package liangBigONotation;

import java.io.*;

public class PrimeNumbers {
    private static final String FILE_NAME = "PrimeNumbers.dat";
    private static final int BUFFER_SIZE = 10000;

    public static void main(String[] args) throws IOException {
        File file = new File(FILE_NAME);
        long start = 2;
        long[] primes = new long[0];

        if (file.exists() && file.length() > 0) {
            primes = readPrimesFromFile();
            start = primes[primes.length - 1] + 1;
        }

        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(FILE_NAME, true))) {
            if (primes.length > 0) {
                for (long prime : primes) {
                    output.writeLong(prime);
                }
            }
            for (long i = start; i <= 10000000000L; i++) {
                if (isPrime(i, primes)) {
                    output.writeLong(i);
                    primes = append(primes, i);
                    if (primes.length % BUFFER_SIZE == 0) {
                        System.out.println("Found " + primes.length + " prime numbers so far...");
                    }
                }
            }
        }
    }

    private static long[] readPrimesFromFile() throws IOException {
        try (DataInputStream input = new DataInputStream(new FileInputStream(FILE_NAME))) {
            int fileSize = (int) new File(FILE_NAME).length();
            int primeCount = fileSize / 8; // Each long is 8 bytes
            long[] primes = new long[primeCount];

            for (int i = 0; i < primeCount; i++) {
                primes[i] = input.readLong();
            }

            return primes;
        }
    }

    private static boolean isPrime(long number, long[] primes) {
        for (long prime : primes) {
            if (prime * prime > number) {
                break;
            }
            if (number % prime == 0) {
                return false;
            }
        }
        return true;
    }

    private static long[] append(long[] array, long value) {
        long[] newArray = new long[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = value;
        return newArray;
    }
}

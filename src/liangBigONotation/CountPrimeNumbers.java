package liangBigONotation;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class CountPrimeNumbers {
    public static void main(String[] args) throws IOException {
        long[] numbers = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L};

        try (DataInputStream input = new DataInputStream(new FileInputStream("PrimeNumbers.dat"))) {
            long primeCount = 0;
            long currentPrime;

            while (input.available() > 0) {
                currentPrime = input.readLong();
                for (long number : numbers) {
                    if (currentPrime <= number) {
                        System.out.println("Number of prime numbers less than or equal to " + number + ": " + primeCount);
                        numbers = removeNumber(numbers, number);
                    }
                }
                primeCount++;
            }

            // Print the remaining numbers
            for (long number : numbers) {
                System.out.println("Number of prime numbers less than or equal to " + number + ": " + primeCount);
            }
        }
    }

    private static long[] removeNumber(long[] array, long number) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return array;
        }

        long[] newArray = new long[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        return newArray;
    }
}

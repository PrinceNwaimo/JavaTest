package diettelGenerics;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PrimeNumbersAndFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a whole number: ");
        int number = scanner.nextInt();

        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            Set<Integer> primeFactors = primeFactors(number);
            System.out.println(number + " is not a prime number. Its prime factors are: " + primeFactors);
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static Set<Integer> primeFactors(int number) {
        Set<Integer> primeFactors = new HashSet<>();
        for (int i = 2; i <= number; i++) {
            while (number % i == 0) {
                primeFactors.add(i);
                number /= i;
            }
        }
        return primeFactors;
    }
}

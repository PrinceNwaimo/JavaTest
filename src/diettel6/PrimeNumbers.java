package diettel6;

public class PrimeNumbers {
    public static void main(String[] args) {
        int limit = 10000;
        System.out.println("Prime numbers less than " + limit + ":");
        int count = 0;
        for (int i = 2; i < limit; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println("\nTotal prime numbers: " + count);
    }

    // Method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}

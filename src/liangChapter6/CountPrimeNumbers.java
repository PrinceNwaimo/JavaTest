package liangChapter6;

public class CountPrimeNumbers {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 2; i < 10000; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        System.out.println("The number of prime numbers less than 10000 is: " + count);
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

}

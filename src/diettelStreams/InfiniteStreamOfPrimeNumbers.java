package diettelStreams;
import java.util.Scanner;
import java.util.stream.IntStream;

public class InfiniteStreamOfPrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of prime numbers to display: ");
        int n = scanner.nextInt();

        IntStream.iterate(2, i -> i + 1)
                .filter(InfiniteStreamOfPrimeNumbers::isPrime)
                .limit(n)
                .forEach(System.out::println);
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(i -> number % i == 0);
    }
}

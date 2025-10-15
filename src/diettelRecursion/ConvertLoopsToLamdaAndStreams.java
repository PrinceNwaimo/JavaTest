package diettelRecursion;

import java.util.stream.IntStream;

public class ConvertLoopsToLamdaAndStreams {
    public static void main(String[] args) {
        // Calculate factorials
        System.out.println("Factorials:");
        IntStream.rangeClosed(1, 10).forEach(i -> System.out.printf("%d! = %d%n", i, factorial(i)));

        // Calculate Fibonacci numbers
        System.out.println("\nFibonacci numbers:");
        IntStream.rangeClosed(0, 10).forEach(i -> System.out.printf("Fibonacci(%d) = %d%n", i, fibonacci(i)));
    }

    public static long factorial(long number) {
        if (number <= 1) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }

    public static long fibonacci(long number) {
        if (number <= 1) {
            return number;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }
}

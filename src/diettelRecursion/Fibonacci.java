package diettelRecursion;

import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.printf("Fibonacci(%d) = %d%n", i, fibonacci(i));
        }
    }

    public static long fibonacci(int number) {
        if (number < 0) {
            throw new ArithmeticException("Fibonacci is not defined for negative numbers");
        }
        return Stream.iterate(new long[]{0, 1}, t -> new long[]{t[1], t[0] + t[1]})
                .limit(number + 1)
                .map(t -> t[0])
                .reduce((a, b) -> b)
                .orElse(0L);
    }
}

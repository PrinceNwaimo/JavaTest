package diettelRecursion;

import java.util.stream.LongStream;

public class Factorial2 {
    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++) {
            System.out.printf("%d! = %d%n", i, factorial(i));
        }
    }

    public static long factorial(long number) {
        if (number < 0) {
            throw new ArithmeticException("Factorial is not defined for negative numbers");
        }
        return LongStream.rangeClosed(1, number)
                .reduce(1, (a, b) -> a * b);
    }
}

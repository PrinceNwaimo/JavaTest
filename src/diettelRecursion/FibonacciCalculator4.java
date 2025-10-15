package diettelRecursion;

public class FibonacciCalculator4 {
    private static void main(String[] args) {
        int number = 40;
        long startTime = System.currentTimeMillis();
        long result = fibonacci(number);
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;

        System.out.printf("Fibonacci(%d) = %d%n", number, result);
        System.out.printf("Time taken: %d milliseconds%n", timeElapsed);
        System.out.printf("Number of calls: %d%n", getCallCount());
        resetCallCount();
    }

    private static long fibonacci(long number) {
        incrementCallCount();
        if (number <= 1) {
            return number;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }

    private static long callCount = 0;

    private static void incrementCallCount() {
        callCount++;
    }

    private static long getCallCount() {
        return callCount;
    }

    private static void resetCallCount() {
        callCount = 0;
    }
}

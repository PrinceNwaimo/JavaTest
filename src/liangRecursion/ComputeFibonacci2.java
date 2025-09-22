package liangRecursion;

public class ComputeFibonacci2 {
    private static int count = 0;

    public static void main(String[] args) {
        int index = 10; // Change this to test different indices
        long startTime = System.nanoTime();
        long fib = fib(index);
        long endTime = System.nanoTime();

        System.out.println("Fibonacci number at index " + index + " is: " + fib);
        System.out.println("Number of times fib method is called: " + count);
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
    }

    public static long fib(int index) {
        count++;
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            return fib(index - 1) + fib(index - 2);
        }
    }
}

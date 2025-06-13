package liangChapter6;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(9)); // Output: 3.0
        System.out.println(sqrt(16)); // Output: 4.0
        System.out.println(sqrt(25)); // Output: 5.0
    }

    public static double sqrt(long n) {
        if (n < 0) {
            throw new ArithmeticException("Square root of negative numbers is not supported");
        }

        double lastGuess = 1;
        double nextGuess = (lastGuess + n / lastGuess) / 2;

        while (Math.abs(nextGuess - lastGuess) > 0.0001) {
            lastGuess = nextGuess;
            nextGuess = (lastGuess + n / lastGuess) / 2;
        }

        return nextGuess;
    }

}

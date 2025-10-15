package diettelRecursion;

public class EulerNumbers {
    public static void main(String[] args) {
        int n = 10; // Change this value to increase or decrease precision
        double e = calculateEuler(n);
        System.out.println("Euler's number (approximated to " + n + " terms): " + e);
    }

    public static double calculateEuler(int n) {
        return calculateEulerHelper(n, 1.0);
    }

    private static double calculateEulerHelper(int n, double sum) {
        if (n == 0) {
            return sum;
        } else {
            return calculateEulerHelper(n - 1, sum + 1.0 / factorial(n));
        }
    }

    private static double factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}

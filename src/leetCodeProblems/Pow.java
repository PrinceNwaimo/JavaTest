package leetCodeProblems;

public class Pow {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1.0 / power(x, -n);
        } else {
            return power(x, n);
        }
    }

    public double power(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double v = power(x, n / 2);
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }

    public static void main(String[] args) {
        Pow pow = new Pow();

        // Test cases
        System.out.println("2^10 = " + pow.myPow(2.0, 10));   // 1024.0
        System.out.println("2^-2 = " + pow.myPow(2.0, -2));   // 0.25
        System.out.println("0^0 = " + pow.myPow(0.0, 0));     // 1.0
        System.out.println("3^4 = " + pow.myPow(3.0, 4));     // 81.0
    }
}

package diettel4;

import java.util.Scanner;

public class CalculateEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the value of x:");
        double x = scanner.nextDouble();

        System.out.println("Enter the number of terms to calculate:");
        int terms = scanner.nextInt();

        double ex = 0;
        int i = 0;
        while (i <= terms) {
            ex += Math.pow(x, i) / factorial(i);
            i++;
        }

        System.out.println("Value of e^" + x + " is: " + ex);
    }

    public static long factorial(int n) {
        long result = 1;
        int i = 1;
        while (i <= n) {
            result *= i;
            i++;
        }
        return result;
    }

}

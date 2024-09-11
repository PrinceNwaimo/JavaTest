package diettel4;

import java.util.Scanner;

public class EstimateE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of terms to calculate:");
        int terms = scanner.nextInt();

        double e = 0;
        int i = 0;
        while (i <= terms) {
            e += 1.0 / factorial(i);
            i++;
        }

        System.out.println("Estimated value of e is: " + e);
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

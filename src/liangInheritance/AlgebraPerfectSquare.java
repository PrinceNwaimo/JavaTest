package liangInheritance;

import java.util.ArrayList;
import java.util.Scanner;

public class AlgebraPerfectSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer m: ");
        int m = scanner.nextInt();
        ArrayList<Integer> factors = new ArrayList<>();
        int temp = m;
        for (int i = 2; i * i <= temp; i++) {
            while (temp % i == 0) {
                factors.add(i);
                temp /= i;
            }
        }
        if (temp > 1) {
            factors.add(temp);
        }
        int n = 1;
        for (int factor : factors) {
            int count = countFactor(factors, factor);
            if (count % 2 != 0) {
                n *= factor;
            }
        }
        System.out.println("The smallest number n for m * n to be a perfect square is " + n);
        System.out.println("m * n is " + m * n);
    }

    public static int countFactor(ArrayList<Integer> factors, int factor) {
        int count = 0;
        for (int f : factors) {
            if (f == factor) {
                count++;
            }
        }
        return count;
    }
}

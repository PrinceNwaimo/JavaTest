package liang5;

import java.util.Scanner;

public class SmallestFactors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        int factor = 2;

        System.out.print("Smallest factors: ");

        while (number > 1) {
            // Check if 'factor' is a factor of 'number'
            if (number % factor == 0) {
                System.out.print(factor);
                number /= factor; // Divide the number by the found factor
                if (number > 1) {
                    System.out.print(", ");
                }
            } else {
                factor++; // Increment to check the next potential factor
            }
        }
    }
}

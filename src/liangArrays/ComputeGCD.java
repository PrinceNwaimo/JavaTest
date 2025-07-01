package liangArrays;

import java.util.Scanner;

public class ComputeGCD {
    public static int gcd(int... numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = gcdTwoNumbers(result, numbers[i]);
        }
        return result;
    }

    private static int gcdTwoNumbers(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a); // Ensure GCD is positive
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.print("Enter five numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        int gcdResult = gcd(numbers);
        System.out.println("The GCD is: " + gcdResult);
    }

}

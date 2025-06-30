package liangArrays;

import java.util.Scanner;

public class FindSmallestElement {
    public static double min(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10];

        System.out.print("Enter ten numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextDouble();
        }

        double minValue = min(numbers);
        System.out.println("The minimum number is: " + minValue);
    }

}

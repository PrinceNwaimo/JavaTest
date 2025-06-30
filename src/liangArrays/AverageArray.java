package liangArrays;

import java.util.Scanner;

public class AverageArray {
    public static int average(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum / array.length;
    }

    public static double average(double[] array) {
        double sum = 0;
        for (double value : array) {
            sum += value;
        }
        return sum / array.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] values = new double[10];

        System.out.println("Enter ten double values:");
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextDouble();
        }

        double averageValue = average(values);
        System.out.println("The average value is: " + averageValue);
    }

}

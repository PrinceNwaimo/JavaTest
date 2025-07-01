package liangArrays;

import java.util.Scanner;

public class ComputeDeviation {
    public static double mean(double[] x) {
        double sum = 0;
        for (double value : x) {
            sum += value;
        }
        return sum / x.length;
    }

    public static double deviation(double[] x) {
        double meanValue = mean(x);
        double sumOfSquares = 0;
        for (double value : x) {
            sumOfSquares += Math.pow(value - meanValue, 2);
        }
        return Math.sqrt(sumOfSquares / (x.length - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10];

        System.out.print("Enter ten numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextDouble();
        }

        double meanValue = mean(numbers);
        double deviationValue = deviation(numbers);

        System.out.printf("The mean is %.2f%n", meanValue);
        System.out.printf("The standard deviation is %.5f%n", deviationValue);
    }

}

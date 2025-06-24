package joyceArrays;

import java.util.Scanner;

public class DistanceFromAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[15];
        int count = 0;
        double sum = 0;

        System.out.println("Enter up to 15 double values (enter 99999 to quit):");

        while (count < numbers.length) {
            System.out.print("Enter a value: ");
            double value = scanner.nextDouble();

            if (value == 99999) {
                break;
            }

            numbers[count] = value;
            sum += value;
            count++;
        }

        if (count == 0) {
            System.out.println("Error: No numbers were entered.");
        } else {
            double average = sum / count;

            System.out.println("You entered the following values:");
            for (int i = 0; i < count; i++) {
                double distance = Math.abs(numbers[i] - average);
                System.out.println(numbers[i] + " is " + distance + " away from the average of " + average);
            }
        }

        scanner.close();
    }

}

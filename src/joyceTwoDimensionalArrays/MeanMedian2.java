package joyceTwoDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MeanMedian2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[20];
        int count = 0;

        System.out.println("Enter integers (up to 20):");
        while (count < 20) {
            System.out.print("Enter number (or -1 to finish): ");
            int input = scanner.nextInt();
            if (input == -1) {
                break;
            }
            numbers[count] = input;
            count++;
        }

        int[] trimmedNumbers = Arrays.copyOf(numbers, count);
        Arrays.sort(trimmedNumbers);

        System.out.println("Numbers:");
        for (int num : trimmedNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        double mean = calculateMean(trimmedNumbers);
        double median = calculateMedian(trimmedNumbers);

        System.out.println("Mean: " + mean);
        System.out.println("Median: " + median);
    }

    public static double calculateMean(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }

    public static double calculateMedian(int[] numbers) {
        int length = numbers.length;
        if (length % 2 == 0) {
            return (numbers[length / 2 - 1] + numbers[length / 2]) / 2.0;
        } else {
            return numbers[length / 2];
        }
    }

}

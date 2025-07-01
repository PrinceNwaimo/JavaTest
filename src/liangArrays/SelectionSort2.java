package liangArrays;

import java.util.Scanner;

public class SelectionSort2 {
    public static void selectionSort(double[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            // Swap array[maxIndex] and array[i]
            double temp = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void printArray(double[] array) {
        for (double value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10];

        System.out.print("Enter ten numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextDouble();
        }

        System.out.println("Original numbers:");
        printArray(numbers);

        selectionSort(numbers);

        System.out.println("Sorted numbers:");
        printArray(numbers);
    }

}

package liangArrays;

import java.util.Scanner;

public class FindSmallestIndex {
    public static int indexOfSmallestElement(double[] array) {
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10];

        System.out.print("Enter ten numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextDouble();
        }

        int minIndex = indexOfSmallestElement(numbers);
        System.out.println("The index of the smallest element is: " + minIndex);
    }

}

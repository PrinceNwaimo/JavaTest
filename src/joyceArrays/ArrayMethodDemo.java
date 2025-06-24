package joyceArrays;

public class ArrayMethodDemo {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80};

        displayNumbers(numbers);
        displayReverse(numbers);
        displaySum(numbers);
        displayLessThan(numbers, 50);
        displayAboveAverage(numbers);
    }

    public static void displayNumbers(int[] numbers) {
        System.out.println("The numbers are:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static void displayReverse(int[] numbers) {
        System.out.println("The numbers in reverse order are:");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    public static void displaySum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("The sum of the numbers is: " + sum);
    }

    public static void displayLessThan(int[] numbers, int limit) {
        System.out.println("The numbers less than " + limit + " are:");
        for (int number : numbers) {
            if (number < limit) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    public static void displayAboveAverage(int[] numbers) {
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        double average = sum / numbers.length;
        System.out.println("The numbers above the average (" + average + ") are:");
        for (int number : numbers) {
            if (number > average) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

}

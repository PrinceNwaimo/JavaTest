package joyceArrays;

public class NineInts {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80, 90};

        System.out.println("Integers from first to last:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println("\n\nIntegers from last to first:");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
    }
}

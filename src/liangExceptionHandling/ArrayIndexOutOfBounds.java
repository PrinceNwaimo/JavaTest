package liangExceptionHandling;

import java.util.Random;
import java.util.Scanner;

public class ArrayIndexOutOfBounds {
    public static void main(String[] args) {
        int[] array = new int[100];
        Random random = new Random();

        // Initialize the array with random integers
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000); // Random integers between 0 and 999
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter the index of the array (or -1 to exit): ");
                int index = scanner.nextInt();

                if (index == -1) {
                    break;
                }

                System.out.println("Element at index " + index + ": " + array[index]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Out of Bounds");
            }
        }
    }
}

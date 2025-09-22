package liangRecursion;

import java.util.Scanner;

public class FindLargest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[8];

        System.out.println("Enter eight integers:");
        for (int i = 0; i < 8; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();

        int largest = findLargest(array, 0);
        System.out.println("The largest element is: " + largest);
    }

    public static int findLargest(int[] array, int index) {
        if (index == array.length - 1) {
            return array[index];
        } else {
            return Math.max(array[index], findLargest(array, index + 1));
        }
    }
}

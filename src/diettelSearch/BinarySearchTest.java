package diettelSearch;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTest {
    public static int binarySearch(int[] data, int key) {
        int low = 0; // low end of the search area
        int high = data.length - 1; // high end of the search area
        int middle = (low + high + 1) / 2; // middle element
        int location = -1;

        do {
            System.out.print(remainingElements(data, low, high));
            for (int i = 0; i < middle; i++) {
                System.out.print(" ");
            }
            System.out.println(" * ");

            if (key == data[middle]) {
                location = middle;
            } else if (key < data[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
            middle = (low + high + 1) / 2;
        } while ((low <= high) && (location == -1));
        return location;
    }

    private static String remainingElements(int[] data, int low, int high) {
        StringBuilder temporary = new StringBuilder();
        for (int i = 0; i < low; i++) {
            temporary.append(" ");
        }
        for (int i = low; i <= high; i++) {
            temporary.append(data[i] + " ");
        }
        return String.format("%s%n", temporary);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SecureRandom generator = new SecureRandom();
        int[] data = generator.ints(15, 10, 91).sorted().toArray();
        System.out.printf("%s%n%n", Arrays.toString(data));
        System.out.print("Please enter an integer value(-1 to quit): ");
        int searchInt = input.nextInt();
        while (searchInt != -1) {
            int location = binarySearch(data, searchInt);

            if (location == -1) {
                System.out.printf("%d was not found%n%n", searchInt);
            } else {
                System.out.printf("%d was found in position %d%n%n", searchInt, location);
            }
            System.out.println("Please enter an integer value(-1 to quit): ");
            searchInt = input.nextInt();
        }
    }
}

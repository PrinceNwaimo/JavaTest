package liangArrays;

import java.util.Arrays;
import java.util.Random;

public class SearchExecutionTime {
    public static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < array[mid]) {
                high = mid - 1;
            } else if (key == array[mid]) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[100000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000000);
        }
        int key = array[random.nextInt(array.length)];

        // Linear search
        long startTime = System.nanoTime();
        int linearSearchResult = linearSearch(array, key);
        long endTime = System.nanoTime();
        long linearExecutionTime = endTime - startTime;

        // Sort the array
        Arrays.sort(array);

        // Binary search
        startTime = System.nanoTime();
        int binarySearchResult = binarySearch(array, key);
        endTime = System.nanoTime();
        long binaryExecutionTime = endTime - startTime;

        System.out.println("Linear search result: " + linearSearchResult);
        System.out.println("Linear search execution time: " + linearExecutionTime + " nanoseconds");
        System.out.println("Binary search result: " + binarySearchResult);
        System.out.println("Binary search execution time: " + binaryExecutionTime + " nanoseconds");
        System.out.println("Sorting execution time: ");
        startTime = System.nanoTime();
        Arrays.sort(array);
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) + " nanoseconds");
    }

}

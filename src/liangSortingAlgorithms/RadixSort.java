package liangSortingAlgorithms;

import java.util.Random;

public class RadixSort {
    public static void main(String[] args) {
        int[] array = new int[1_000_000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1_000_000);
        }

        long startTime = System.currentTimeMillis();
        radixSort(array);
        long endTime = System.currentTimeMillis();

        System.out.println("Time taken: " + (endTime - startTime) + " ms");

        // Verify the sorted array
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                System.out.println("Array is not sorted");
                return;
            }
        }
        System.out.println("Array is sorted");
    }

    public static void radixSort(int[] array) {
        int max = getMax(array);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    private static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static void countingSort(int[] array, int exp) {
        int[] output = new int[array.length];
        int[] count = new int[10];

        for (int i = 0; i < array.length; i++) {
            count[(array[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, array, 0, array.length);
    }
}

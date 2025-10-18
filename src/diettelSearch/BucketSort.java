package diettelSearch;

import java.util.Arrays;

public class BucketSort {
    public static void sort(int[] array) {
        if (array.length == 0) {
            return;
        }

        // Determine the maximum number to know the number of digits
        int max = Arrays.stream(array).max().getAsInt();
        int digitCount = String.valueOf(max).length();

        // Initialize buckets
        int[][] buckets = new int[10][array.length];
        int[] bucketSizes = new int[10];

        for (int digitPosition = 1; digitPosition <= digitCount; digitPosition++) {
            // Distribution pass
            for (int num : array) {
                int digit = getDigit(num, digitPosition);
                buckets[digit][bucketSizes[digit]++] = num;
            }

            // Gathering pass
            int index = 0;
            for (int bucketIndex = 0; bucketIndex < 10; bucketIndex++) {
                for (int i = 0; i < bucketSizes[bucketIndex]; i++) {
                    array[index++] = buckets[bucketIndex][i];
                }
                // Reset bucket size for next iteration
                bucketSizes[bucketIndex] = 0;
            }
        }
    }

    // Helper method to extract the digit at the specified position
    private static int getDigit(int number, int position) {
        return (number / (int) Math.pow(10, position - 1)) % 10;
    }

    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original array:");
        printArray(array);
        sort(array);
        System.out.println("Sorted array:");
        printArray(array);
    }
}
//How it works:
//
//        1. Determine max digits: Find the maximum number to determine the number of digits (digitCount).
//        2. Distribution pass: For each digit position, distribute elements into buckets based on the digit value.
//        3. Gathering pass: Collect elements from buckets back into the original array, preserving order within buckets.
//        4. Repeat: Process each digit position (ones, tens, hundreds, etc.) until all digits are considered.
//
//Characteristics:
//
//        - Stable sort: Bucket Sort is stable, preserving order of equal elements.
//        - Space-time tradeoff: Uses extra space for buckets but can be faster than comparison-based sorts like Bubble Sort.
//- Efficiency: Performance depends on digit count and distribution; suitable for certain data patterns.
//
//        Considerations:
//
//        - Digit-based: Works well for integers with a manageable number of digits.
//- Memory usage: Requires significant extra memory for buckets.
//- Use cases: Applicable when data characteristics align with algorithm strengths.
//Bucket Sort demonstrates a non-comparison sorting approach, leveraging digit properties for sorting, distinct from comparison-based algorithms like QuickSort or MergeSort
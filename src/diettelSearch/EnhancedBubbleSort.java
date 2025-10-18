package diettelSearch;

public class EnhancedBubbleSort {
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int pass = 1; pass < n; pass++) {
            boolean swapped = false;
            // Reduce the number of comparisons in each pass
            for (int i = 0; i < n - pass; i++) {
                if (array[i] > array[i + 1]) {
                    // Swap array[i] and array[i + 1]
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps were made, the array is sorted
            if (!swapped) {
                System.out.println("Array is sorted after " + pass + " passes.");
                break;
            }
        }
    }

    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(array1);
        bubbleSort(array1);
        System.out.println("Sorted array:");
        printArray(array1);

        // Test with an already sorted array
        int[] array2 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("\nOriginal sorted array:");
        printArray(array2);
        bubbleSort(array2);
        System.out.println("Sorted array (should be same):");
        printArray(array2);
    }
}

package diettelSearch;

public class RecursiveInsertionSort {
    public static void insertionRecursiveSort(int[] array, int n) {
        // Base case: If array has 1 or no elements, it's sorted
        if (n <= 1) {
            return;
        }

        // Sort first n-1 elements recursively
        insertionRecursiveSort(array, n - 1);

        // Insert last element at its correct position
        int lastElement = array[n - 1];
        int j = n - 2;
        while (j >= 0 && array[j] > lastElement) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = lastElement;
    }

    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(array);
        insertionRecursiveSort(array, array.length);
        System.out.println("Sorted array:");
        printArray(array);
    }
}
// How it works:
//
//1. Base case: Recursion stops when n <= 1, indicating the array portion is trivially sorted.
//2. Recursive sorting: Sorts the first n-1 elements recursively.
//3. Insertion step: Inserts the n-th element (lastElement) into its correct position among the previously sorted elements.
//
//Characteristics:
//
//- Stable sort: Recursive Insertion Sort preserves order of equal elements.
//- Time complexity: O(n^2) in worst case; O(n) for already sorted arrays.
//- Space complexity: O(n) due to recursive call stack.
//
//Considerations:
//
//- Efficiency: Not optimal for large datasets compared to O(n log n) algorithms.
//- Adaptability: Performs well on nearly sorted or small arrays.
//- Educational: Illustrates recursion applied to sorting.
//
//Advantages over Bubble Sort:
//- Generally more efficient: Insertion Sort (recursive or iterative) often outperforms Bubble Sort.
//- Adaptive: Benefits from partially sorted input.
//
//Like other Insertion Sort variants, this recursive implementation is more of educational interest and suited for specific scenarios rather than general-purpose large-scale sorting //
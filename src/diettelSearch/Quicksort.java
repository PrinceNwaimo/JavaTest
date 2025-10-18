package diettelSearch;

public class Quicksort {
    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSortHelper(array, low, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low + 1;
        int j = high;

        while (true) {
            // Find element greater than pivot from left
            while (i <= j && array[i] <= pivot) {
                i++;
            }
            // Find element less than pivot from right
            while (i <= j && array[j] > pivot) {
                j--;
            }
            // If pointers crossed, exit loop
            if (i >= j) {
                break;
            }
            // Swap elements at i and j
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        // Swap pivot with element at j (its final position)
        int temp = array[low];
        array[low] = array[j];
        array[j] = temp;
        return j;
    }

    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {37, 2, 6, 4, 89, 8, 10, 12, 68, 45};
        System.out.println("Original array:");
        printArray(array);
        quickSort(array);
        System.out.println("Sorted array:");
        printArray(array);
    }
}
// How it works:
//
//1. Partitioning: partition method rearranges elements so pivot (array[low]) is in final sorted position.
//2. Recursive sorting: quickSortHelper recursively sorts subarrays left and right of pivot.
//3. Base case: Recursion stops when low >= high, indicating subarray is sorted.
//
//Characteristics:
//
//- Average time complexity: O(n log n); worst case O(n^2) (e.g., already sorted array with poor pivot choice).
//- Space complexity: O(log n) for recursive stack in average case.
//- Not stable: Quicksort isn't inherently stable; equal elements' order might change.
//
//Considerations:
//
//- Pivot selection: Impacts performance; strategies like median-of-three help mitigate worst cases.
//- Performance: Generally fast; widely used with optimizations.
//- Worst-case scenarios: Can occur with poor pivot choices or specific data patterns.
//
//Quicksort is a popular sorting algorithm due to its average-case efficiency, though implementations must address potential pitfalls like worst-case performance//
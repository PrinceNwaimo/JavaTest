package diettelSearch;

public class RecursiveBubbleSort {
    public static void recursiveBubbleSort(int[] array, int n) {
        // Base case: If there's 1 or no element left, it's sorted
        if (n == 1) {
            return;
        }

        // Perform one pass of bubble sort
        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                // Swap array[i] and array[i + 1]
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }

        // Largest element is now at the end, recurse with reduced n
        recursiveBubbleSort(array, n - 1);
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
        recursiveBubbleSort(array, array.length);
        System.out.println("Sorted array:");
        printArray(array);
    }
}
//How it works:
//
//1. Base case: Recursion stops when n == 1, indicating the array portion is sorted.
//2. One pass: Performs a bubble sort pass, bubbling the largest unsorted element to the end.
//3. Recursive call: Calls itself with n-1, effectively fixing the largest element's position and reducing problem size.
//
//Characteristics:
//
//- Recursive approach: Uses function calls to manage sorting iterations.
//- Time complexity: O(n^2) like iterative Bubble Sort; not efficient for large datasets.
//- Space complexity: O(n) due to recursive call stack.
//
//Considerations:
//
//- Not tail-recursive: Might lead to stack overflow for very large arrays if not optimized by compiler/JVM.
//- Educational value: Demonstrates recursion application to sorting.
//- Practicality: Generally outperformed by other sorting algorithms; not typically used in production.
//
//Recursive Bubble Sort illustrates applying recursion to a sorting problem but shares Bubble Sort's inherent inefficiencies, making it less suitable for real-world large-scale sorting tasks//
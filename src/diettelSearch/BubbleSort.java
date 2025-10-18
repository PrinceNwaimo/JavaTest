package diettelSearch;

public class BubbleSort {
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int pass = 1; pass < n; pass++) {
            boolean swapped = false;
            for (int i = 0; i < n - pass; i++) {
                if (array[i] > array[i + 1]) {
                    // Swap array[i] and array[i + 1]
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps were made in a pass, the array is sorted
            if (!swapped) {
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
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(array);
        bubbleSort(array);
        System.out.println("Sorted array:");
        printArray(array);
    }
}
//Why Bubble Sort is O(n^2):
//        1. Nested Loops: Bubble Sort uses two nested loops. The outer loop (pass) iterates n-1 times, where n is the number of elements.
//2. Inner Loop Comparisons: The inner loop compares adjacent elements, iterating n-pass times in each pass.
//3. Total Comparisons: In the worst case (when the array is reverse sorted), the total number of comparisons is proportional to the sum of the first n-1 natural numbers: (n-1) + (n-2) + ... + 1 = n(n-1)/2, which simplifies to O(n^2).
//        4. Swaps: In the worst case, the number of swaps is also O(n^2), contributing to the overall time complexity.
//
//Characteristics:
//
//        - Inefficient for large datasets: Due to its O(n^2) time complexity, Bubble Sort is not suitable for sorting large arrays.
//- Simple to implement: Bubble Sort is one of the simplest sorting algorithms to understand and code.
//- Adaptive: The implementation above includes an optimization (swapped flag) that allows it to terminate early if the array is already sorted, making it more efficient for nearly sorted data.
//Bubble Sort is primarily used for educational purposes or small datasets where simplicity is more important than performance[1][2].
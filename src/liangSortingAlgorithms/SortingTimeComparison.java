package liangSortingAlgorithms;

import java.util.Random;

public class SortingTimeComparison {
    public static void main(String[] args) {
        int[] sizes = {50_000, 100_000, 150_000, 200_000, 250_000, 300_000};
        System.out.println("Array size\tSelection Sort\tBubble Sort\tMerge Sort\tQuick Sort\tHeap Sort\tRadix Sort");
        for (int size : sizes) {
            int[] array = generateRandomArray(size);
            System.out.print(size + "\t");

            int[] selectionSortArray = array.clone();
            long startTime = System.currentTimeMillis();
            selectionSort(selectionSortArray);
            long endTime = System.currentTimeMillis();
            System.out.print((endTime - startTime) + " ms\t");

            int[] bubbleSortArray = array.clone();
            startTime = System.currentTimeMillis();
            bubbleSort(bubbleSortArray);
            endTime = System.currentTimeMillis();
            System.out.print((endTime - startTime) + " ms\t");

            int[] mergeSortArray = array.clone();
            startTime = System.currentTimeMillis();
            mergeSort(mergeSortArray);
            endTime = System.currentTimeMillis();
            System.out.print((endTime - startTime) + " ms\t");

            int[] quickSortArray = array.clone();
            startTime = System.currentTimeMillis();
            quickSort(quickSortArray);
            endTime = System.currentTimeMillis();
            System.out.print((endTime - startTime) + " ms\t");

            int[] heapSortArray = array.clone();
            startTime = System.currentTimeMillis();
            heapSort(heapSortArray);
            endTime = System.currentTimeMillis();
            System.out.print((endTime - startTime) + " ms\t");

            int[] radixSortArray = array.clone();
            startTime = System.currentTimeMillis();
            radixSort(radixSortArray);
            endTime = System.currentTimeMillis();
            System.out.println((endTime - startTime) + " ms");
        }
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(Integer.MAX_VALUE); // ✅ Always ≥ 0
        }
        return array;
    }


    // Implementation of selection sort, bubble sort, merge sort, quick sort, heap sort, and radix sort
    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= high) {
            temp[k++] = array[j++];
        }
        System.arraycopy(temp, 0, array, low, temp.length);
    }

    private static void quickSort(int[] array) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(0);
        stack.push(array.length - 1);
        while (!stack.isEmpty()) {
            int high = stack.pop();
            int low = stack.pop();
            int pivotIndex = partition(array, low, high);
            if (pivotIndex - 1 > low) {
                stack.push(low);
                stack.push(pivotIndex - 1);
            }
            if (pivotIndex + 1 < high) {
                stack.push(pivotIndex + 1);
                stack.push(high);
            }
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    private static void heapSort(int[] array) {
        buildHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, 0, i);
        }
    }

    private static void buildHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, i, array.length);
        }
    }

    private static void heapify(int[] array, int index, int heapSize) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < heapSize && array[left] > array[largest]) {
            largest = left;
        }
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != index) {
            int temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;
            heapify(array, largest, heapSize);
        }
    }

    private static void radixSort(int[] array) {
        int min = getMin(array);
        if (min < 0) {
            // Shift all numbers to make them non-negative
            for (int i = 0; i < array.length; i++) {
                array[i] -= min;
            }
        }

        int max = getMax(array);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }

        if (min < 0) {
            // Shift back after sorting
            for (int i = 0; i < array.length; i++) {
                array[i] += min;
            }
        }
    }

    private static int getMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }



    private static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, array, 0, n);
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
}

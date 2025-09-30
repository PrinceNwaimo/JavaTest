package liangSortingAlgorithms;

import java.util.Comparator;

public class GenericHeapSort {
    public static void main(String[] args) {
        Integer[] list = {3, 5, 1, 9, 2, 8, 4, 7, 6};
        heapSort(list);
        System.out.println("Sorted list using Comparable:");
        printList(list);

        String[] stringList = {"hello", "world", "abc", "xyz", "java"};
        heapSort(stringList, (s1, s2) -> s1.length() - s2.length());
        System.out.println("Sorted list using Comparator:");
        printList(stringList);
    }

    public static <E extends Comparable<E>> void heapSort(E[] list) {
        heapSort(list, (e1, e2) -> e1.compareTo(e2));
    }

    public static <E> void heapSort(E[] list, Comparator<? super E> comparator) {
        // Build a heap
        for (int i = list.length / 2 - 1; i >= 0; i--) {
            heapify(list, i, list.length, comparator);
        }

        // Extract elements one by one
        for (int i = list.length - 1; i >= 0; i--) {
            // Move the current root to the end
            E temp = list[i];
            list[i] = list[0];
            list[0] = temp;

            // Call heapify on the reduced heap
            heapify(list, 0, i, comparator);
        }
    }

    private static <E> void heapify(E[] list, int index, int heapSize, Comparator<? super E> comparator) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < heapSize && comparator.compare(list[left], list[largest]) > 0) {
            largest = left;
        }

        if (right < heapSize && comparator.compare(list[right], list[largest]) > 0) {
            largest = right;
        }

        if (largest != index) {
            E temp = list[index];
            list[index] = list[largest];
            list[largest] = temp;

            heapify(list, largest, heapSize, comparator);
        }
    }

    private static <E> void printList(E[] list) {
        for (E element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

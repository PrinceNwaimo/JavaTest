package liangSortingAlgorithms;

import java.util.Comparator;

public class RevisedGenericQuickSort {
    public static void main(String[] args) {
        Integer[] list = {3, 5, 1, 9, 2, 8, 4, 7, 6};
        quickSort(list);
        System.out.println("Sorted list using Comparable:");
        printList(list);

        String[] stringList = {"hello", "world", "abc", "xyz", "java"};
        quickSort(stringList, (s1, s2) -> s1.length() - s2.length());
        System.out.println("Sorted list using Comparator:");
        printList(stringList);
    }

    public static <E extends Comparable<E>> void quickSort(E[] list) {
        quickSort(list, 0, list.length - 1, (e1, e2) -> e1.compareTo(e2));
    }

    public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
        quickSort(list, 0, list.length - 1, comparator);
    }

    private static <E> void quickSort(E[] list, int low, int high, Comparator<? super E> comparator) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, comparator);
            quickSort(list, low, pivotIndex - 1, comparator);
            quickSort(list, pivotIndex + 1, high, comparator);
        }
    }

    private static <E> int partition(E[] list, int low, int high, Comparator<? super E> comparator) {
        int mid = (low + high) / 2;
        int medianIndex = medianOfThree(list, low, mid, high, comparator);
        E pivot = list[medianIndex];

        // Swap the median element with the last element
        E temp = list[medianIndex];
        list[medianIndex] = list[high];
        list[high] = temp;

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(list[j], pivot) <= 0) {
                i++;
                temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
        temp = list[i + 1];
        list[i + 1] = list[high];
        list[high] = temp;
        return i + 1;
    }

    private static <E> int medianOfThree(E[] list, int low, int mid, int high, Comparator<? super E> comparator) {
        if (comparator.compare(list[low], list[mid]) > 0) {
            if (comparator.compare(list[mid], list[high]) > 0) {
                return mid;
            } else if (comparator.compare(list[low], list[high]) > 0) {
                return high;
            } else {
                return low;
            }
        } else {
            if (comparator.compare(list[low], list[high]) > 0) {
                return low;
            } else if (comparator.compare(list[mid], list[high]) > 0) {
                return high;
            } else {
                return mid;
            }
        }
    }

    private static <E> void printList(E[] list) {
        for (E element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

package liangSortingAlgorithms;

import java.util.Comparator;

public class GenericBubbleSort {
    public static void main(String[] args) {
        Integer[] list = {3, 5, 1, 9, 2, 8, 4, 7, 6};
        bubbleSort(list);
        System.out.println("Sorted list using Comparable:");
        printList(list);

        String[] stringList = {"hello", "world", "abc", "xyz", "java"};
        bubbleSort(stringList, (s1, s2) -> s1.length() - s2.length());
        System.out.println("Sorted list using Comparator:");
        printList(stringList);
    }

    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
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

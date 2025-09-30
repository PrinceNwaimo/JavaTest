package liangSortingAlgorithms;

import java.util.Comparator;

public class MinHeap {
    public static void main(String[] args) {
        int[] intList = {1, 2, 3, 4, 5};
        System.out.println("Is intList in ascending order? " + ordered(intList));
        System.out.println("Is intList in descending order? " + ordered(intList, false));

        double[] doubleList = {1.1, 2.2, 3.3, 4.4, 5.5};
        System.out.println("Is doubleList in ascending order? " + ordered(doubleList));
        System.out.println("Is doubleList in descending order? " + ordered(doubleList, false));

        String[] stringList = {"apple", "banana", "cherry", "date", "elderberry"};
        System.out.println("Is stringList in ascending order? " + ordered(stringList));
        System.out.println("Is stringList in descending order? " + ordered(stringList, false));

        Comparator<String> comparator = (s1, s2) -> s1.length() - s2.length();
        System.out.println("Is stringList in ascending order based on length? " + ordered(stringList, comparator));
        System.out.println("Is stringList in descending order based on length? " + ordered(stringList, comparator, false));
    }

    public static boolean ordered(int[] list) {
        return ordered(list, true);
    }

    public static boolean ordered(int[] list, boolean ascending) {
        for (int i = 0; i < list.length - 1; i++) {
            if ((ascending && list[i] > list[i + 1]) || (!ascending && list[i] < list[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public static boolean ordered(double[] list) {
        return ordered(list, true);
    }

    public static boolean ordered(double[] list, boolean ascending) {
        for (int i = 0; i < list.length - 1; i++) {
            if ((ascending && list[i] > list[i + 1]) || (!ascending && list[i] < list[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> boolean ordered(E[] list) {
        return ordered(list, true);
    }

    public static <E extends Comparable<E>> boolean ordered(E[] list, boolean ascending) {
        for (int i = 0; i < list.length - 1; i++) {
            if ((ascending && list[i].compareTo(list[i + 1]) > 0) || (!ascending && list[i].compareTo(list[i + 1]) < 0)) {
                return false;
            }
        }
        return true;
    }

    public static <E> boolean ordered(E[] list, Comparator<? super E> comparator) {
        return ordered(list, comparator, true);
    }

    public static <E> boolean ordered(E[] list, Comparator<? super E> comparator, boolean ascending) {
        for (int i = 0; i < list.length - 1; i++) {
            if ((ascending && comparator.compare(list[i], list[i + 1]) > 0) || (!ascending && comparator.compare(list[i], list[i + 1]) < 0)) {
                return false;
            }
        }
        return true;
    }
}

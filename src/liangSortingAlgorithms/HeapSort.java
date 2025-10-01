package liangSortingAlgorithms;

public class HeapSort {
    /**
     * Heap2 sort method
     */
    public static <E extends Comparable<E>> void heapSort(E[] list) {
        // Create a Heap2 of integers
        Heap2<E> heap = new Heap2<>();
        // Add elements to the heap
        for (int i = 0; i < list.length; i++)
            heap.add(list[i]);

        // Remove elements from the heap
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();
    }

    /**
     * A test method
     */
    public static void main(String[] args) {
        Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        heapSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}
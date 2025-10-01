package liangSortingAlgorithms;

import java.util.ArrayList;

public class SortHeap {
    public static void main(String[] args) {
        Integer[] list = {3, 5, 1, 9, 2, 8, 4, 7, 6};
        sort(list);
        System.out.println(java.util.Arrays.toString(list));
    }

    public static <E extends Comparable<E>> void sort(E[] list) {
        Heap2<E> heap = new Heap2<>();
        for (E element : list) {
            heap.add(element);
        }

        for (int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }
}

class Heap2<E extends Comparable<E>> {
    private ArrayList<E> list = new ArrayList<>();

    public void add(E newItem) {
        list.add(newItem);
        int currentIndex = list.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (list.get(currentIndex).compareTo(list.get(parentIndex)) < 0) {
                break;
            } else {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            }
            currentIndex = parentIndex;
        }
    }

    public E remove() {
        if (list.isEmpty()) {
            return null;
        }

        E removedItem = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if (leftChildIndex >= list.size()) {
                break;
            }

            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            if (list.get(currentIndex).compareTo(list.get(maxIndex)) >= 0) {
                break;
            } else {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            }
        }

        return removedItem;
    }
}

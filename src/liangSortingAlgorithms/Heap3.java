package liangSortingAlgorithms;

import java.util.ArrayList;
import java.util.Comparator;

public class Heap3<E> {
    private ArrayList<E> list = new ArrayList<>();
    private Comparator<? super E> comparator;

    public Heap3() {
        this.comparator = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
    }

    public Heap3(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    public void add(E newItem) {
        list.add(newItem);
        int currentIndex = list.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (comparator.compare(list.get(currentIndex), list.get(parentIndex)) < 0) {
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
                if (comparator.compare(list.get(maxIndex), list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            if (comparator.compare(list.get(currentIndex), list.get(maxIndex)) >= 0) {
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

    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

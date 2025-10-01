package liangSortingAlgorithms;

public class MinHeap2 <E extends Comparable<E>> {
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();

    public MinHeap2() {
    }

    public void add(E newItem) {
        list.add(newItem);
        int currentIndex = list.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (list.get(currentIndex).compareTo(list.get(parentIndex)) >= 0) {
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

            int minIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(minIndex).compareTo(list.get(rightChildIndex)) > 0) {
                    minIndex = rightChildIndex;
                }
            }

            if (list.get(currentIndex).compareTo(list.get(minIndex)) > 0) {
                E temp = list.get(minIndex);
                list.set(minIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = minIndex;
            } else {
                break;
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

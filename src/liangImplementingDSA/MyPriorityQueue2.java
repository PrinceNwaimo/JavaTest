package liangImplementingDSA;

import java.util.Comparator;

public class MyPriorityQueue2 <E>{
    private Heap<E> heap;

    public MyPriorityQueue2() {
        this(new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                if (o1 instanceof Comparable) {
                    return ((Comparable) o1).compareTo(o2);
                } else {
                    throw new UnsupportedOperationException("Elements must be Comparable");
                }
            }
        });
    }

    public MyPriorityQueue2(Comparator<? super E> comparator) {
        heap = new Heap<>(comparator);
    }

    public void add(E newObject) {
        heap.add(newObject);
    }

    public E remove() {
        return heap.remove();
    }

    public int getSize() {
        return heap.getSize();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private static class Heap<E> {
        private java.util.ArrayList<E> list;
        private Comparator<? super E> comparator;

        public Heap(Comparator<? super E> comparator) {
            list = new java.util.ArrayList<>();
            this.comparator = comparator;
        }

        public void add(E newObject) {
            list.add(newObject);
            int currentIndex = list.size() - 1;

            while (currentIndex > 0) {
                int parentIndex = (currentIndex - 1) / 2;
                if (comparator.compare(list.get(currentIndex), list.get(parentIndex)) >= 0) {
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

            E removedObject = list.get(0);
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
                    if (comparator.compare(list.get(minIndex), list.get(rightChildIndex)) > 0) {
                        minIndex = rightChildIndex;
                    }
                }

                if (comparator.compare(list.get(currentIndex), list.get(minIndex)) > 0) {
                    E temp = list.get(currentIndex);
                    list.set(currentIndex, list.get(minIndex));
                    list.set(minIndex, temp);
                    currentIndex = minIndex;
                } else {
                    break;
                }
            }

            return removedObject;
        }

        public int getSize() {
            return list.size();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }
    }
}

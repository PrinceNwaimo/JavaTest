package liangImplementingDSA;

import java.util.LinkedList;

public class GenericQueue2<E> extends LinkedList<E> {
    public void enqueue(E element) {
        addLast(element);
    }

    public E dequeue() {
        return removeFirst();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int getSize() {
        return size();
    }
}

package liangImplementingDSA;


import java.util.Iterator;

public class MyLinkedList<E> extends MyAbstractList<E> {
    // Existing code...

    @Override
    public boolean contains(Object e) {
        return indexOf(e) >= 0;
    }

    @Override
    public void add(int index, E e) {

    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return getNode(index).element;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object e) {
        int index = 0;
        MyLinkedList.Node<E> current = head;
        while (current != null) {
            if (e.equals(current.element)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object e) {
        int index = size() - 1;
        MyLinkedList.Node<E> current = tail;
        while (current != null) {
            if (e.equals(current.element)) {
                return index;
            }
            current = current.previous;
            index--;
        }
        return -1;
    }

    @Override
    public E set(int index, E e) {
        checkIndex(index);
        MyLinkedList.Node<E> node = getNode(index);
        E oldElement = node.element;
        node.element = e;
        return oldElement;
    }

    @Override
    public void addAll(MyList<E> list2) {

    }

    @Override
    public void removeAll(MyList<E> list2) {

    }

    @Override
    public void retainAll(MyList<E> list2) {

    }

    private MyLinkedList.Node<E> getNode(int index) {
        checkIndex(index);
        if (index < size() / 2) {
            MyLinkedList.Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        } else {
            Node<E> current = tail;
            for (int i = size() - 1; i > index; i--) {
                current = current.previous;
            }
            return current;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
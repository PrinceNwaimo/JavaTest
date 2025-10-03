package liangImplementingDSA;

import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class TwoWayLinkedList <E> extends AbstractSequentialList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E e) {
            element = e;
        }
    }

    public TwoWayLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new TwoWayListIterator(index);
    }

    @Override
    public ListIterator<E> listIterator() {
        return new TwoWayListIterator(0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            Node<E> newNode = new Node<>(element);
            Node<E> current = getNode(index);
            newNode.next = current;
            newNode.previous = current.previous;
            current.previous.next = newNode;
            current.previous = newNode;
            size++;
        }
    }

    @Override
    public E get(int index) {
        return getNode(index).element;
    }

    @Override
    public E remove(int index) {
        Node<E> node = getNode(index);
        E element = node.element;
        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            tail = node.previous;
        }
        size--;
        return element;
    }

    private Node<E> getNode(int index) {
        if (index < size / 2) {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        } else {
            Node<E> current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
            return current;
        }
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    private class TwoWayListIterator implements ListIterator<E> {
        private Node<E> current;
        private int currentIndex;
        private boolean isForward;

        public TwoWayListIterator(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }

            currentIndex = index;
            if (index == size) {
                current = tail;
                if (current != null) {
                    current = current.next;
                }
            } else {
                current = getNode(index);
            }
            isForward = true;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E element = current.element;
            current = current.next;
            currentIndex++;
            isForward = true;
            return element;
        }

        @Override
        public boolean hasPrevious() {
            return currentIndex > 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (current == null) {
                current = tail;
            } else {
                current = current.previous;
            }
            currentIndex--;
            isForward = false;
            return current.element;
        }

        @Override
        public int nextIndex() {
            return currentIndex;
        }

        @Override
        public int previousIndex() {
            return currentIndex - 1;
        }

        @Override
        public void remove() {
            if (currentIndex == 0 || currentIndex > size) {
                throw new IllegalStateException();
            }
            Node<E> node;
            if (isForward) {
                node = current.previous;
                if (node.previous != null) {
                    node.previous.next = node.next;
                } else {
                    head = node.next;
                }

                if (node.next != null) {
                    node.next.previous = node.previous;
                } else {
                    tail = node.previous;
                }
                currentIndex--;
            } else {
                node = current;
                if (node.previous != null) {
                    node.previous.next = node.next;
                } else {
                    head = node.next;
                }

                if (node.next != null) {
                    node.next.previous = node.previous;
                } else {
                    tail = node.previous;
                }
                current = node.previous;
            }
            size--;
            isForward = false;
        }

        @Override
        public void set(E e) {
            if (currentIndex == 0 || currentIndex > size) {
                throw new IllegalStateException();
            }
            Node<E> node;
            if (isForward) {
                node = current.previous;
            } else {
                node = current;
            }
            node.element = e;
        }

        @Override
        public void add(E e) {
            Node<E> newNode = new Node<>(e);
            if (size == 0) {
                head = tail = newNode;
            } else if (current == null) {
                newNode.previous = tail;
                tail.next = newNode;
                tail = newNode;
            } else if (current == head) {
                newNode.next = head;
                head.previous = newNode;
                head = newNode;
            } else {
                newNode.next = current;
                newNode.previous = current.previous;
                current.previous.next = newNode;
                current.previous = newNode;
            }
            size++;
            currentIndex++;
            current = newNode.next;
            isForward = true;
        }
    }
}

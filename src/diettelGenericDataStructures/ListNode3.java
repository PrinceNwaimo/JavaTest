package diettelGenericDataStructures;

public class ListNode3 <E>{
    E data;
    ListNode<E> next;

    ListNode3(E data) {
        this.data = data;
        this.next = null;
    }
}

class List2<E> {
    private ListNode<E> firstNode;
    private ListNode<E> lastNode;
    private String name;

    public List2() {
        this("list");
    }

    public List2(String name) {
        this.name = name;
        firstNode = lastNode = null;
    }


    public void insertAtFront(E item) {
        ListNode<E> newNode = new ListNode<>(item);
        if (isEmpty()) {
            firstNode = lastNode = newNode;
        } else {
            newNode.next = firstNode;
            firstNode = newNode;
        }
    }

    public void insertAtBack(E item) {
        ListNode<E> newNode = new ListNode<>(item);
        if (isEmpty()) {
            firstNode = lastNode = newNode;
        } else {
            lastNode.next = newNode;
            lastNode = newNode;
        }
    }

    public void insertAtPosition(E item, int position) {
        if (position < 0) {
            throw new IndexOutOfBoundsException("Position must be >= 0");
        }

        ListNode<E> newNode = new ListNode<>(item);

        if (position == 0) {
            newNode.next = firstNode;
            firstNode = newNode;
            if (lastNode == null) {
                lastNode = newNode;
            }
            return;
        }

        ListNode<E> current = firstNode;
        int currentPosition = 0;
        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Position exceeds list length");
        }

        newNode.next = current.next;
        current.next = newNode;
        if (newNode.next == null) {
            lastNode = newNode;
        }
    }

    public void deleteAtPosition(int position) {
        if (position < 0) {
            throw new IndexOutOfBoundsException("Position must be >= 0");
        }

        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        if (position == 0) {
            firstNode = firstNode.next;
            if (firstNode == null) {
                lastNode = null;
            }
            return;
        }

        ListNode<E> current = firstNode;
        int currentPosition = 0;
        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null || current.next == null) {
            throw new IndexOutOfBoundsException("Position exceeds list length");
        }

        current.next = current.next.next;
        if (current.next == null) {
            lastNode = current;
        }
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public void printListForward() {
        System.out.print("List contents: ");
        ListNode<E> current = firstNode;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}


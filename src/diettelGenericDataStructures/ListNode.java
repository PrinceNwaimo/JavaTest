package diettelGenericDataStructures;
import java.util.LinkedList;

public class ListNode <E>{
    E data;
    ListNode<E> next;

    ListNode(E data) {
        this.data = data;
        this.next = null;
    }
}

// List class modification
class List<E> {
    ListNode<E> firstNode;
    private ListNode<E> lastNode;
    private String name;

    public List() {
        this("list");
    }

    public List(String name) {
        this.name = name;
        firstNode = lastNode = null;
    }

    // Existing methods (insertAtFront, insertAtBack, removeFromFront, etc.)

    public void printListBackward() {
        System.out.println("Printing " + name + " backward:");
        printListBackwardRecursive(firstNode);
        System.out.println();
    }

    private void printListBackwardRecursive(ListNode<E> node) {
        if (node == null) {
            return;
        }
        printListBackwardRecursive(node.next);
        System.out.print(node.data + " ");
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

    public E removeFromFront() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty");
        }
        E removedItem = firstNode.data;
        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            firstNode = firstNode.next;
        }
        return removedItem;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }
    public E search(E value) {
        return searchRecursive(firstNode, value);
    }

    private E searchRecursive(ListNode<E> node, E value) {
        if (node == null) {
            return null; // Base case: not found
        }
        if (node.data.equals(value)) {
            return node.data; // Found match
        }
        return searchRecursive(node.next, value); // Recurse next node
    }

}


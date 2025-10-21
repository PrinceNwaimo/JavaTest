package diettelGenericDataStructures;

import java.util.Random;

public class Node2 <E extends Comparable<E>>{
    E data;
    Node2<E> next;

    public Node2(E data) {
        this.data = data;
        this.next = null;
    }
}

// SortedList class maintaining an ordered list of elements
class SortedList<E extends Comparable<E>> {
    Node2<E> head;

    // Method to insert an element in sorted order
    public void insert(E data) {
        Node2<E> newNode = new Node2<>(data);
        if (head == null || head.data.compareTo(data) >= 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node2<E> current = head;
            while (current.next != null && current.next.data.compareTo(data) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Method to print the linked list
    public void printList() {
        Node2<E> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}


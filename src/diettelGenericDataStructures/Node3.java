package diettelGenericDataStructures;

import java.util.Random;

public class Node3 <E extends Comparable<E>>{
    E data;
    Node3<E> next;

    public Node3(E data) {
        this.data = data;
        this.next = null;
    }
}

// SortedList class maintaining an ordered list of elements
class SortedList2<E extends Comparable<E>> {
    Node3<E> head;

    // Method to insert an element in sorted order
    public void insert(E data) {
        Node3<E> newNode = new Node3<>(data);
        if (head == null || head.data.compareTo(data) >= 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node3<E> current = head;
            while (current.next != null && current.next.data.compareTo(data) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Method to merge another SortedList into this list
    public void merge(SortedList2<E> otherList) {
        Node3<E> otherCurrent = otherList.head;
        while (otherCurrent != null) {
            insert(otherCurrent.data);
            otherCurrent = otherCurrent.next;
        }
    }

    // Method to print the linked list
    public void printList() {
        Node3<E> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}


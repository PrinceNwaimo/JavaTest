package diettelGenericDataStructures;

public class Node {
    char data;
    Node next;

    public Node(char data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class representing a list of characters
class LinkedList {
    Node head;

    // Method to add a character to the end of the list
    public void add(char data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Class with a static method to concatenate two linked lists
class ListConcatenate {
    // Static method to concatenate list2 to list1
    public static void concatenate(LinkedList list1, LinkedList list2) {
        if (list1.head == null) {
            list1.head = list2.head;
        } else {
            Node current = list1.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = list2.head;
        }
        // list2's head is now part of list1, so we shouldn't touch list2.head directly afterward
        // To avoid unintended modifications, one might consider list2's state as transferred
    }
}


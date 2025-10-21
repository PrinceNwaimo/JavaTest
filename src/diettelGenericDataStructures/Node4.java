package diettelGenericDataStructures;

public class Node4 {
    int data;
    Node4 next;

    public Node4(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class representing a list of integers
class LinkedList2 {
    Node4 head;

    // Method to add an element to the end of the list
    public void add(int data) {
        Node4 newNode = new Node4(data);
        if (head == null) {
            head = newNode;
        } else {
            Node4 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to find and print the break point of ascending sort
    public void findBreakPoint() {
        Node4 current = head;
        int position = 1;
        while (current != null && current.next != null) {
            if (current.data > current.next.data) {
                System.out.println("Break point found at position " + (position + 1) + ": " + current.data + " -> " + current.next.data);
                return;
            }
            current = current.next;
            position++;
        }
        System.out.println("List is sorted in ascending order.");
    }

    // Method to print the linked list
    public void printList() {
        Node4 current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}


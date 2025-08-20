package liang10;

import java.util.Arrays;

public class Queue {
    private int[] elements;
    private int size;

    public Queue() {
        elements = new int[8];
        size = 0;
    }

    public void enqueue(int v) {
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size++] = v;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int removed = elements[0];
        System.arraycopy(elements, 1, elements, 0, size - 1);
        size--;
        return removed;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        for (int i = 1; i <= 20; i++) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}

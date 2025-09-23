package diettelGenerics;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Create a PriorityQueue with a custom comparator
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>((a, b) -> Double.compare(b, a));

        // Add elements to the PriorityQueue
        priorityQueue.offer(9.8);
        priorityQueue.offer(3.2);
        priorityQueue.offer(7.5);
        priorityQueue.offer(1.1);
        priorityQueue.offer(5.6);

        // Print the elements in the PriorityQueue
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}

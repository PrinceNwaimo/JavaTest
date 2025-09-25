package liangCollections;

import java.util.PriorityQueue;

public class MyPriorityQueue <E extends Comparable<E>> extends PriorityQueue<E> implements Cloneable{

    @Override
    public MyPriorityQueue<E> clone() {
        MyPriorityQueue<E> clone = new MyPriorityQueue<>();
        clone.addAll(this);
        return clone;
    }

    public static void main(String[] args) {
        MyPriorityQueue<Integer> queue1 = new MyPriorityQueue<>();
        queue1.add(10);
        queue1.add(5);
        queue1.add(20);
        queue1.add(15);

        System.out.println("Queue 1: " + queue1);

        MyPriorityQueue<Integer> queue2 = queue1.clone();
        System.out.println("Queue 2 (cloned): " + queue2);

        queue2.add(25);
        System.out.println("Queue 1 after modifying Queue 2: " + queue1);
        System.out.println("Queue 2 after modification: " + queue2);
    }
}

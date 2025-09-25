package liangCollections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTraversalTest {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5_000_000; i++) {
            list.add(i);
        }

        long startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time using iterator: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time using get(index): " + (endTime - startTime) + " ms");
    }
}

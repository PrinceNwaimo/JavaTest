package diettelGenericDataStructures;

import java.util.Random;

public class Node3Test {
    public static void main(String[] args) {
        SortedList2<Integer> list1 = new SortedList2<>();
        list1.insert(10);
        list1.insert(30);
        list1.insert(50);

        SortedList2<Integer> list2 = new SortedList2<>();
        list2.insert(20);
        list2.insert(40);
        list2.insert(60);

        System.out.println("List 1:");
        list1.printList();
        System.out.println("List 2:");
        list2.printList();

        list1.merge(list2);
        System.out.println("Merged List (list1):");
        list1.printList();

        // Demonstrating with random data
        SortedList2<Integer> randomList1 = new SortedList2<>();
        SortedList2<Integer> randomList2 = new SortedList2<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            randomList1.insert(random.nextInt(100));
            randomList2.insert(random.nextInt(100));
        }

        System.out.println("\nRandom List 1:");
        randomList1.printList();
        System.out.println("Random List 2:");
        randomList2.printList();

        randomList1.merge(randomList2);
        System.out.println("Merged Random List:");
        randomList1.printList();
    }
}

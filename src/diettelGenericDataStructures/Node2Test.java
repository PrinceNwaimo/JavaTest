package diettelGenericDataStructures;

import java.util.Random;

public class Node2Test {
    public static void main(String[] args) {
        SortedList<Integer> sortedList = new SortedList<>();
        Random random = new Random();

        System.out.println("Inserting 25 random integers into the sorted list:");
        for (int i = 0; i < 25; i++) {
            int randomNumber = random.nextInt(101); // 0 to 100
            System.out.print(randomNumber + " ");
            sortedList.insert(randomNumber);
        }
        System.out.println("\nSorted List:");
        sortedList.printList();
    }
}

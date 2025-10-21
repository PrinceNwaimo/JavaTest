package diettelGenericDataStructures;

public class Node4Test {
    public static void main(String[] args) {
        LinkedList2 sortedList = new LinkedList2();
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(3);
        sortedList.add(4);
        sortedList.add(5);

        LinkedList2 unsortedList = new LinkedList2();
        unsortedList.add(1);
        unsortedList.add(3);
        unsortedList.add(2);
        unsortedList.add(4);
        unsortedList.add(5);

        System.out.println("Sorted List:");
        sortedList.printList();
        sortedList.findBreakPoint();

        System.out.println("\nUnsorted List:");
        unsortedList.printList();
        unsortedList.findBreakPoint();
    }
}

package diettelGenericDataStructures;

// Test program
public class ListTest2 {
    public static void main(String[] args) {
        List<Integer> integerList = new List<>("Integer List");

        integerList.insertAtBack(1);
        integerList.insertAtBack(2);
        integerList.insertAtBack(3);
        integerList.insertAtBack(4);
        integerList.insertAtBack(5);

        System.out.println("List contents (forward):");
        printListForward(integerList);

        integerList.printListBackward();
    }

    // Helper to print list forward (iterative for simplicity)
    private static void printListForward(List<?> list) {
        ListNode<?> current = list.firstNode;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

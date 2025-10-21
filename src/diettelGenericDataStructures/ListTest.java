package diettelGenericDataStructures;

public class ListTest {
    public static void main(String[] args) {
        List2<Integer> integerList = new List2<>("Integer List");

        integerList.insertAtBack(10);
        integerList.insertAtBack(20);
        integerList.insertAtBack(30);
        integerList.insertAtPosition(25, 1); // Insert 25 at position 1

        System.out.println("List contents:");
        integerList.printListForward();

        integerList.deleteAtPosition(1); // Delete 25 (at position 1)

        System.out.println("List contents after deletion:");
        integerList.printListForward();
    }
}

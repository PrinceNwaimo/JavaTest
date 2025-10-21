package diettelGenericDataStructures;

public class ListSearchTest {
    public static void main(String[] args) {
        List<Integer> integerList = new List<>("Integer List");
        integerList.insertAtBack(10);
        integerList.insertAtBack(20);
        integerList.insertAtBack(30);
        integerList.insertAtBack(40);
        integerList.insertAtBack(50);

        System.out.print("List contents: ");
        printListForward(integerList);

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter value to search for: ");
        int searchValue = scanner.nextInt();
        scanner.close();

        Integer result = integerList.search(searchValue);
        if (result != null) {
            System.out.println("Value " + searchValue + " found in the list.");
        } else {
            System.out.println("Value " + searchValue + " not found in the list.");
        }
    }

    private static void printListForward(List<?> list) {
        ListNode<?> current = list.firstNode;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

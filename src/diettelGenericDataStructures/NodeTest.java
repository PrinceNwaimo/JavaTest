package diettelGenericDataStructures;

public class NodeTest {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.add('A');
        list1.add('B');
        list1.add('C');

        LinkedList list2 = new LinkedList();
        list2.add('D');
        list2.add('E');
        list2.add('F');

        System.out.println("List 1:");
        list1.printList();
        System.out.println("List 2:");
        list2.printList();

        ListConcatenate.concatenate(list1, list2);

        System.out.println("Concatenated List:");
        list1.printList();
    }
}

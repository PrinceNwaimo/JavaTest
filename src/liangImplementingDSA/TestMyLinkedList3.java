package liangImplementingDSA;

public class TestMyLinkedList3 {
    public static void main(String[] args) {
        // Create a MyLinkedList
        MyLinkedList<String> list = new MyLinkedList<>();

        // Test add method
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("List: " + list);

        // Test size method
        System.out.println("Size: " + list.size());

        // Test get method
        System.out.println("Get index 1: " + list.get(1));

        // Test set method
        list.set(1, "Mango");
        System.out.println("List after set: " + list);

        // Test indexOf method
        System.out.println("Index of Cherry: " + list.indexOf("Cherry"));

        // Test remove method
        list.remove("Apple");
        System.out.println("List after remove: " + list);

        // Test isEmpty method
        System.out.println("Is empty? " + list.isEmpty());

        // Test clear method
        list.clear();
        System.out.println("List after clear: " + list);

        // Test isEmpty method again
        System.out.println("Is empty? " + list.isEmpty());

        // Test add at specific index
        list.add(0, "Orange");
        list.add(1, "Grapes");
        System.out.println("List: " + list);

        // Test remove at specific index
        list.remove(0);
        System.out.println("List after remove at index 0: " + list);

        // Test addFirst and addLast
        list.addFirst("Pineapple");
        list.addLast("Watermelon");
        System.out.println("List after addFirst and addLast: " + list);

        // Test removeFirst and removeLast
        list.removeFirst();
        list.removeLast();
        System.out.println("List after removeFirst and removeLast: " + list);
    }
}

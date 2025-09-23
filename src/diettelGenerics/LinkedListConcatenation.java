package diettelGenerics;

import java.util.LinkedList;

public class LinkedListConcatenation {
    public static <T> LinkedList<T> listConcatenate(LinkedList<T> list1, LinkedList<T> list2) {
        LinkedList<T> result = new LinkedList<>(list1);
        result.addAll(list2);
        return result;
    }

    public static void main(String[] args) {
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Cherry");

        LinkedList<String> list2 = new LinkedList<>();
        list2.add("Date");
        list2.add("Elderberry");
        list2.add("Fig");

        LinkedList<String> concatenatedList = listConcatenate(list1, list2);

        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        System.out.println("Concatenated List: " + concatenatedList);
    }
}

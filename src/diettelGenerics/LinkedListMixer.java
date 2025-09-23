package diettelGenerics;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListMixer {
    public static void mixList(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        ListIterator<Integer> iterator1 = list1.listIterator();
        ListIterator<Integer> iterator2 = list2.listIterator();

        while (iterator2.hasNext()) {
            if (iterator1.hasNext()) {
                iterator1.next();
            }
            iterator1.add(iterator2.next());
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(3);
        list1.add(1);
        list1.add(7);
        list1.add(4);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(5);
        list2.add(6);
        list2.add(0);
        list2.add(8);

        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);


        mixList(list1, list2);

        System.out.println("Mixed List: " + list1);
    }
}

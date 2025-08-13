package diettel8;

import static diettel8.IntegerSet2.intersection;
import static diettel8.IntegerSet2.union;

public class IntegerSet2Test {
    public static void main(String[] args) {
        IntegerSet2 set1 = new IntegerSet2();
        IntegerSet2 set2 = new IntegerSet2();

        set1.insertElement(1);
        set1.insertElement(2);
        set1.insertElement(3);
        set2.insertElement(3);
        set2.insertElement(4);
        set2.insertElement(5);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        IntegerSet2 unionSet = union(set1, set2);
        System.out.println("Union: " + unionSet);

        IntegerSet2 intersectionSet = intersection(set1, set2);
        System.out.println("Intersection: " + intersectionSet);

        set1.deleteElement(2);
        System.out.println("Set 1 after deleting 2: " + set1);

        System.out.println("Is set1 equal to set2? " + set1.isEqualTo(set2));
    }
}

package diettel8;

public class IntegerSetTest {
    public static void main(String[] args) {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.insertElement(1);
        set1.insertElement(2);
        set1.insertElement(3);
        set2.insertElement(3);
        set2.insertElement(4);
        set2.insertElement(5);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        IntegerSet union = set1.union(set2);
        System.out.println("Union: " + union);

        IntegerSet intersection = set1.intersection(set2);
        System.out.println("Intersection: " + intersection);

        System.out.println("Is set1 equal to set2? " + set1.isEqualTo(set2));
    }
}


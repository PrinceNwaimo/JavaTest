package diettelGenerics;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }

    public static <T> Set<T> difference(Set<T> set1, Set<T> set2) {
        Set<T> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        return difference;
    }

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("Apple");
        set1.add("Banana");
        set1.add("Cherry");
        set1.add("Date");

        Set<String> set2 = new HashSet<>();
        set2.add("Banana");
        set2.add("Cherry");
        set2.add("Elderberry");
        set2.add("Fig");

        Set<String> intersection = intersection(set1, set2);
        System.out.println("Intersection: " + intersection);

        Set<String> union = union(set1, set2);
        System.out.println("Union: " + union);

        Set<String> difference1 = difference(set1, set2);
        Set<String> difference2 = difference(set2, set1);
        System.out.println("Difference (set1 - set2): " + difference1);
        System.out.println("Difference (set2 - set1): " + difference2);
    }
}

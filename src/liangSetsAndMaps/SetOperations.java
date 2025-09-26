package liangSetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetOperations {
    public static void main(String[] args) {
        // Create two linked hash sets
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("George");
        set1.add("Jim");
        set1.add("John");
        set1.add("Blake");
        set1.add("Kevin");
        set1.add("Michael");

        Set<String> set2 = new LinkedHashSet<>();
        set2.add("George");
        set2.add("Katie");
        set2.add("Kevin");
        set2.add("Michelle");
        set2.add("Ryan");

        // Clone the sets to preserve the original sets
        Set<String> set1Clone = new LinkedHashSet<>(set1);
        Set<String> set2Clone = new LinkedHashSet<>(set2);

        // Find the union
        Set<String> union = new LinkedHashSet<>(set1Clone);
        union.addAll(set2Clone);
        System.out.println("Union: " + union);

        // Find the difference
        Set<String> difference1 = new LinkedHashSet<>(set1Clone);
        difference1.removeAll(set2Clone);
        System.out.println("Difference (set1 - set2): " + difference1);

        Set<String> difference2 = new LinkedHashSet<>(set2Clone);
        difference2.removeAll(set1Clone);
        System.out.println("Difference (set2 - set1): " + difference2);

        // Find the intersection
        Set<String> intersection = new LinkedHashSet<>(set1Clone);
        intersection.retainAll(set2Clone);
        System.out.println("Intersection: " + intersection);
    }
}

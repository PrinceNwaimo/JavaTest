package liangSetsAndMaps;

import java.util.HashSet;
import java.util.Set;

public class TestHashSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("London");
        set.add("Paris");
        set.add("New york");
        set.add("San Francisco");
        set.add("Beijing");
        System.out.println(set);

        for(String name: set){
            System.out.print(name.toUpperCase() + " ");
        }

    }
}

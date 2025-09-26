package liangSetsAndMaps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Smith",30);
        hashMap.put("Anderson",31);
        hashMap.put("Lewis",32);
        hashMap.put("Cook",33);

        System.out.println("Display entries in HashMpa");
        System.out.println(hashMap + "\n");

        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Display entries  in ascending order of key");
        System.out.println(treeMap);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16,0.75f, true);
        linkedHashMap.put("Smith",30);
        linkedHashMap.put("Anderson",31);
        linkedHashMap.put("Lewis",32);
        linkedHashMap.put("Cook",33);

        System.out.println("\nThe age for " + "lewis is "+ linkedHashMap.get("Lewis"));
        System.out.println("Display entries in LinkedHashMap");
        System.out.println(linkedHashMap);
    }
}

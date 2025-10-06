package liangHashing;

public class MyHashSet2 <K>{
    private MyHashMap<K, Object> map;

    public MyHashSet2() {
        map = new MyHashMap<>();
    }

    public void add(K key) {
        map.put(key, null);
    }

    public void remove(K key) {
        map.remove(key);
    }

    public boolean contains(K key) {
        return map.containsKey(key);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }
    public static void main(String[] args) {
        MyHashSet<String> set = new MyHashSet<>();
        set.add("Apple");
        set.add("Banana");
        System.out.println(set.contains("Apple")); // prints true
        System.out.println(set.contains("Orange")); // prints false
        set.remove("Apple");
        System.out.println(set.contains("Apple")); // prints false
    }
}

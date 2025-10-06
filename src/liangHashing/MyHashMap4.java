package liangHashing;

import java.util.Set;

public class MyHashMap4 <K, V> implements MyMap<K, V> {
    private static final int INITIAL_CAPACITY = 4;
    private static final float LOAD_FACTOR_THRESHOLD = 0.5f;

    private Entry<K, V>[] table;
    private int size;

    public MyHashMap4() {
        table = new Entry[INITIAL_CAPACITY];
    }

    @Override
    public V put(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException("Key or value cannot be null");
        }

        if (size >= table.length * LOAD_FACTOR_THRESHOLD) {
            resize();
        }

        int index = hash1(key);
        int step = hash2(key);
        while (table[index] != null && !table[index].key.equals(key)) {
            index = (index + step) % table.length;
        }

        if (table[index] == null) {
            size++;
        }
        table[index] = new Entry<>(key, value);
        return value;
    }

    @Override
    public V get(K key) {
        int index = hash1(key);
        int step = hash2(key);
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + step) % table.length;
        }
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(K key) {
        int index = hash1(key);
        int step = hash2(key);
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return true;
            }
            index = (index + step) % table.length;
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        return false;
    }

    @Override
    public Set<MyMap.Entry<K, V>> entrySet() {
        return Set.of();
    }

    @Override
    public void remove(K key) {
        int index = hash1(key);
        int step = hash2(key);
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                V value = table[index].value;
                table[index] = null;
                size--;
            }
            index = (index + step) % table.length;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Set<V> values() {
        return Set.of();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Set<K> keySet() {
        return Set.of();
    }

    private int hash1(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    private int hash2(K key) {
        int prime = 3;
        return prime - Math.abs(key.hashCode()) % prime;
    }

    private void resize() {
        Entry<K, V>[] newTable = new Entry[table.length * 2];
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                int index = hash1(entry.key);
                int step = hash2(entry.key);
                while (newTable[index] != null) {
                    index = (index + step) % newTable.length;
                }
                newTable[index] = entry;
            }
        }
        table = newTable;
    }

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        MyMap<String, Integer> map = new MyHashMap<>();
        map.put("John", 25);
        map.put("Mary", 30);
        System.out.println(map.get("John")); // prints 25
        System.out.println(map.containsKey("Mary")); // prints true
        map.remove("John");
        System.out.println(map.get("John")); // prints null
    }
}

package liangHashing;

import java.util.HashSet;
import java.util.Set;

public class MyHashMap5 <K, V> implements MyMap<K, V> {
    private static final int INITIAL_CAPACITY = 4;
    private static final float LOAD_FACTOR_THRESHOLD = 0.5f;

    private Entry<K, V>[] table;
    private int size;

    public MyHashMap5() {
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

        int index = hash(key);
        if (table[index] == null) {
            table[index] = new Entry<>(key, value);
            size++;
        } else {
            Entry<K, V> entry = table[index];
            while (entry.next != null && !entry.key.equals(key)) {
                entry = entry.next;
            }
            if (entry.key.equals(key)) {
                entry.values.add(value);
                size++;
            } else {
                entry.next = new Entry<>(key, value);
                size++;
            }
        }
        return value;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];
        while (entry != null && !entry.key.equals(key)) {
            entry = entry.next;
        }
        return entry != null && entry.values.size() > 0 ? entry.values.iterator().next() : null;
    }

    public Set<V> getAll(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];
        while (entry != null && !entry.key.equals(key)) {
            entry = entry.next;
        }
        return entry != null ? entry.values : new HashSet<>();
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];
        while (entry != null && !entry.key.equals(key)) {
            entry = entry.next;
        }
        return entry != null;
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
        int index = hash(key);
        Entry<K, V> entry = table[index];
        Entry<K, V> prev = null;
        while (entry != null && !entry.key.equals(key)) {
            prev = entry;
            entry = entry.next;
        }
        if (entry != null) {
            if (prev != null) {
                prev.next = entry.next;
            } else {
                table[index] = entry.next;
            }
            size--;
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

    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    private void resize() {
        Entry<K, V>[] newTable = new Entry[table.length * 2];
        for (Entry<K, V> entry : table) {
            Entry<K, V> current = entry;
            while (current != null) {
                Entry<K, V> next = current.next;
                int index = hash(current.key);
                current.next = newTable[index];
                newTable[index] = current;
                current = next;
            }
        }
        table = newTable;
    }

    private static class Entry<K, V> {
        K key;
        Set<V> values;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.values = new HashSet<>();
            this.values.add(value);
        }
    }

}

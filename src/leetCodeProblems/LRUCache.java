package leetCodeProblems;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    /**
     * Initialize the LRU cache with the given capacity.
     *
     * @param capacity the maximum number of items the cache can hold
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        // Use LinkedHashMap with access order = true (LRU order)
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    /**
     * Get the value for the given key.
     *
     * @param key the key to look up
     * @return the value if found, otherwise -1
     */
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    /**
     * Set the value for the given key.
     *
     * @param key the key
     * @param value the value to store
     */
    public void set(int key, int value) {
        cache.put(key, value);
    }

    /**
     * Alternative implementation using manual doubly linked list + HashMap
     * (More memory efficient and gives full control)
     */
    public static class LRUCacheManual {
        private final int capacity;
        private final Map<Integer, Node> map;
        private final Node head;
        private final Node tail;

        // Doubly linked list node
        private static class Node {
            int key;
            int value;
            Node prev;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public LRUCacheManual(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            moveToHead(node);
            return node.value;
        }

        public void set(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                Node newNode = new Node(key, value);
                if (map.size() >= capacity) {
                    // Remove least recently used (tail.prev)
                    Node lru = tail.prev;
                    removeNode(lru);
                    map.remove(lru.key);
                }
                addToHead(newNode);
                map.put(key, newNode);
            }
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        private void addToHead(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void printCache() {
            Node current = head.next;
            System.out.print("Cache (most recent to least recent): ");
            while (current != tail) {
                System.out.print("[" + current.key + ":" + current.value + "] ");
                current = current.next;
            }
            System.out.println();
        }
    }

    /**
     * Alternative implementation using LinkedHashMap but with manual LRU tracking
     */
    public static class LRUCacheSimple {
        private final int capacity;
        private final LinkedHashMap<Integer, Integer> cache;

        public LRUCacheSimple(int capacity) {
            this.capacity = capacity;
            this.cache = new LinkedHashMap<>();
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            // Move to end (most recently used)
            int value = cache.remove(key);
            cache.put(key, value);
            return value;
        }

        public void set(int key, int value) {
            if (cache.containsKey(key)) {
                // Remove and reinsert to update order
                cache.remove(key);
            } else if (cache.size() >= capacity) {
                // Remove least recently used (first entry)
                Map.Entry<Integer, Integer> eldest = cache.entrySet().iterator().next();
                cache.remove(eldest.getKey());
            }
            cache.put(key, value);
        }

        public void printCache() {
            System.out.println("Cache (order = LRU order): " + cache);
        }
    }

    /**
     * Utility method to print cache contents
     */
    public void printCache() {
        System.out.println("Cache contents (most recent first): " + cache);
    }

    public static void main(String[] args) {
        System.out.println("=== LRU Cache Implementation ===");
        System.out.println();

        // Test 1: Basic operations with capacity 2
        System.out.println("Test 1: Capacity = 2");
        LRUCache cache = new LRUCache(2);

        cache.set(1, 1);
        cache.set(2, 2);
        System.out.println("After setting (1,1) and (2,2):");
        cache.printCache();

        System.out.println("get(1) = " + cache.get(1));
        System.out.println("After get(1):");
        cache.printCache();

        cache.set(3, 3);
        System.out.println("After setting (3,3):");
        cache.printCache();

        System.out.println("get(2) = " + cache.get(2));
        System.out.println("get(3) = " + cache.get(3));
        System.out.println();

        // Test 2: More operations
        System.out.println("Test 2: Additional operations");
        cache.set(4, 4);
        System.out.println("After setting (4,4):");
        cache.printCache();

        System.out.println("get(1) = " + cache.get(1));
        System.out.println("get(3) = " + cache.get(3));
        System.out.println("get(4) = " + cache.get(4));
        System.out.println();

        // Test 3: Manual implementation
        System.out.println("=== Manual Implementation (Doubly Linked List + HashMap) ===");
        LRUCacheManual manualCache = new LRUCacheManual(3);

        manualCache.set(1, 10);
        manualCache.set(2, 20);
        manualCache.set(3, 30);
        manualCache.printCache();

        System.out.println("get(2) = " + manualCache.get(2));
        manualCache.printCache();

        manualCache.set(4, 40);
        manualCache.printCache();

        System.out.println("get(1) = " + manualCache.get(1));
        System.out.println("get(3) = " + manualCache.get(3));
        System.out.println("get(4) = " + manualCache.get(4));
        manualCache.printCache();
        System.out.println();

        // Test 4: Simple implementation
        System.out.println("=== Simple Implementation (LinkedHashMap) ===");
        LRUCacheSimple simpleCache = new LRUCacheSimple(2);

        simpleCache.set(1, 100);
        simpleCache.set(2, 200);
        simpleCache.printCache();

        System.out.println("get(1) = " + simpleCache.get(1));
        simpleCache.printCache();

        simpleCache.set(3, 300);
        simpleCache.printCache();

        System.out.println("get(2) = " + simpleCache.get(2));
        System.out.println("get(3) = " + simpleCache.get(3));
        System.out.println();

        // Test 5: Edge cases
        System.out.println("=== Edge Cases ===");
        LRUCache edgeCache = new LRUCache(1);

        edgeCache.set(1, 1);
        System.out.println("After setting (1,1):");
        edgeCache.printCache();

        edgeCache.set(2, 2);
        System.out.println("After setting (2,2):");
        edgeCache.printCache();

        System.out.println("get(1) = " + edgeCache.get(1));
        System.out.println("get(2) = " + edgeCache.get(2));
        System.out.println();

        // Test 6: Capacity 0
        System.out.println("Test: Capacity = 0");
        LRUCache zeroCache = new LRUCache(0);
        zeroCache.set(1, 1);
        System.out.println("get(1) = " + zeroCache.get(1));
        zeroCache.printCache();
    }
}

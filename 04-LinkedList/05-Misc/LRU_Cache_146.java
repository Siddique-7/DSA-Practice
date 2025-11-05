import java.util.*;

public class LRU_Cache_146 {

    private LinkedHashMap<Integer, Integer> cache;
    private int capacity;

    public LRU_Cache_146(int capacity) {
        this.capacity = capacity;
        // true for access-order, maintains LRU order
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
        // If size exceeds capacity, remove eldest entry (first entry in LRU)
        if (cache.size() > capacity) {
            Integer firstKey = cache.keySet().iterator().next();
            cache.remove(firstKey);
        }
    }

    public static void main(String[] args) {
        LRU_Cache_146 lru = new LRU_Cache_146(2);

        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1)); // returns 1
        lru.put(3, 3); // evicts key 2
        System.out.println(lru.get(2)); // returns -1 (not found)
        lru.put(4, 4); // evicts key 1
        System.out.println(lru.get(1)); // returns -1 (not found)
        System.out.println(lru.get(3)); // returns 3
        System.out.println(lru.get(4)); // returns 4
    }
}

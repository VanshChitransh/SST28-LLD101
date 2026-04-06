import java.util.LinkedHashMap;

public class LRUCache {
     private final int capacity;
    private final LinkedHashMap<String, String> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public String get(String key) {
        return map.get(key);
    }

    public void put(String key, String value) {
        if (map.size() >= capacity && !map.containsKey(key)) {
            String firstKey = map.keySet().iterator().next();
            map.remove(firstKey);
        }
        map.put(key, value);
    }

    public boolean contains(String key) {
        return map.containsKey(key);
    }
}

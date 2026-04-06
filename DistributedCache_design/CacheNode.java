public class CacheNode {
     private final LRUCache cache;

    public CacheNode(int capacity) {
        this.cache = new LRUCache(capacity);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public boolean contains(String key) {
        return cache.contains(key);
    }
}

public class Main {
    public static void main(String[] args) {

        DistributedCache cache = new DistributedCache(3, 2);

        System.out.println(cache.get("A")); // DB fetch
        System.out.println(cache.get("A")); // Cache hit

        cache.put("B", "ValueB");
}
}

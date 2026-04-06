import java.util.ArrayList;
import java.util.List;

    public class DistributedCache {

    private final List<CacheNode> nodes;
    private final DistributionStrategy strategy;
    private final Database db;

    public DistributedCache(int numNodes, int capacityPerNode) {
        this.strategy = new ModuloStrategy();
        this.db = new Database();
        this.nodes = new ArrayList<>();

        for (int i = 0; i < numNodes; i++) {
            nodes.add(new CacheNode(capacityPerNode));
        }
    }

    public String get(String key) {
        int index = strategy.getNodeIndex(key, nodes.size());
        CacheNode node = nodes.get(index);

        if (node.contains(key)) {
            return node.get(key);
        }

        String value = db.fetch(key);
        node.put(key, value);
        return value;
    }

    public void put(String key, String value) {
        int index = strategy.getNodeIndex(key, nodes.size());
        CacheNode node = nodes.get(index);

        node.put(key, value);

    }
}

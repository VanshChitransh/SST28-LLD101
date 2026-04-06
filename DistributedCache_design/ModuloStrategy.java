public class ModuloStrategy implements DistributionStrategy {
 public int getNodeIndex(String key, int totalNodes) {
        return Math.abs(key.hashCode()) % totalNodes;
    } 
}

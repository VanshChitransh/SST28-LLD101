import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SlidingWindowRule implements IRuleStrategy {
    private final Map<String, Queue<Long>> requestMap = new HashMap<>();
    private final long windowSizeInMillis;
    private final int maxRequests;

    public SlidingWindowRule(long windowSizeInMillis, int maxRequests) {
        this.windowSizeInMillis = windowSizeInMillis;
        this.maxRequests = maxRequests;
    }

    @Override
    public boolean rateRule(String clientId) {
        long currentTime = System.currentTimeMillis();

        requestMap.putIfAbsent(clientId, new LinkedList<>());
        Queue<Long> timestamps = requestMap.get(clientId);

        // Remove outdated requests
        while (!timestamps.isEmpty() && currentTime - timestamps.peek() > windowSizeInMillis) {
            timestamps.poll();
        }

        if (timestamps.size() < maxRequests) {
            timestamps.offer(currentTime);
            return true;
        }

        return false;
    }
}

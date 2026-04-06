import java.util.*;

public class FixedWindowRule implements IRuleStrategy {

    private static class Window {
        int counter;
        long windowStartTime;

        Window(long startTime) {
            this.counter = 0;
            this.windowStartTime = startTime;
        }
    }

    private final Map<String, Window> requestMap = new HashMap<>();
    private final long windowSizeInMillis;
    private final int maxRequests;

    public FixedWindowRule(long windowSizeInMillis, int maxRequests) {
        this.windowSizeInMillis = windowSizeInMillis;
        this.maxRequests = maxRequests;
    }

    @Override
    public boolean rateRule(String clientId) {
        long currentTime = System.currentTimeMillis();

        requestMap.putIfAbsent(clientId, new Window(currentTime));
        Window window = requestMap.get(clientId);

        // Reset window if expired
        if (currentTime - window.windowStartTime > windowSizeInMillis) {
            window.windowStartTime = currentTime;
            window.counter = 0;
        }

        if (window.counter < maxRequests) {
            window.counter++;
            return true;
        }

        return false;
    }
}
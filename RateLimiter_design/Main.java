public class Main {
    public static void main(String[] args) throws InterruptedException {

        IRuleStrategy strategy = new SlidingWindowRule(5000, 3); // 3 requests per 5 sec
        RemoteResourse resource = new RemoteResourse();
        IRateLimiter proxy = new RemoteResourceProxy(strategy, resource);

        String client = "user1";

        for (int i = 0; i < 5; i++) {
            System.out.println(proxy.getResponse(client));
            Thread.sleep(1000);
        }
    }
}

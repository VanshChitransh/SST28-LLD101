public class RemoteResourceProxy implements IRateLimiter {

    private final IRuleStrategy strategy;
    private final RemoteResourse resource;

    public RemoteResourceProxy(IRuleStrategy strategy, RemoteResourse resource) {
        this.strategy = strategy;
        this.resource = resource;
    }

    @Override
    public String getResponse(String clientId) {
        if (strategy.rateRule(clientId)) {
            return resource.getResponse(clientId);
        } else {
            return "Rate limit exceeded for client: " + clientId;
        }
    }
}

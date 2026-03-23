public class MessPricing implements AddOnPricing{
    @Override
    public Money price(){
        return new Money(1000.0);
    }
    @Override
    public String displayName() {
        return "MESS";
    }
}

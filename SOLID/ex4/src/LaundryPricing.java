public class LaundryPricing implements AddOnPricing{
    @Override
    public Money price(){
        return new Money(500.0);
    }
    @Override
    public String displayName() {
        return "LAUNDRY";
    }
}

public class GymPricing implements AddOnPricing{
    @Override
    public Money price(){
        return new Money(300.0);
    }
    @Override
    public String displayName() {
        return "GYM";
    }
}

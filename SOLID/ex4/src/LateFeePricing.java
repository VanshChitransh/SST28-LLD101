public class LateFeePricing implements FeePricing {
    private final int daysLate;
    private final Money pricePerDay;

    public LateFeePricing(int daysLate, Money pricePerDay) {
        this.daysLate = daysLate;
        this.pricePerDay = pricePerDay;
    }
    
    @Override
    public Money calculate() {
        return new Money(daysLate * pricePerDay.amount);
    }

    @Override
    public String displayName() {
        return "Late Fee (" + daysLate + " days @ " + pricePerDay.amount + "/day)";
    }
}

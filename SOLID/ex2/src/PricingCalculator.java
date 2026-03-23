public class PricingCalculator {
    private final TaxPolicy taxPolicy;
    private final DiscountPolicy discountPolicy;
    
    public PricingCalculator(TaxPolicy taxPolicy, DiscountPolicy discountPolicy) {
        this.taxPolicy = taxPolicy;
        this.discountPolicy = discountPolicy;
    }
    
    public PricingBreakdown calculate(String customerType, double subtotal, int distinctLines) {
        double taxPercent = taxPolicy.taxPercent(customerType);
        double taxAmount = subtotal * taxPercent / 100.0;
        double discount = discountPolicy.discountAmount(customerType, subtotal, distinctLines);
        double total = subtotal + taxAmount - discount;
        
        return new PricingBreakdown(subtotal, taxPercent, taxAmount, discount, total);
    }
}
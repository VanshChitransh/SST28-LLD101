public class PricingBreakdown {
    public final double subtotal;
    public final double taxPercent;
    public final double taxAmount;
    public final double discount;
    public final double total;
    
    public PricingBreakdown(double subtotal, double taxPercent, double taxAmount, double discount, double total) {
        this.subtotal = subtotal;
        this.taxPercent = taxPercent;
        this.taxAmount = taxAmount;
        this.discount = discount;
        this.total = total;
    }
}
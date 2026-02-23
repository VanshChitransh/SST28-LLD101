public class MessPricing implements AddOnPricing {
    public boolean supports(AddOn a) { return a == AddOn.MESS; }
    public double price() { return 1000.0; }
}

public class LaundryPricing implements AddOnPricing {
    public boolean supports(AddOn a) { return a == AddOn.LAUNDRY; }
    public double price() { return 500.0; }
}

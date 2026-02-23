public class GymPricing implements AddOnPricing {
    public boolean supports(AddOn a) { return a == AddOn.GYM; }
    public double price() { return 300.0; }
}

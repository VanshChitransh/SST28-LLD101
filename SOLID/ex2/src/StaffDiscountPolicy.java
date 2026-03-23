public class StaffDiscountPolicy implements DiscountPolicy {
    @Override
    public double discountAmount(String customerType, double subtotal, int distinctLines) {
        return distinctLines >= 3 ? 50.0 : 0.0;
    }
}
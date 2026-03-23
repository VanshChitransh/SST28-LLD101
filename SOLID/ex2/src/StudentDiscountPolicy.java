public class StudentDiscountPolicy implements DiscountPolicy {
    @Override
    public double discountAmount(String customerType, double subtotal, int distinctLines) {
        if (subtotal > 300) return 30.0;
        return 0.0;
    }
}
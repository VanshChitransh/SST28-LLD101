public class DefaultDiscountPolicy implements DiscountPolicy {
    @Override
    public double discountAmount(String customerType, double subtotal, int distinctLines) {
        return 0.0;
    }
}
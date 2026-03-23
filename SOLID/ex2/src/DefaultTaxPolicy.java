public class DefaultTaxPolicy implements TaxPolicy {
    @Override
    public double taxPercent(String customerType) {
        return 8.0;
    }
}
public class StudentTaxPolicy implements TaxPolicy {
    @Override
    public double taxPercent(String customerType) {
        return 5.0;
    }
}
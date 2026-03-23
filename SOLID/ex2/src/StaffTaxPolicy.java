public class StaffTaxPolicy implements TaxPolicy {
    @Override
    public double taxPercent(String customerType) {
        return 2.0;
    }
}
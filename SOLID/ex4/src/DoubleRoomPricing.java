public class DoubleRoomPricing implements RoomPricing {
    @Override
    public Money monthlyFee() {
        return new Money(15000.0);
    }

    @Override
    public Money depositFee() {
        return new Money(5000.0);
    }

    @Override
    public String displayName() {
        return "DOUBLE";
    }
}

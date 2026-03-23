public class SingleRoomPricing implements RoomPricing{
    @Override
    public Money monthlyFee(){
        return new Money(14000.0);
    }

    @Override
    public Money depositFee() {
        return new Money(5000.0);
    }

    @Override
    public String displayName() {
        return "SINGLE";
    }
}

public class SingleRoomPricing implements RoomPricing {
    public boolean supports(int roomType) { return roomType == LegacyRoomTypes.SINGLE; }
    public double basePrice() { return 14000.0; }
}

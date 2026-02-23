public class DoubleRoomPricing implements RoomPricing {
    public boolean supports(int roomType) { return roomType == LegacyRoomTypes.DOUBLE; }
    public double basePrice() { return 15000.0; }
}

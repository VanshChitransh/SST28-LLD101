public class DeluxeRoomPricing implements RoomPricing {
    public boolean supports(int roomType) { return roomType == LegacyRoomTypes.DELUXE; }
    public double basePrice() { return 16000.0; }
}

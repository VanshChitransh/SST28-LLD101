public class TripleRoomPricing implements RoomPricing {
    public boolean supports(int roomType) { return roomType == LegacyRoomTypes.TRIPLE; }
    public double basePrice() { return 12000.0; }
}

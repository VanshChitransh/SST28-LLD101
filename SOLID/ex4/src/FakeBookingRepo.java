import java.util.List;

public class FakeBookingRepo {
    public void save(String id, RoomPricing room, List<AddOnPricing> addOns, List<FeePricing> fees,Money monthly, Money deposit) {
        System.out.println("Saved booking: " + id);
    }
}
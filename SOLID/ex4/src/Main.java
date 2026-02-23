import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");

        List<RoomPricing> rooms = List.of(
            new SingleRoomPricing(),
            new DoubleRoomPricing(),
            new TripleRoomPricing(),
            new DeluxeRoomPricing()
        );

        List<AddOnPricing> addOns = List.of(
            new MessPricing(),
            new LaundryPricing(),
            new GymPricing()
        );

        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        HostelFeeCalculator calc = new HostelFeeCalculator(rooms, addOns, new FakeBookingRepo(), 16000.0);
        calc.process(req);
    }
}

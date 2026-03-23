import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");

        HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo());

        RoomPricing room = new DoubleRoomPricing();
        List<AddOnPricing> addOns = Arrays.asList(new LaundryPricing(), new MessPricing());

        List<FeePricing> fees = List.of(
            new LateFeePricing(3,new Money(500))
        );

        calc.process(room, addOns, fees);
    }
}
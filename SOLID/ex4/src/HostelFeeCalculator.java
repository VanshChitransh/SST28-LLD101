import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;

    public HostelFeeCalculator(FakeBookingRepo repo) { this.repo = repo; }

    // OCP violation: switch + add-on branching + printing + persistence.
    public void process(RoomPricing room, List<AddOnPricing> addOns, List<FeePricing> fees) {
        Money monthly = room.monthlyFee();
        
        for(AddOnPricing addOn : addOns){
            monthly = monthly.plus(addOn.price());
        }

        Money deposit = room.depositFee();

       for(FeePricing l: fees){
            monthly = monthly.plus(l.calculate());
       }

        //Generating Id
        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));

         ReceiptPrinter.print(room, addOns, fees, monthly, deposit);
        repo.save(bookingId, room, addOns, fees, monthly, deposit);
    }
}
import java.util.*;

public class ReceiptPrinter {
    public static void print(RoomPricing room, List<AddOnPricing> addOns,List<FeePricing> fees, Money monthly, Money deposit) {
        System.out.println("Room: " + room.displayName() + " | AddOns: " + getAddOns(addOns) + " | Extra: "+ getFees(fees));
        System.out.println("Monthly: " + monthly.amount);
        System.out.println("Deposit: " + deposit.amount);
        System.out.println("TOTAL DUE NOW: " + monthly.plus(deposit));
    }

    private static List<String> getAddOns(List<AddOnPricing> addOns){
        List<String> names = new ArrayList<>();
        for(AddOnPricing addOn : addOns){
            names.add(addOn.displayName());
        }
        return names;
    }

    private static List<String> getFees(List<FeePricing> fees){
        List<String> extra = new ArrayList<>();
        for(FeePricing fee : fees){
            extra.add(fee.displayName());
        }
        return extra;
    }
}
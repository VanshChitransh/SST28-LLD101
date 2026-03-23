import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Cafeteria Billing ===");

        InvoiceStore store = new FileStore();

        // First invoice: Student
        TaxPolicy studentTax = new StudentTaxPolicy();
        DiscountPolicy studentDiscount = new StudentDiscountPolicy();
        CafeteriaSystem studentSys = new CafeteriaSystem(studentTax, studentDiscount, store);
        
        studentSys.addToMenu(new MenuItem("M1", "Veg Thali", 80.00));
        studentSys.addToMenu(new MenuItem("C1", "Coffee", 30.00));
        studentSys.addToMenu(new MenuItem("S1", "Sandwich", 60.00));

        List<OrderLine> studentOrder = List.of(
                new OrderLine("M1", 2),
                new OrderLine("C1", 1)
        );
        studentSys.checkout("student", studentOrder);

        System.out.println();

        // Second invoice: Staff
        TaxPolicy staffTax = new StaffTaxPolicy();
        DiscountPolicy staffDiscount = new StaffDiscountPolicy();
        CafeteriaSystem staffSys = new CafeteriaSystem(staffTax, staffDiscount, store);
        
        staffSys.addToMenu(new MenuItem("M1", "Veg Thali", 80.00));
        staffSys.addToMenu(new MenuItem("C1", "Coffee", 30.00));
        staffSys.addToMenu(new MenuItem("S1", "Sandwich", 60.00));

        List<OrderLine> staffOrder = List.of(
                new OrderLine("S1", 1),
                new OrderLine("C1", 2),
                new OrderLine("M1", 1)
        );
        staffSys.checkout("staff", staffOrder);
    }
}
import java.util.*;

public class InvoiceFormatter {
    private final Map<String, MenuItem> menu;
    
    public InvoiceFormatter(Map<String, MenuItem> menu) {
        this.menu = menu;
    }
    
    public String format(String invoiceId, List<OrderLine> lines, PricingBreakdown pricing) {
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invoiceId).append("\n");
        
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            out.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTotal));
        }
        
        out.append(String.format("Subtotal: %.2f\n", pricing.subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", pricing.taxPercent, pricing.taxAmount));
        out.append(String.format("Discount: -%.2f\n", pricing.discount));
        out.append(String.format("TOTAL: %.2f\n", pricing.total));
        
        return out.toString();
    }
}
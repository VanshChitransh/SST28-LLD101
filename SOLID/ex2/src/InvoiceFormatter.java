import java.util.*;

public class InvoiceFormatter {
    public String format(String invoiceId, List<String> lines,
                         double subtotal, double taxPct, double tax,
                         double discount, double total) {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice# ").append(invoiceId).append("\n");
        for (String line : lines) {
            sb.append(line).append("\n");
        }
        sb.append(String.format("Subtotal: %.2f\n", subtotal));
        sb.append(String.format("Tax(%.0f%%): %.2f\n", taxPct, tax));
        sb.append(String.format("Discount: -%.2f\n", discount));
        sb.append(String.format("TOTAL: %.2f\n", total));
        return sb.toString();
    }
}

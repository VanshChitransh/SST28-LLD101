import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final TaxPolicy taxPolicy;
    private final DiscountPolicy discountPolicy;
    private final InvoiceStore store;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(TaxPolicy taxPolicy, DiscountPolicy discountPolicy, InvoiceStore store) {
        this.taxPolicy = taxPolicy;
        this.discountPolicy = discountPolicy;
        this.store = store;
    }

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format +
    // persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            subtotal += item.price * l.qty;
        }

        PricingCalculator pricingCalc = new PricingCalculator(taxPolicy, discountPolicy);
        PricingBreakdown pricing = pricingCalc.calculate(customerType, subtotal, lines.size());

        InvoiceFormatter formatter = new InvoiceFormatter(menu);
        String invoice = formatter.format(invId, lines, pricing);
        
        InvoicePresenter presenter = new InvoicePresenter();
        presenter.printInvoice(invoice);
        store.save(invId, invoice);
        presenter.printConfirmation(invId, invoiceSeq);
    }
}
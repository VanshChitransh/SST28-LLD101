public class InvoicePresenter {
    public void printInvoice(String invoice) {
        System.out.print(invoice);
    }
    
    public void printConfirmation(String invId, int lineCount) {
        System.out.println("Saved invoice: " + invId + " (lines=" + lineCount + ")");
    }
}
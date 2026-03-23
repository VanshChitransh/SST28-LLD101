public abstract class Exporter {
    /**
     * Contract:
     * - Precondition: req must not be null
     * - Precondition: req.title and req.body may be null (treated as empty)
     * - Postcondition: Always returns non-null ExportResult
     * - Postcondition: Subclasses must NOT throw for valid inputs; use error result instead
     */

    public final ExportResult doExport(ExportRequest req) {
        if (req == null) {
            return new ExportResult("Request cannot be null");
        }
        return export(req);
    }
    
    public abstract ExportResult export(ExportRequest req);
}
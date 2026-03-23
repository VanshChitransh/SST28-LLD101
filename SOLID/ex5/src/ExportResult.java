public class ExportResult {
    public final String contentType;
    public final byte[] bytes;

    private final boolean success;
    private final String error;

    public ExportResult(String contentType, byte[] bytes) {
        this.contentType = contentType;
        this.bytes = bytes;
        this.success = true;
        this.error = null;
    }

    public ExportResult(String error) {
        this.contentType = null;
        this.bytes = null;
        this.success = false;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }
}
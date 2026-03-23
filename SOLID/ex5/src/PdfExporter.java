import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        
        String title = req.title == null ? "" : req.title;
        String body = req.body == null ? "" : req.body;
        String content = title +  body;


        if (content.length() > 20) {
           return new ExportResult("PDF cannot handle > 20 chars");
        }
        
        String fakePdf = "PDF(" + title + "):" + body;
        return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}
import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {

        String title = req.title == null ? "" : req.title;
        String body = req.body == null ? "" : req.body;

        // Escape special characters for CSV format
        String safeTitle = escapeCsv(title);
        String safeBody = escapeCsv(body);
        String csv = "title,body\n" + safeTitle + "," + safeBody + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }

    private String escapeCsv(String value) {
        return value.replace("\n", " ").replace(",", ";").replace("\"", "\"\"");
    }
}
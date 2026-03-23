import java.nio.charset.StandardCharsets;

public class JsonExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        String title = req.title == null ? "" : req.title;
        String body = req.body == null ? "" : req.body;

        String safeTitle = escapeJson(title);
        String safeBody = escapeJson(body);

        String json = "{\"title\":\"" + safeTitle + "\",\"body\":\"" + safeBody + "\"}";
        return new ExportResult("application/json", json.getBytes(StandardCharsets.UTF_8));
    }

    private String escapeJson(String value) {
        return value.replace("\\", "\\\\")
                    .replace("\"", "\\\"")
                    .replace("\n", "\\n");
    }
}
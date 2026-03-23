import java.util.*;

public class OnboardingService {
    private final StudentRepository db;

    public OnboardingService(StudentRepository db) {
        this.db = db;
    }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        OnboardingPresenter.printInput(raw);

        Map<String, String> kv = RawInputParses.parse(raw);

        List<String> errors = StudentValidator.validates(kv);

        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        if (!errors.isEmpty()) {
            OnboardingPresenter.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        db.save(rec);
        int totalCount = db.count();
        OnboardingPresenter.printSuccess(rec, totalCount);
    }
}
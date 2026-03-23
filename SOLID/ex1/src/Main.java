public class Main {
    public static void main(String[] args) {
        System.out.println("=== Student Onboarding ===");
        FakeDb db = new FakeDb();
        OnboardingService svc = new OnboardingService(db);

        String raw = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        svc.registerFromRawInput(raw);

        String raw2 = "name=John;email=johndoenotdoanything;phone=98ABCD7891;program=DS/ML";
        svc.registerFromRawInput(raw2);

        System.out.println();
        System.out.println("-- DB DUMP --");
        System.out.print(TextTable.render3(db));
    }
}
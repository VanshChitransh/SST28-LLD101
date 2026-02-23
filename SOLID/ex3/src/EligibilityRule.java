// each rule checks one condition and returns a reason if it fails, or null if it passes
public interface EligibilityRule {
    String evaluate(StudentProfile s);
}

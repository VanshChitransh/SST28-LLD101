public class DisciplinaryRule implements EligibilityRule {
    @Override
    public RuleResult evaluate(StudentProfile s) {
        if (s.disciplinaryFlag != LegacyFlags.NONE) {
            return new RuleResult(false, "disciplinary flag set");
        }
        return new RuleResult(true, null);
    }
}
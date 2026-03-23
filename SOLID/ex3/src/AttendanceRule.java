public class AttendanceRule implements EligibilityRule {
    private final double threshold;
    
    public AttendanceRule(double threshold) {
        this.threshold = threshold;
    }
    
    @Override
    public RuleResult evaluate(StudentProfile s) {
        if (s.attendancePct < threshold) {
            return new RuleResult(false, "attendance below " + threshold);
        }
        return new RuleResult(true, null);
    }
}
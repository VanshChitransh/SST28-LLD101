public class CGRRule implements EligibilityRule {
    private final double threshold;

    public CGRRule(double threshold){
        this.threshold = threshold;
    }

    @Override
    public RuleResult evaluate(StudentProfile s) {
        if (s.cgr < threshold) {
            return new RuleResult(false, "cgr below " + threshold);
        }
        return new RuleResult(true, null);
    }
}

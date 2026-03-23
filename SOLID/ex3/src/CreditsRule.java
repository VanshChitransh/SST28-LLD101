public class CreditsRule implements EligibilityRule {
    private final int threshold;
    
    public CreditsRule(int threshold) {
        this.threshold = threshold;
    }
    
    @Override
    public RuleResult evaluate(StudentProfile s) {
        if (s.earnedCredits < threshold) {
            return new RuleResult(false, "credits below " + threshold);
        }
        return new RuleResult(true, null);
    }
}
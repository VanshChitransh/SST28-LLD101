public class RuleConfig {
    public final double cgrThreshold;
    public final double attendanceThreshold;
    public final int creditsThreshold;
    
    public RuleConfig(double cgrThreshold, double attendanceThreshold, int creditsThreshold) {
        this.cgrThreshold = cgrThreshold;
        this.attendanceThreshold = attendanceThreshold;
        this.creditsThreshold = creditsThreshold;
    }
}
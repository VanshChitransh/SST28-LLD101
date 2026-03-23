import java.util.*;

public class ProgramRegistry {
    private static List<String> allowedPrograms = Arrays.asList("CSE", "AI", "SWE");
    
    public static void setAllowedPrograms(List<String> programs) {
        allowedPrograms = new ArrayList<>(programs);
    }
    
    public static List<String> getAllowedPrograms() {
        return new ArrayList<>(allowedPrograms);
    }
    
    public static boolean isValidProgram(String program) {
        return allowedPrograms.contains(program);
    }
}
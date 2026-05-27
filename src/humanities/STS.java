package humanities;
/**
 * STS.java
 * Abstract sub-intermediate for Science, Technology & Society courses.
 * Extends HistHumGER → extends Course (4-level depth).
 */
public abstract class STS extends HistHumGER {

    private String  focusArea;         // e.g. "Ethics", "Policy", "Environment"
    private boolean interdisciplinary; // True if course draws from multiple fields

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    public STS(String crn, String courseTitle, String courseCode, String professor, String section,
               int creditHours, double creditFee, boolean isRequired, boolean isElective,
               String location, String[] days, String time,
               String[] prerequisites, int capacity,
               boolean isGER, String gerCategory, boolean hasResearchPaper,
               String focusArea, boolean interdisciplinary) {

        super(crn, courseTitle, courseCode, professor, section, creditHours, creditFee,
              isRequired, isElective, location, days, time, prerequisites, capacity,
              isGER, gerCategory, hasResearchPaper);

        this.focusArea        = focusArea;
        this.interdisciplinary = interdisciplinary;
    }

    // -------------------------------------------------------------------------
    // Override
    // -------------------------------------------------------------------------

    /**
     * courseDetails() — adds focus area and interdisciplinary flag.
     *
     * TEAM TODO: Call super.courseDetails() then append STS-specific lines.
     */
    @Override
    public String courseDetails() {
        // TEAM TODO: build and return the full details string
        return super.courseDetails() + " (Focus: " + focusArea + ", Interdisciplinary: " + interdisciplinary + ")"; // placeholder — replace this
    }

    // Getters
    public String  getFocusArea()       { return focusArea; }
    public boolean isInterdisciplinary() { return interdisciplinary; }
}

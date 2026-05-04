/**
 * HistHumGER.java
 * Abstract intermediate for History, Humanities, and General Education
 * Requirement (GER) 200-level courses.
 *
 * TEAM TODO: This is the parent of both COM (abstract) and STS (abstract),
 * which are themselves parents of the concrete leaf classes.
 * That gives you the 4-level depth: Course → HistHumGER → COM → COM200.
 */
public abstract class HistHumGER extends Course {

    private boolean isGER;           // True if this satisfies a General Ed Requirement
    private String  gerCategory;     // e.g. "Social Science", "Humanities"
    private boolean hasResearchPaper; // True if the course requires a research paper

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    public HistHumGER(String crn, String courseTitle, String courseCode, String professor, String section,
                      int creditHours, double creditFee, boolean isRequired, boolean isElective,
                      String location, String[] days, String time,
                      String[] prerequisites, int capacity,
                      boolean isGER, String gerCategory, boolean hasResearchPaper) {

        super(crn, courseTitle, courseCode, professor, section, creditHours, creditFee,
              isRequired, isElective, location, days, time, prerequisites, capacity);

        this.isGER            = isGER;
        this.gerCategory      = gerCategory;
        this.hasResearchPaper = hasResearchPaper;
    }

    // -------------------------------------------------------------------------
    // Overrides
    // -------------------------------------------------------------------------

    /**
     * calculateTuition() — applies a small GER discount if isGER is true.
     *
     * TEAM TODO: Decide on a discount amount (e.g. $50 off) and implement.
     * Example: base = creditHours * creditFee; if (isGER) base -= 50;
     */
    @Override
    public double calculateTuition() {
        // TEAM TODO: implement with optional GER discount
        double baseTuition = this.getCreditHours() * this.getCreditFee();
        if (isGER) {
            baseTuition -= 50.0; // Apply GER discount
        }
        return baseTuition;
    }

    /**
     * courseDetails() — adds GER flag and category.
     *
     * TEAM TODO: Call baseCourseDetails() then append GER-specific lines.
     */
    @Override
    public String courseDetails() {
        // TEAM TODO: build and return the full details string
        String details = super.courseDetails(); // call the base version to get the common block
        details += "\nGER: " + isGER;
        details += "\nGER Category: " + gerCategory;
        details += "\nResearch Paper Required: " + hasResearchPaper;
        return details; // placeholder — replace this
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    public boolean isGER()             { return isGER; }
    public String  getGerCategory()    { return gerCategory; }
    public boolean hasResearchPaper()  { return hasResearchPaper; }
}

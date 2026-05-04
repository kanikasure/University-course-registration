/**
 * Math.java
 * Abstract intermediate class for all Math courses.
 *
 * TEAM TODO: Same pattern as CompSci — abstract, adds department-level
 * fields, overrides calculateTuition() and courseDetails().
 * Concrete classes MATH111, MATH112, MATH105, MATH333 extend this.
 *
 * NOTE: Avoid naming this "Math" if it conflicts with java.lang.Math in
 * your IDE. You can rename it to "MathCourse" if needed.
 */
public abstract class MathCourse extends Course {

    private String  mathSubfield;        // e.g. "Calculus", "Statistics", "Linear Algebra"
    private boolean requiresCalculator;  // True if a graphing calculator is required
    private int     recitationSessions;    // Number of recitation sessions available per week

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    public MathCourse(String crn, String courseTitle, String professor, String section,
                      int creditHours, double creditFee, boolean isRequired, boolean isElective,
                      String location, String[] days, String time,
                      String[] prerequisites, int capacity,
                      String mathSubfield, boolean requiresCalculator, int recitationSessions) {

        super(crn, courseTitle, professor, section, creditHours, creditFee,
              isRequired, isElective, location, days, time, prerequisites, capacity);

        this.mathSubfield       = mathSubfield;
        this.requiresCalculator = requiresCalculator;
        this.recitationSessions = recitationSessions;
    }

    // -------------------------------------------------------------------------
    // Overrides
    // -------------------------------------------------------------------------

    /**
     * calculateTuition() — standard formula, no extra fees for Math courses.
     *
     * TEAM TODO: Formula is simply creditHours * creditFee.
     * MATH333 will override this again to add an upper-division fee.
     */
    @Override
    public double calculateTuition() {
        // TEAM TODO: return creditHours * creditFee
        double base = this.getCreditHours() * this.getCreditFee();
        return base;
    }

    /**
     * courseDetails() — adds math subfield, calculator requirement, recitation info.
     *
     * TEAM TODO: Call baseCourseDetails() then append the Math-specific lines.
     */
    @Override
    public String courseDetails() {
        // TEAM TODO: build and return the full details string
        String details = super.courseDetails(); // call the base version to get the common block
        // Append Math-specific information
        details += "\nMath Subfield: " + this.getMathSubfield();
        details += "\nRequires Calculator: " + (this.requiresCalculator() ? "Yes" : "No");
        details += "\nRecitation Sessions per Week: " + this.getRecitationSessions();
        return details;
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    public String  getMathSubfield()      { return mathSubfield; }
    public boolean requiresCalculator()   { return requiresCalculator; }
    public int     getRecitationSessions()  { return recitationSessions; }
}

/**
 * Math.java
 * Abstract intermediate class for all Math courses.
 *
 * TEAM TODO: Same pattern as CompSci — abstract, adds department-level
 * fields, overrides calculateTuition() and courseDetails().
 * Concrete classes MATH111, MATH112, MATH105, MATH353 extend this.
 *
 * NOTE: Avoid naming this "Math" if it conflicts with java.lang.Math in
 * your IDE. You can rename it to "MathCourse" if needed.
 */
public abstract class MathCourse extends Course {

    private String  mathSubfield;        // e.g. "Calculus", "Statistics", "Linear Algebra"
    private boolean requiresCalculator;  // True if a graphing calculator is required
    private int     tutoringSessions;    // Number of tutoring sessions available per week

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    public MathCourse(String crn, String courseTitle, String professor, String section,
                      int creditHours, double creditFee, boolean isRequired, boolean isElective,
                      String location, String[] days, String time,
                      String[] prerequisites, int capacity,
                      String mathSubfield, boolean requiresCalculator, int tutoringSessions) {

        super(crn, courseTitle, professor, section, creditHours, creditFee,
              isRequired, isElective, location, days, time, prerequisites, capacity);

        this.mathSubfield       = mathSubfield;
        this.requiresCalculator = requiresCalculator;
        this.tutoringSessions   = tutoringSessions;
    }

    // -------------------------------------------------------------------------
    // Overrides
    // -------------------------------------------------------------------------

    /**
     * calculateTuition() — standard formula, no extra fees for Math courses.
     *
     * TEAM TODO: Formula is simply creditHours * creditFee.
     * MATH353 will override this again to add an upper-division fee.
     */
    @Override
    public double calculateTuition() {
        // TEAM TODO: return creditHours * creditFee
        return 0.0; // placeholder — replace this
    }

    /**
     * courseDetails() — adds math subfield, calculator requirement, tutoring info.
     *
     * TEAM TODO: Call baseCourseDetails() then append the Math-specific lines.
     */
    @Override
    public String courseDetails() {
        // TEAM TODO: build and return the full details string
        return ""; // placeholder — replace this
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    public String  getMathSubfield()      { return mathSubfield; }
    public boolean requiresCalculator()   { return requiresCalculator; }
    public int     getTutoringSessions()  { return tutoringSessions; }
}

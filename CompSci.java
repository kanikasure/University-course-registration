/**
 * CompSci.java
 * Abstract intermediate class for all Computer Science courses.
 * Sits between Course (root) and concrete CS course classes.
 *
 * TEAM TODO: Notice this class is abstract — you cannot instantiate it
 * directly. It exists to hold fields and logic shared by CS100, CS113, CS114.
 */
public abstract class CompSci extends Course {

    // Fields added at the CS department level
    private String  programmingLanguage; // e.g. "Java", "Python"
    private boolean hasLabSection;       // True if there is a weekly lab
    private double  labFee;              // Extra charge if hasLabSection is true

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * TEAM TODO: This constructor calls super(...) to set all the Course fields,
     * then sets the three CS-specific fields.
     * Your concrete classes (CS100, CS113, CS114) will call super(...) here.
     */
    public CompSci(String crn, String courseTitle, String professor, String section,
                   int creditHours, double creditFee, boolean isRequired, boolean isElective,
                   String location, String[] days, String time,
                   String[] prerequisites, int capacity,
                   String programmingLanguage, boolean hasLabSection, double labFee) {

        super(crn, courseTitle, professor, section, creditHours, creditFee,
              isRequired, isElective, location, days, time, prerequisites, capacity);

        this.programmingLanguage = programmingLanguage;
        this.hasLabSection       = hasLabSection;
        this.labFee              = labFee;
    }

    // -------------------------------------------------------------------------
    // Overrides
    // -------------------------------------------------------------------------

    /**
     * calculateTuition() — adds labFee on top of the base tuition.
     *
     * TEAM TODO: The formula is:
     *   base = creditHours * creditFee   (from Course fields)
     *   total = base + labFee (if hasLabSection)
     * Fill in the body below.
     */
    @Override
    public double calculateTuition() {
        double base = getCreditHours() * getCreditFee();
        // TEAM TODO: add labFee if hasLabSection, then return the total
        return 0.0; // placeholder — replace this
    }

    /**
     * courseDetails() — adds programming language and lab info on top of base.
     *
     * TEAM TODO: Call baseCourseDetails() (inherited from Course) to get
     * the common block, then append the CS-specific lines.
     */
    @Override
    public String courseDetails() {
        // TEAM TODO: build and return the full details string
        return ""; // placeholder — replace this
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    public String  getProgrammingLanguage() { return programmingLanguage; }
    public boolean hasLabSection()          { return hasLabSection; }
    public double  getLabFee()              { return labFee; }
}

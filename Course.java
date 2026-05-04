/**
 * Course.java
 * Abstract root class for the Course Registration System.
 * All course types inherit these fields and methods.
 *
 * TEAM TODO: Read every field and method below. Make sure you can explain
 * what each one does before your demo.
 */
public abstract class Course implements Comparable<Course> {

    // -------------------------------------------------------------------------
    // Fields — inherited by every subclass
    // -------------------------------------------------------------------------

    private String  crn;           // Unique course ID — used in equals()
    private String  courseTitle;   // e.g. "Introduction to Programming"
    private String courseCode;    // e.g. "CS101"
    private String  professor;     // Instructor name
    private String  section;       // e.g. "001"
    private int     creditHours;   // Used in compareTo()
    private double  creditFee;     // Cost per credit hour
    private boolean isRequired;    // True if this is a required course
    private boolean isElective;    // True if this counts as an elective
    private String  location;      // Building + room, e.g. "Tiernan 101"
    private String[] days;         // e.g. {"Mon", "Wed", "Fri"}
    private String  time;          // e.g. "10:00-11:15"
    private String[] prerequisites; // Array of CRNs that must be completed first
    private int     enrolled;      // Current number of enrolled students
    private int     capacity;      // Maximum seats in this section

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * TEAM TODO: This constructor sets all the shared fields.
     * When you write subclass constructors, call super(...) with these same
     * arguments first, then set the subclass-specific fields beneath it.
     */
    public Course(String crn, String courseTitle, String courseCode, String professor, String section,
                  int creditHours, double creditFee, boolean isRequired, boolean isElective,
                  String location, String[] days, String time,
                  String[] prerequisites, int capacity) {

        this.crn          = crn;
        this.courseTitle  = courseTitle;
        this.courseCode   = courseCode;
        this.professor    = professor;
        this.section      = section;
        this.creditHours  = creditHours;
        this.creditFee    = creditFee;
        this.isRequired   = isRequired;
        this.isElective   = isElective;
        this.location     = location;
        this.days         = days;
        this.time         = time;
        this.prerequisites = prerequisites;
        this.capacity     = capacity;
        this.enrolled     = 0; // Starts empty
    }

    // -------------------------------------------------------------------------
    // Abstract methods — every concrete subclass MUST override both of these
    // -------------------------------------------------------------------------

    /**
     * Print a full, readable summary of this course.
     * TEAM TODO: Each subclass should call super.courseDetails() first,
     * then add its own extra lines (lab fee, calculator required, etc.).
     */
    //instead change this to toString
    public String toString(){
        return "Course title: " + courseTitle + "\nCourse code: " + courseCode + "\nProfessor: " + professor + "\nSection: " + section;
    }

    /**
     * Calculate the total tuition cost for this course.
     * Base formula: creditHours * creditFee
     * TEAM TODO: Subclasses override this to add extra fees or discounts.
     */
    public abstract double calculateTuition();

    // -------------------------------------------------------------------------
    // Concrete shared methods — subclasses inherit these, no need to override
    // -------------------------------------------------------------------------

    /**
     * equals() — compares two courses by CRN (unique ID).
     * Required by the rubric.
     *
     * TEAM TODO: Understand the three checks below:
     *   1. Same object reference? Immediately true.
     *   2. Wrong type or null? Immediately false.
     *   3. Cast and compare the CRN strings.
     */

    //made changes here- removed unecessary check conditions
    @Override
    public boolean equals(Object obj) {
        return this.crn.equals(((Course)obj).crn);
    }

    /**
     * compareTo() — compares two courses by credit hours.
     * Required by the rubric (implements Comparable<Course>).
     * Used by RegistrationManager.sortByCreditHours().
     *
     * TEAM TODO: Integer.compare does the math for you — returns negative,
     * zero, or positive, which is exactly what compareTo must return.
     */

    //changed the body of the method to include conditional statements
    @Override
    public int compareTo(Course other) {
        if (this.creditHours== other.getCreditHours()) return 0;
        else if (this.creditHours > other.getCreditHours()) return 1;
        else return -1;
    }

    /**
     * Returns true if there is at least one open seat.
     */
    public boolean isAvailable() {
        return enrolled < capacity;
    }

    /**
     * Enroll one student in this course.
     * Throws EnrollmentException if the section is full.
     *
     * TEAM TODO: You will also call this from the menu. Add a second
     * check here if you want to validate prerequisites at enrollment time.
     */
    public void enroll() throws EnrollmentException {
        if (!isAvailable()) {
            throw new EnrollmentException("Cannot enroll in " + courseCode
                + " (CRN: " + crn + "): section is full.");
        }
        enrolled++;
    }

    /**
     * Recursive prerequisite checker.
     *
     * Checks whether targetCRN appears anywhere in this course's
     * prerequisites array, starting at index 0.
     *
     * TEAM TODO: Trace through this method with a small example for your report.
     *   Base case 1: index has passed the end of the array → not found, return false.
     *   Base case 2: current element matches targetCRN → found, return true.
     *   Recursive case: check the next index.
     */
    public boolean hasPrerequisite(String targetCRN, int index) {
        // Base case 1 — searched the whole array, not found
        if (index >= prerequisites.length) return false;

        // Base case 2 — found it
        if (prerequisites[index].equals(targetCRN)) return true;

        // Recursive case — keep looking
        return hasPrerequisite(targetCRN, index + 1);
    }

    /**
     * Helper to format days array as a readable string, e.g. "Mon Wed Fri".
     * TEAM TODO: Use this inside courseDetails() so you don't repeat the loop.
     */
    //made changes to change string buider to string
    protected String formatDays() {
        String str = "";
        for (int i = 0; i < days.length; i++) {
            str += days[i];
            if (i < days.length - 1) str += " ";
        }
        return str;
    }

    /**
     * Base courseDetails() string shared by all courses.
     * TEAM TODO: Call super.baseCourseDetails() inside each subclass
     * courseDetails() so you don't duplicate this block everywhere.
     */
    protected String courseDetails() {
        return "CRN: " + crn + "\n"
             + "Title: " + courseTitle + "\n"
             + "Professor: " + professor + "\n"
             + "Section: " + section + "\n"
             + "Credits: " + creditHours + " | Fee/credit: $" + creditFee + "\n"
             + "Required: " + isRequired + " | Elective: " + isElective + "\n"
             + "Location: " + location + "\n"
             + "Days: " + formatDays() + " | Time: " + time + "\n"
             + "Seats: " + enrolled + "/" + capacity + "\n"
             + "Tuition: $" + String.format("%.2f", calculateTuition());
    }

    // -------------------------------------------------------------------------
    // Getters — add setters if your menu needs them
    // -------------------------------------------------------------------------

    public String  getCRN()          { return crn; }
    public String  getCourseTitle()  { return courseTitle; }
    public String  getCourseCode()   { return courseCode; }
    public String  getProfessor()    { return professor; }
    public String  getSection()      { return section; }
    public int     getCreditHours()  { return creditHours; }
    public double  getCreditFee()    { return creditFee; }
    public boolean isRequired()      { return isRequired; }
    public boolean isElective()      { return isElective; }
    public String  getLocation()     { return location; }
    public String[] getDays()        { return days; }
    public String  getTime()         { return time; }
    public String[] getPrerequisites() { return prerequisites; }
    public int     getEnrolled()     { return enrolled; }
    public int     getCapacity()     { return capacity; }
}

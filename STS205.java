// =============================================================================
// STS205.java — Concrete leaf class
// =============================================================================

/**
 * STS205.java — Intro to Research Methods.
 */
class STS205 extends STS {

    private String labName;

    public STS205(String crn, String professor, String section, String location,
                  String[] days, String time, int capacity, String labName) {

        super(
            crn,
            "Intro to Research Methods",
            professor,
            section,
            3,
            400.00,
            false,
            true,
            location,
            days,
            time,
            new String[]{"STS201"},       // requires STS201
            capacity,
            true,
            "Humanities",
            true,
            "Ethics",                     // focusArea
            false
        );

        this.labName = labName;
    }

    @Override
    public String courseDetails() {
        // TEAM TODO: call super.courseDetails() and append labName
        return super.courseDetails() + " (Lab: " + labName + ")"; // placeholder — replace this
    }

    public String getLabName() { return labName; }
}

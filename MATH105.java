// =============================================================================
// MATH105.java — Concrete leaf class
// =============================================================================

/**
 * MATH105.java — Elementary Probability and Statistics. Entry-level, no prerequisites.
 */
class MATH105 extends MathCourse {

    public MATH105(String crn, String professor, String section, String location,
                   String[] days, String time, int capacity) {

        super(
            crn,
            "Elementary Probability and Statistics",
            professor,
            section,
            3,
            420.00,
            false,
            true,                      // counts as elective
            location,
            days,
            time,
            new String[]{},
            capacity,
            "Probability and Statistics",
            true,                     // no graphing calculator required
            2                          // extra tutoring sessions
        );
    }

    @Override
    public String courseDetails() {
        // TEAM TODO: implement
        String details = super.courseDetails(); // call the base version to get the common block
        details += " | Prerequisites: None";
        return details; // placeholder — replace this
    }
}



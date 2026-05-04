// =============================================================================
// MATH112.java — Concrete leaf class
// =============================================================================

/**
 * MATH112.java — Calculus II. Prerequisite: MATH111.
 */
class MATH112 extends MathCourse {

    public MATH112(String crn, String professor, String section, String location,
                   String[] days, String time, int capacity) {

        super(
            crn,
            "Calculus II",
            "MATH112",
            professor,
            section,
            4,
            420.00,
            true,
            false,
            location,
            days,
            time,
            new String[]{"MATH111"},
            capacity,
            "Calculus",
            false,                     // does not require calculator
            1                          // tutoringSessions per week
        );
    }

    @Override
    public String courseDetails() {
        // TEAM TODO: implement
        String details = super.courseDetails(); // call the base version to get the common block
        details += " | Prerequisites: MATH111";
        return details; // placeholder — replace this
    }
}



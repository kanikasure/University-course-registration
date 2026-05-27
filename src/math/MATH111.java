package math;
// =============================================================================
// MATH111.java — Concrete leaf class
// =============================================================================

/**
 * MATH111.java — Calculus I. No prerequisites.
 */
public class MATH111 extends MathCourse {

    public MATH111(String crn, String professor, String section, String location,
                   String[] days, String time, int capacity) {

        super(
            crn,
            "Calculus I",
            "MATH111",
            professor,
            section,
            4,                         // 4-credit course
            420.00,
            true,
            false,
            location,
            days,
            time,
            new String[]{},            // no prerequisites
            capacity,
            "Calculus",                // mathSubfield
            false,                     // does not require calculator
            1                         // tutoringSessions per week
        );
    }

    @Override
    public String courseDetails() {
        // TEAM TODO: call super.courseDetails() and append any MATH111-specific info
        String details = super.courseDetails(); // call the base version to get the common block
        details += " | Prerequisites: None";
        return details; // placeholder — replace this
    }
}




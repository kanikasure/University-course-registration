// =============================================================================
// MATH111.java — Concrete leaf class
// =============================================================================

/**
 * MATH111.java — Calculus I. No prerequisites.
 */
public class MATH111 extends MathCourse {

    public MATH111(String professor, String section, String location,
                   String[] days, String time, int capacity) {

        super(
            "MATH111",
            "Calculus I",
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
            true,                      // requiresCalculator
            3                          // tutoringSessions per week
        );
    }

    @Override
    public String courseDetails() {
        // TEAM TODO: call super.courseDetails() and append any MATH111-specific info
        return ""; // placeholder — replace this
    }
}


// =============================================================================
// MATH112.java — Concrete leaf class
// =============================================================================

/**
 * MATH112.java — Calculus II. Prerequisite: MATH111.
 */
class MATH112 extends MathCourse {

    public MATH112(String professor, String section, String location,
                   String[] days, String time, int capacity) {

        super(
            "MATH112",
            "Calculus II",
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
            true,
            3
        );
    }

    @Override
    public String courseDetails() {
        // TEAM TODO: implement
        return ""; // placeholder — replace this
    }
}


// =============================================================================
// MATH105.java — Concrete leaf class
// =============================================================================

/**
 * MATH105.java — Pre-Calculus. Entry-level, no prerequisites.
 */
class MATH105 extends MathCourse {

    public MATH105(String professor, String section, String location,
                   String[] days, String time, int capacity) {

        super(
            "MATH105",
            "Pre-Calculus",
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
            "Pre-Calculus",
            false,                     // no graphing calculator required
            5                          // extra tutoring sessions
        );
    }

    @Override
    public String courseDetails() {
        // TEAM TODO: implement
        return ""; // placeholder — replace this
    }
}


// =============================================================================
// MATH353.java — Concrete leaf class (upper division)
// =============================================================================

/**
 * MATH353.java — Upper-division course with an additional fee.
 * Overrides calculateTuition() to add upperDivisionFee on top of MathCourse's version.
 *
 * TEAM TODO: This is the one Math leaf that overrides calculateTuition() a
 * second time. Show this in your demo as an example of layered polymorphism.
 */
class MATH353 extends MathCourse {

    private boolean isUpperDivision = true;
    private double  upperDivisionFee = 120.00;

    public MATH353(String professor, String section, String location,
                   String[] days, String time, int capacity) {

        super(
            "MATH353",
            "Linear Algebra",
            professor,
            section,
            3,
            420.00,
            false,
            true,
            location,
            days,
            time,
            new String[]{"MATH112"},
            capacity,
            "Linear Algebra",
            true,
            2
        );
    }

    /**
     * Overrides MathCourse.calculateTuition() to add the upper-division fee.
     *
     * TEAM TODO: Call super.calculateTuition() to get the base math cost,
     * then add upperDivisionFee on top.
     */
    @Override
    public double calculateTuition() {
        // TEAM TODO: return super.calculateTuition() + upperDivisionFee
        return 0.0; // placeholder — replace this
    }

    @Override
    public String courseDetails() {
        // TEAM TODO: call super.courseDetails() and note upper-division fee
        return ""; // placeholder — replace this
    }

    public double getUpperDivisionFee() { return upperDivisionFee; }
}

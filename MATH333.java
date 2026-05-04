// =============================================================================
// MATH333.java — Concrete leaf class (upper division)
// =============================================================================

/**
 * MATH333.java — Upper-division course with an additional fee.
 * Overrides calculateTuition() to add upperDivisionFee on top of MathCourse's version.
 *
 * TEAM TODO: This is the one Math leaf that overrides calculateTuition() a
 * second time. Show this in your demo as an example of layered polymorphism.
 */
class MATH333 extends MathCourse {

    private boolean isUpperDivision = true;
    private double  upperDivisionFee = 120.00;

    public MATH333(String crn, String professor, String section, String location,
                   String[] days, String time, int capacity) {

        super(
            crn,
            "Probability and Statistics",
            "MATH333",
            professor,
            section,
            3,
            420.00,
            true,
            false,
            location,
            days,
            time,
            new String[]{"MATH112"},
            capacity,
            "Probability and Statistics",
            true,
            0
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
          double baseTuition = super.calculateTuition();
          return baseTuition + upperDivisionFee;
    }

    @Override
    public String courseDetails() {
        // TEAM TODO: call super.courseDetails() and note upper-division fee
        String details = super.courseDetails(); // call the base version to get the common block
        details += "\nUpper-Division Fee: $" + upperDivisionFee;
        return details; // placeholder — replace this
    }

    public double getUpperDivisionFee() { return upperDivisionFee; }
}

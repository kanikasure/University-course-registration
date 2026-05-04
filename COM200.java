// =============================================================================
// COM200.java — Concrete leaf class
// =============================================================================

/**
 * COM200.java — Communicating in Organizations. GER-eligible.
 */
public class COM200 extends COM {

    private boolean writingIntensive;

    public COM200(String crn, String professor, String section, String location,
                  String[] days, String time, int capacity) {

        super(
            crn,
            "Communicating in Organizations",
            "COM200",
            professor,
            section,
            3,
            400.00,
            false,
            true,                         // counts as elective
            location,
            days,
            time,
            new String[]{"ENGL101", "ENGL102"},               //Prerequisites required: ENGL101 and ENGL102
            capacity,
            true,                         // isGER
            "Humanities",             // gerCategory
            false,                        // no research paper
            "Written",                    // communicationMode
            false                         // no oral presentations
        );

        this.writingIntensive = true;
    }

    @Override
    public String courseDetails() {
        // TEAM TODO: call super.courseDetails() and append writingIntensive flag
        return super.courseDetails() + " (Writing Intensive)"; // placeholder — replace this
    }

    public boolean isWritingIntensive() { return writingIntensive; }
}


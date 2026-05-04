// =============================================================================
// COM201.java — Concrete leaf class
// =============================================================================

/**
 * COM201.java — Introduction to Communication and Media. GER-eligible with oral presentations.
 */
class COM201 extends COM {

    private boolean writingIntensive;

    public COM201(String crn, String professor, String section, String location,
                  String[] days, String time, int capacity) {

        super(
            crn,
            "Introduction to Communication and Media",
            professor,
            section,
            3,
            400.00,
            false,
            true,
            location,
            days,
            time,
            new String[]{"ENGL101", "ENGL102"},               //Prerequisites required: ENGL101 and ENGL102
            capacity,
            true,
            "Humanities",
            false,
            "Oral",
            true                          // hasPresentations = true
        );

        this.writingIntensive = false;
    }

    @Override
    public String courseDetails() {
        // TEAM TODO: implement
        return super.courseDetails() + " (Oral Presentations)"; // placeholder — replace this
    }

    public boolean isWritingIntensive() { return writingIntensive; }
}



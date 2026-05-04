// =============================================================================
// COM230.java — Concrete leaf class
// =============================================================================

/**
 * COM230.java — Introduction to Film. Adds a mediaType field.
 */
class COM230 extends COM {

    private String  mediaType;           // e.g. "Digital", "Film", "Social Media"
    private boolean writingIntensive;

    public COM230(String crn, String professor, String section, String location,
                  String[] days, String time, int capacity) {

        super(
            crn,
            "Introduction to Film",
            "COM230",
            professor,
            section,
            3,
            400.00,
            false,
            true,
            location,
            days,
            time,
            new String[]{"ENGL101", "ENGL102"},       // requires ENGL101 and ENGL102
            capacity,
            true,
            "Humanities",
            true,                         // hasResearchPaper
            "Digital",
            true
        );

        this.mediaType        = "Digital";
        this.writingIntensive = true;
    }

    @Override
    public String courseDetails() {
        // TEAM TODO: call super.courseDetails() and append mediaType
        return super.courseDetails() + " (" + mediaType + ")"; // placeholder — replace this
    }

    public String  getMediaType()        { return mediaType; }
    public boolean isWritingIntensive()  { return writingIntensive; }
}


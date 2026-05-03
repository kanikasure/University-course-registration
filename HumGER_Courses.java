// =============================================================================
// COM200.java — Concrete leaf class
// =============================================================================

/**
 * COM200.java — Introduction to Communication. GER-eligible.
 */
public class COM200 extends COM {

    private boolean writingIntensive;

    public COM200(String professor, String section, String location,
                  String[] days, String time, int capacity) {

        super(
            "COM200",
            "Introduction to Communication",
            professor,
            section,
            3,
            400.00,
            false,
            true,                         // counts as elective
            location,
            days,
            time,
            new String[]{},               // no prerequisites
            capacity,
            true,                         // isGER
            "Social Science",             // gerCategory
            false,                        // no research paper
            "Written",                    // communicationMode
            false                         // no oral presentations
        );

        this.writingIntensive = true;
    }

    @Override
    public String courseDetails() {
        // TEAM TODO: call super.courseDetails() and append writingIntensive flag
        return ""; // placeholder — replace this
    }

    public boolean isWritingIntensive() { return writingIntensive; }
}


// =============================================================================
// COM201.java — Concrete leaf class
// =============================================================================

/**
 * COM201.java — Public Speaking. GER-eligible with oral presentations.
 */
class COM201 extends COM {

    private boolean writingIntensive;

    public COM201(String professor, String section, String location,
                  String[] days, String time, int capacity) {

        super(
            "COM201",
            "Public Speaking",
            professor,
            section,
            3,
            400.00,
            false,
            true,
            location,
            days,
            time,
            new String[]{},
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
        return ""; // placeholder — replace this
    }

    public boolean isWritingIntensive() { return writingIntensive; }
}


// =============================================================================
// COM230.java — Concrete leaf class
// =============================================================================

/**
 * COM230.java — Digital Media Communication. Adds a mediaType field.
 */
class COM230 extends COM {

    private String  mediaType;           // e.g. "Digital", "Film", "Social Media"
    private boolean writingIntensive;

    public COM230(String professor, String section, String location,
                  String[] days, String time, int capacity) {

        super(
            "COM230",
            "Digital Media Communication",
            professor,
            section,
            3,
            400.00,
            false,
            true,
            location,
            days,
            time,
            new String[]{"COM200"},       // requires COM200
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
        return ""; // placeholder — replace this
    }

    public String  getMediaType()        { return mediaType; }
    public boolean isWritingIntensive()  { return writingIntensive; }
}


// =============================================================================
// STS201.java — Concrete leaf class
// =============================================================================

/**
 * STS201.java — Technology and Society.
 */
class STS201 extends STS {

    private String caseStudyRegion; // Geographic focus of the case studies

    public STS201(String professor, String section, String location,
                  String[] days, String time, int capacity) {

        super(
            "STS201",
            "Technology and Society",
            professor,
            section,
            3,
            400.00,
            false,
            true,
            location,
            days,
            time,
            new String[]{},
            capacity,
            true,                         // isGER
            "Social Science",
            true,                         // hasResearchPaper
            "Policy",                     // focusArea
            true                          // interdisciplinary
        );

        this.caseStudyRegion = "North America";
    }

    @Override
    public String courseDetails() {
        // TEAM TODO: call super.courseDetails() and append caseStudyRegion
        return ""; // placeholder — replace this
    }

    public String getCaseStudyRegion() { return caseStudyRegion; }
}


// =============================================================================
// STS205.java — Concrete leaf class
// =============================================================================

/**
 * STS205.java — Ethics in Science and Technology.
 */
class STS205 extends STS {

    private String caseStudyRegion;

    public STS205(String professor, String section, String location,
                  String[] days, String time, int capacity) {

        super(
            "STS205",
            "Ethics in Science and Technology",
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

        this.caseStudyRegion = "Global";
    }

    @Override
    public String courseDetails() {
        // TEAM TODO: call super.courseDetails() and append caseStudyRegion
        return ""; // placeholder — replace this
    }

    public String getCaseStudyRegion() { return caseStudyRegion; }
}

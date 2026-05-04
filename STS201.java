// =============================================================================
// STS201.java — Concrete leaf class
// =============================================================================

/**
 * STS201.java — Understanding Technological Society.
 */
class STS201 extends STS {

    private String caseStudyRegion; // Geographic focus of the case studies

    public STS201(String crn, String professor, String section, String location,
                  String[] days, String time, int capacity) {

        super(
            crn,
            "Understanding Technological Society",
            "STS201",
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
        return super.courseDetails() + " (Case Study Region: " + caseStudyRegion + ")"; // placeholder — replace this
    }

    public String getCaseStudyRegion() { return caseStudyRegion; }
}

package cs;
// =============================================================================
// CS100.java — Concrete leaf class
// =============================================================================

/**
 * CS100.java
 * Intro-level CS course. No prerequisites.
 *
 * TEAM TODO: This is a concrete class — it can be instantiated.
 * Notice how short the constructor is: it just calls super(...) with
 * hardcoded values for the CS100-specific fields, then sets its own.
 */
public class CS100 extends CompSci {

    private String[] topicsCovered; // e.g. {"Variables", "Loops", "Methods"}

    public CS100(String crn, String professor, String section, String location,
                 String[] days, String time, int capacity) {

        super(
            crn,                          // crn
            "Roadmap to Computing",    // courseTitle
            "CS100",                    // courseCode
            professor,
            section,
            3,                                // creditHours
            450.00,                           // creditFee per credit
            true,                             // isRequired
            false,                            // isElective
            location,
            days,
            time,
            new String[]{},                   // no prerequisites
            capacity,
            "Python",                           // programmingLanguage
            false,                             // hasLabSection
            60                             // labFee
        );

        this.topicsCovered = new String[]{"Basic data types (integers, strings, booleans)", "Control structures (conditionals, loops)", "Data structures (lists, tuples, dictionaries)", "File input/output", "Object-oriented programming with classes"};
    }

    /**
     * courseDetails() — complete CS100 summary.
     *
     * TEAM TODO: Call super.courseDetails() (which calls CompSci's version,
     * which calls baseCourseDetails()) and then append the topics list.
     */
    @Override
    public String courseDetails() {
        // TEAM TODO: implement — start with super.courseDetails() + topics
        String details = super.courseDetails(); // call the base version to get the common block
        details += "\nTopics Covered:\n";
        for (String topic : this.getTopicsCovered()) {
            details += " - " + topic + "\n";
        }
        return details;
    }

    public String[] getTopicsCovered() { return topicsCovered; }
}






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

    public CS100(String professor, String section, String location,
                 String[] days, String time, int capacity) {

        super(
            "CS100",                          // crn
            "Introduction to Programming",    // courseTitle
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
            "Java",                           // programmingLanguage
            true,                             // hasLabSection
            75.00                             // labFee
        );

        this.topicsCovered = new String[]{"Variables", "Control Flow", "Methods", "Arrays"};
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
        return ""; // placeholder — replace this
    }

    public String[] getTopicsCovered() { return topicsCovered; }
}


// =============================================================================
// CS113.java — Concrete leaf class
// =============================================================================

/**
 * CS113.java — Data Structures. Prerequisite: CS100.
 */
class CS113 extends CompSci {

    private String[] topicsCovered;

    public CS113(String professor, String section, String location,
                 String[] days, String time, int capacity) {

        super(
            "CS113",
            "Data Structures",
            professor,
            section,
            3,
            450.00,
            true,
            false,
            location,
            days,
            time,
            new String[]{"CS100"},            // requires CS100
            capacity,
            "Java",
            true,
            75.00
        );

        this.topicsCovered = new String[]{"Linked Lists", "Stacks", "Queues", "Trees", "Sorting"};
    }

    @Override
    public String courseDetails() {
        // TEAM TODO: implement — start with super.courseDetails() + topics
        return ""; // placeholder — replace this
    }

    public String[] getTopicsCovered() { return topicsCovered; }
}


// =============================================================================
// CS114.java — Concrete leaf class
// =============================================================================

/**
 * CS114.java — Algorithms. Prerequisite: CS113.
 */
class CS114 extends CompSci {

    private String[] topicsCovered;

    public CS114(String professor, String section, String location,
                 String[] days, String time, int capacity) {

        super(
            "CS114",
            "Algorithms and Complexity",
            professor,
            section,
            3,
            450.00,
            true,
            false,
            location,
            days,
            time,
            new String[]{"CS113"},            // requires CS113
            capacity,
            "Java",
            false,                            // no lab for this one
            0.00
        );

        this.topicsCovered = new String[]{"Big-O", "Recursion", "Graphs", "Dynamic Programming"};
    }

    @Override
    public String courseDetails() {
        // TEAM TODO: implement — start with super.courseDetails() + topics
        return ""; // placeholder — replace this
    }

    public String[] getTopicsCovered() { return topicsCovered; }
}

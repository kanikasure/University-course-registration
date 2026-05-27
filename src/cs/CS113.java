package cs;
// =============================================================================
// CS113.java — Concrete leaf class
// =============================================================================

/**
 * CS113.java — Introduction to Computer Science I. Prerequisite: CS100.
 */
public class CS113 extends CompSci {

    private String[] topicsCovered;

    public CS113(String crn, String professor, String section, String location,
                 String[] days, String time, int capacity) {

        super(
            crn,
            "Introduction to Computer Science I",
            "CS113",
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
            0.00
        );

        this.topicsCovered = new String[]{"Data types", "Control structures (loops/conditionals)", "Arrays", "Inheritance", "Polymorphism", "Recursion", "Exception handling"};
    }

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

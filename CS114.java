// =============================================================================
// CS114.java — Concrete leaf class
// =============================================================================

/**
 * CS114.java — Introduction to Computer Science II. Prerequisite: CS113.
 */
class CS114 extends CompSci {

    private String[] topicsCovered;

    public CS114(String crn, String professor, String section, String location,
                 String[] days, String time, int capacity) {

        super(
            crn,
            "Introduction to Computer Science II",
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
            true,                            //  lab for this one
            100.00
        );

        this.topicsCovered = new String[]{"Big-O", "Recursion", "Graphs", "Dynamic Programming"};
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

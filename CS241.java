// =============================================================================
// CS241.java — Concrete leaf class
// =============================================================================

/**
 * CS241.java — Foundations of Computer Science I. Prerequisite: CS114 and MATH112.
 */
class CS241 extends CompSci {

    private String[] topicsCovered;

    public CS241(String professor, String section, String location,
                 String[] days, String time, int capacity) {

        super(
            "CS241",
            "Foundations of Computer Science I",
            "CS241",
            professor,
            section,
            3,
            450.00,
            true,
            false,
            location,
            days,
            time,
            new String[]{"CS114", "MATH112"},            // requires CS114 and MATH112.
            capacity,
            "Discrete Mathematics",
            false,                            // no lab for this one
            0.00
        );

        this.topicsCovered = new String[]{"sets", "induction", "recurrence relations", "relations/functions", "counting", "probability"};
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

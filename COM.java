/**
 * COM.java
 * Abstract sub-intermediate for Communication courses.
 * Extends HistHumGER → extends Course (4-level depth).
 *
 * TEAM TODO: COM sits between HistHumGER and the concrete COM200/201/230 classes.
 * It adds communication-specific fields on top of what HistHumGER already has.
 */
public abstract class COM extends HistHumGER {

    private String  communicationMode; // e.g. "Written", "Oral", "Digital"
    private boolean hasPresentations;  // True if oral presentations are required

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    public COM(String crn, String courseTitle, String courseCode, String professor, String section,
               int creditHours, double creditFee, boolean isRequired, boolean isElective,
               String location, String[] days, String time,
               String[] prerequisites, int capacity,
               boolean isGER, String gerCategory, boolean hasResearchPaper,
               String communicationMode, boolean hasPresentations) {

        super(crn, courseTitle, courseCode, professor, section, creditHours, creditFee,
              isRequired, isElective, location, days, time, prerequisites, capacity,
              isGER, gerCategory, hasResearchPaper);

        this.communicationMode = communicationMode;
        this.hasPresentations  = hasPresentations;
    }

    // -------------------------------------------------------------------------
    // Override
    // -------------------------------------------------------------------------

    /**
     * courseDetails() — adds communication mode and presentation flag on top
     * of what HistHumGER.courseDetails() already prints.
     *
     * TEAM TODO: Call super.courseDetails() to get the HistHumGER block,
     * then append COM-specific lines below it.
     */
    @Override
    public String courseDetails() {
        // TEAM TODO: build and return the full details string
        String details = super.courseDetails(); // call the base version to get the common block
        details += "\nCommunication Mode: " + communicationMode;
        details += "\nPresentations Required: " + hasPresentations;
        return details; // placeholder — replace this
    }

    // Getters
    public String  getCommunicationMode() { return communicationMode; }
    public boolean hasPresentations()     { return hasPresentations; }
}

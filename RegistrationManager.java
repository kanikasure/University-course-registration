/**
 * RegistrationManager.java
 * Manager class that holds the Course[] array and implements all array operations.
 * Required by the rubric: sort, recursive search, print all.
 *
 * TEAM TODO: This is the class your main menu will talk to most.
 * Read every method — you'll be calling all of them in Main.java.
 */
public class RegistrationManager {

    // -------------------------------------------------------------------------
    // Fields
    // -------------------------------------------------------------------------

    private Course[] courses;      // Polymorphic array — holds any Course subtype
    private int      count;        // How many courses are currently stored
    private static final int MAX_COURSES = 20; // Max capacity of the courses array- slightly higher than the number of concrete classes to allow for duplicates in testing

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    public RegistrationManager() {
        courses = new Course[MAX_COURSES];
        count   = 0;
    }

    // -------------------------------------------------------------------------
    // Array operations
    // -------------------------------------------------------------------------

    /**
     * Add a course to the array.
     * Throws EnrollmentException if the array is already full.
     *
     * TEAM TODO: The two checks below cover two of the required exception cases.
     * (The third — section full — is handled inside Course.enroll().)
     */
    public void addCourse(Course c) throws EnrollmentException {
        if (count >= MAX_COURSES) {
            throw new EnrollmentException("Cannot add course: registration system is at capacity.");
        }
        if (c == null) {
            throw new EnrollmentException("Cannot add a null course.");
        }
        courses[count] = c;
        count++;
    }

    /**
     * Print every course using polymorphic courseDetails() calls.
     * Required by the rubric.
     *
     * TEAM TODO: Notice that even though courses[] is typed as Course[],
     * calling courseDetails() here invokes the correct overridden version
     * for each concrete class. That IS polymorphism — mention it in your report.
     */
    public void printAllCourses() {
        if (count == 0) {
            System.out.println("No courses in the system.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("--- Course " + (i + 1) + " ---");
            System.out.println(courses[i].courseDetails()); // polymorphic call
            System.out.println();
        }
    }

    /**
     * Sort the courses array by credit hours using compareTo().
     * Uses a simple bubble sort so the logic is easy to explain.
     * Required by the rubric.
     *
     * TEAM TODO: Understand the two nested loops.
     *   Outer loop: how many passes.
     *   Inner loop: compares adjacent elements, swaps if out of order.
     * compareTo() returns negative if courses[j] should come first.
     */

    //changed the sorting technique to selection sort
    public void sortByCreditHours() {
        for (int i = 0; i < count - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < count; j++) {
                if (courses[j].compareTo(courses[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // Swap
            Course temp = courses[i];
            courses[i] = courses[minIndex];
            courses[minIndex] = temp;
        }
        System.out.println("Courses sorted by credit hours.");
    }

    /**
                    Course temp    = courses[j];
                    courses[j]     = courses[j + 1];
                    courses[j + 1] = temp;
                }
            }
        }
        System.out.println("Courses sorted by credit hours.");
    }

    /**
     * Recursive search — find a course by CRN.
     * Required by the rubric.
     *
     * TEAM TODO: Trace this for your report.
     *   Call it as: searchByCRN("CS100", 0)
     *
     *   Base case 1 — index past end of array: not found, return null.
     *   Base case 2 — CRN matches: return the course.
     *   Recursive case — advance index by 1.
     *
     * @param crn   the CRN to search for
     * @param index current position in the array (start with 0)
     * @return the matching Course, or null if not found
     */
    public Course searchByCRN(String crn, int index) {
        // Base case 1 — reached the end without finding it
        if (index >= count) return null;

        // Base case 2 — found a match
        if (courses[index].getCRN().equals(crn)) return courses[index];

        // Recursive case — check the next position
        return searchByCRN(crn, index + 1);
    }

    /**
     * Filter and print only courses that still have open seats.
     *
     * TEAM TODO: Uses isAvailable() from Course. Good for showing the
     * enroll/capacity system working in your demo.
     */
    public void printAvailableCourses() {
        System.out.println("=== Available Courses ===");
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (courses[i].isAvailable()) {
                System.out.println(courses[i].getCRN() + " — "
                    + courses[i].getCourseTitle()
                    + " (" + courses[i].getEnrolled() + "/"
                    + courses[i].getCapacity() + " seats)");
                found = true;
            }
        }
        if (!found) System.out.println("No available courses.");
    }

    // Getters
    public int     getCount()          { return count; }
    public Course  getCourse(int i)    { return courses[i]; }
}

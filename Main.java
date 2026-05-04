import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main.java
 * Entry point. Sets up sample data and runs an interactive text menu.
 *
 * TEAM TODO: This file has three jobs:
 *   1. Create sample course objects and load them into RegistrationManager.
 *   2. Show a menu and read user input.
 *   3. Catch exceptions — both your custom EnrollmentException and the
 *      built-in InputMismatchException (required by the rubric).
 */
public class Main {

    public static void main(String[] args) {

        RegistrationManager manager = new RegistrationManager();
        Scanner scanner = new Scanner(System.in);

        // ---------------------------------------------------------------------
        // Load sample courses
        // TEAM TODO: Add more courses here so your demo has variety.
        //            Use at least one of every concrete class.
        // ---------------------------------------------------------------------
        try {
            manager.addCourse(new CS100("CS100-001", "Prof. Smith", "001", "GITC 1400",
                                        new String[]{"Mon","Wed"}, "10:00-11:15", 30));

            manager.addCourse(new CS113("CS113-001", "Prof. Jones",  "001", "GITC 3900",
                                        new String[]{"Tue","Thu"}, "11:30-12:45", 25));

            manager.addCourse(new CS114("CS114-001", "Prof. Lee",    "001", "GITC 3700",
                                        new String[]{"Mon","Wed","Fri"}, "09:00-09:50", 20));

            manager.addCourse(new MATH111("MATH111-001", "Prof. Chen", "001", "Cullimore 110",
                                          new String[]{"Mon","Tue","Wed","Thu"}, "08:00-08:50", 35));

            manager.addCourse(new MATH112("MATH112-001", "Prof. Kim",  "001", "Cullimore 110",
                                          new String[]{"Mon","Wed","Fri"}, "10:00-10:50", 30));

            manager.addCourse(new MATH105("MATH105-001", "Prof. Patel","001", "Cullimore 114",
                                          new String[]{"Tue","Thu"}, "14:00-15:15", 40));

            manager.addCourse(new MATH333("MATH333-001", "Prof. Wang", "001", "Cullimore 220",
                                          new String[]{"Mon","Wed"}, "13:00-14:15", 20));

            manager.addCourse(new COM200("COM200-001", "Prof. Davis", "001", "Bradley 106",
                                         new String[]{"Mon","Wed"}, "12:30-13:45", 28));

            manager.addCourse(new COM201("COM201-001", "Prof. Brown", "001", "Bradley 108",
                                         new String[]{"Tue","Thu"}, "09:30-10:45", 25));

            manager.addCourse(new COM230("COM230-001", "Prof. Garcia","001", "Bradley 110",
                                         new String[]{"Mon","Wed","Fri"}, "11:00-11:50", 22));

            manager.addCourse(new STS201("STS201-001", "Prof. Wilson","001", "Kupfrian 107",
                                         new String[]{"Tue","Thu"}, "12:30-13:45", 30));

            manager.addCourse(new STS205("STS205-001", "Prof. Moore", "001", "Kupfrian 107",
                                         new String[]{"Mon","Wed"}, "15:30-16:45", 25, "Microfabrication Innovation Center"));

        } catch (EnrollmentException e) {
            System.out.println("Setup error: " + e.getMessage());
        }

        // ---------------------------------------------------------------------
        // Main menu loop
        // ---------------------------------------------------------------------
        boolean running = true;
        while (running) {
            printMenu();

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume leftover newline

                switch (choice) {
                    case 1:
                        // Print all courses — demonstrates polymorphism
                        manager.printAllCourses();
                        break;

                    case 2:
                        // Sort by credit hours — uses compareTo()
                        manager.sortByCreditHours();
                        System.out.println("Done. Select option 1 to see the sorted list.");
                        break;

                    case 3:
                        // Recursive CRN search
                        System.out.print("Enter CRN to search: ");
                        String crn = scanner.nextLine();
                        Course found = manager.searchByCRN(crn, 0);
                        if (found != null) {
                            System.out.println("Found:");
                            System.out.println(found.courseDetails());
                        } else {
                            System.out.println("No course found with CRN: " + crn);
                        }
                        break;

                    case 4:
                        // Enroll — triggers EnrollmentException if full
                        System.out.print("Enter CRN to enroll in: ");
                        String enrollCRN = scanner.nextLine();
                        Course target = manager.searchByCRN(enrollCRN, 0);
                        if (target == null) {
                            System.out.println("Course not found.");
                        } else {
                            try {
                                target.enroll();
                                System.out.println("Enrolled in " + target.getCourseTitle()
                                    + ". Seats remaining: "
                                    + (target.getCapacity() - target.getEnrolled()));
                            } catch (EnrollmentException e) {
                                // TEAM TODO: This is where your custom exception is caught.
                                // The rubric checks that you handle it here.
                                System.out.println("Enrollment failed: " + e.getMessage());
                            }
                        }
                        break;

                    case 5:
                        // Show available courses
                        manager.printAvailableCourses();
                        break;

                    case 6:
                        // Test equals() — rubric check
                        System.out.print("Enter first CRN: ");
                        String crn1 = scanner.nextLine();
                        System.out.print("Enter second CRN: ");
                        String crn2 = scanner.nextLine();
                        Course c1 = manager.searchByCRN(crn1, 0);
                        Course c2 = manager.searchByCRN(crn2, 0);
                        if (c1 == null || c2 == null) {
                            System.out.println("One or both courses not found.");
                        } else {
                            System.out.println("Are they equal? " + c1.equals(c2));
                        }
                        break;

                    case 0:
                        running = false;
                        System.out.println("Exiting. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option. Please choose 0-6.");
                }

            } catch (InputMismatchException e) {
                // TEAM TODO: This catches the built-in exception when the user
                // types text instead of a number. Required by the rubric.
                System.out.println("Invalid input — please enter a number.");
                scanner.nextLine(); // clear the bad input
            }

            System.out.println();
        }

        scanner.close();
    }

    // -------------------------------------------------------------------------
    // Helper — print the menu
    // -------------------------------------------------------------------------

    private static void printMenu() {
        System.out.println("==============================");
        System.out.println("  Course Registration System  ");
        System.out.println("==============================");
        System.out.println("1. Print all courses");
        System.out.println("2. Sort courses by credit hours");
        System.out.println("3. Search for a course by CRN");
        System.out.println("4. Enroll in a course");
        System.out.println("5. Show available courses");
        System.out.println("6. Compare two courses (equals)");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }
}

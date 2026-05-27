package core;
/**
 * EnrollmentException.java
 * Custom exception for the Course Registration System.
 * Required by the rubric: "Create a custom exception class."
 *
 * TEAM TODO: Know the three situations where this gets thrown:
 *   1. Section is full (enrolled >= capacity) — thrown in Course.enroll()
 *   2. Prerequisite not met — thrown in RegistrationManager if you add that check
 *   3. Array capacity exceeded — thrown in RegistrationManager.addCourse()
 *
 * TEAM TODO: Understand why we extend Exception (checked) not RuntimeException
 * (unchecked). Checked means callers MUST handle it with try/catch or declare
 * throws — that's what the rubric is testing.
 */
public class EnrollmentException extends Exception {

    /**
     * Constructor — takes a message describing what went wrong.
     * super(message) passes it up to Exception so getMessage() works.
     */
    public EnrollmentException(String message) {
        super(message);
    }
}

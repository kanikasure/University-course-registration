# Course Registration System

A Java-based, object-oriented course registration system built as a mini-capstone project (Track B). The system models a university course catalog with multi-level inheritance, polymorphism, recursion, custom exception handling, and array-based course management.

## Project Overview

This project implements a **Course Registration System** that allows users to view, sort, search, and enroll in courses across multiple academic departments (Computer Science, Mathematics, Communication, Science & Technology Studies). It satisfies all the OOP requirements outlined in the project specification — including a 3+ level abstract class hierarchy, polymorphic methods, a recursive prerequisite/search method, a custom exception, `equals()` by unique ID, and `Comparable` by a numeric field.

## Class Hierarchy

The system uses a four-level deep inheritance structure rooted at the abstract `Course` class.

```
Course (abstract, root)
 ├── CompSci (abstract)
 │    ├── CS100
 │    ├── CS113
 │    ├── CS114
 │    └── CS241
 ├── MathCourse (abstract)
 │    ├── MATH105
 │    ├── MATH111
 │    ├── MATH112
 │    └── MATH333    (overrides calculateTuition() a second time)
 └── HistHumGER (abstract)
      ├── COM (abstract)
      │    ├── COM200
      │    ├── COM201
      │    └── COM230
      └── STS (abstract)
           ├── STS201
           └── STS205
```

The `Course → HistHumGER → COM → COM200` path demonstrates the required 4-level depth.

## File Structure

The project is organized into packages under `src/`:

```
src/
 ├── core/
 │    ├── Course.java               Abstract root class
 │    ├── EnrollmentException.java  Custom checked exception
 │    ├── RegistrationManager.java  Manages the Course[] array
 │    └── Main.java                 Entry point / interactive menu
 ├── cs/
 │    ├── CompSci.java              Abstract intermediate for CS courses
 │    ├── CS100.java
 │    ├── CS113.java
 │    ├── CS114.java
 │    └── CS241.java
 ├── math/
 │    ├── MathCourse.java           Abstract intermediate for Math courses
 │    ├── MATH105.java
 │    ├── MATH111.java
 │    ├── MATH112.java
 │    └── MATH333.java
 └── humanities/
      ├── HistHumGER.java           Abstract intermediate for GER courses
      ├── COM.java                  Abstract sub-intermediate for COM courses
      ├── COM200.java
      ├── COM201.java
      ├── COM230.java
      ├── STS.java                  Abstract sub-intermediate for STS courses
      ├── STS201.java
      └── STS205.java
```

| File | Role |
|------|------|
| `core/Course.java` | Abstract root class. Defines shared fields, `equals()`, `compareTo()`, and the recursive `hasPrerequisite()` method. |
| `cs/CompSci.java` | Abstract intermediate for CS courses. Adds `programmingLanguage`, `hasLabSection`, `labFee`. |
| `cs/CS100.java`, `cs/CS113.java`, `cs/CS114.java`, `cs/CS241.java` | Concrete CS course leaves. |
| `math/MathCourse.java` | Abstract intermediate for Math courses. Adds `mathSubfield`, `requiresCalculator`, `recitationSessions`. |
| `math/MATH105.java`, `math/MATH111.java`, `math/MATH112.java`, `math/MATH333.java` | Concrete Math course leaves. `MATH333` adds an upper-division fee. |
| `humanities/HistHumGER.java` | Abstract intermediate for GER-eligible courses. Applies a $50 GER discount. |
| `humanities/COM.java` | Abstract sub-intermediate for Communication courses. |
| `humanities/COM200.java`, `humanities/COM201.java`, `humanities/COM230.java` | Concrete COM leaves. |
| `humanities/STS.java` | Abstract sub-intermediate for Science, Technology & Society courses. |
| `humanities/STS201.java`, `humanities/STS205.java` | Concrete STS leaves. |
| `core/EnrollmentException.java` | Custom checked exception for full sections, capacity issues, and invalid additions. |
| `core/RegistrationManager.java` | Manager class holding the polymorphic `Course[]` array. Implements add, sort, recursive search, and print operations. |
| `core/Main.java` | Entry point. Loads sample courses and runs an interactive text menu. |

## Features

- **Multi-level inheritance** — four levels deep along the `Course → HistHumGER → COM → COM200` path, with three abstract intermediate classes and eleven concrete leaf classes.
- **Polymorphism** — `courseDetails()` and `calculateTuition()` are overridden at multiple levels. `MATH333` demonstrates layered polymorphism by overriding `calculateTuition()` a second time to add an upper-division fee.
- **Recursion** — `Course.hasPrerequisite(targetCRN, index)` recursively walks the prerequisites array. `RegistrationManager.searchByCRN(crn, index)` recursively searches the course array.
- **Custom exception handling** — `EnrollmentException` is thrown for full sections, registration system overflow, and null course additions.
- **Built-in exception handling** — `Main.java` catches `InputMismatchException` when the user enters non-numeric menu input.
- **Object comparison** — `equals()` compares courses by their unique CRN; `compareTo()` compares by credit hours (used for sorting).
- **Array operations** — `RegistrationManager` provides `addCourse()`, `sortByCreditHours()` (selection sort), `searchByCRN()` (recursive), `printAllCourses()`, and `printAvailableCourses()`.

## How to Compile and Run

From the project's root directory:

```bash
# Compile all source files into the out/ directory
javac -d out src/core/Course.java src/core/EnrollmentException.java src/core/RegistrationManager.java src/humanities/HistHumGER.java src/humanities/STS.java src/humanities/COM.java src/cs/CompSci.java src/math/MathCourse.java src/cs/CS100.java src/cs/CS113.java src/cs/CS114.java src/cs/CS241.java src/math/MATH105.java src/math/MATH111.java src/math/MATH112.java src/math/MATH333.java src/humanities/COM200.java src/humanities/COM201.java src/humanities/COM230.java src/humanities/STS201.java src/humanities/STS205.java src/core/Main.java

# Run the program
java -cp out core.Main
```

This will launch the interactive menu.

## Menu Options

```
1. Print all courses              → demonstrates polymorphic courseDetails()
2. Sort courses by credit hours   → demonstrates compareTo()
3. Search for a course by CRN     → demonstrates recursive search
4. Enroll in a course             → demonstrates EnrollmentException
5. Show available courses         → demonstrates isAvailable()
6. Compare two courses (equals)   → demonstrates equals() by CRN
0. Exit
```

## Sample Courses Loaded at Startup

The system pre-loads twelve sample courses spanning all four departments, including CS100, CS113, CS114, MATH105, MATH111, MATH112, MATH333, COM200, COM201, COM230, STS201, and STS205. The `RegistrationManager` is configured with a maximum capacity of 20 courses to leave room for testing duplicates and capacity-related exceptions.

## Demonstrating the Rubric Requirements

| Requirement | Where to Look |
|-------------|---------------|
| Multi-level inheritance (3+ levels) | `Course → HistHumGER → COM → COM200` |
| Polymorphic overrides | `courseDetails()` and `calculateTuition()` in every subclass |
| Recursion | `Course.hasPrerequisite()`, `RegistrationManager.searchByCRN()` |
| Custom exception | `EnrollmentException.java`, used in `Course.enroll()` and `RegistrationManager.addCourse()` |
| Built-in exception | `InputMismatchException` caught in `Main.java` |
| `equals()` by unique ID | `Course.equals()` compares by `crn` |
| `Comparable` / `compareTo()` | `Course.compareTo()` compares by `creditHours` |
| Array operations | `RegistrationManager` (sort, search, print) |

## Notes

- The system uses a fixed-size array (`MAX_COURSES = 20`) rather than a dynamic collection, by design — this lets the manager raise `EnrollmentException` when capacity is exceeded, which is one of the required exception scenarios.
- `MATH333.calculateTuition()` calls `super.calculateTuition()` to demonstrate that polymorphic overrides can stack across multiple inheritance levels.
- The selection sort in `RegistrationManager.sortByCreditHours()` was chosen over bubble sort for clarity when explaining the algorithm during the demo.

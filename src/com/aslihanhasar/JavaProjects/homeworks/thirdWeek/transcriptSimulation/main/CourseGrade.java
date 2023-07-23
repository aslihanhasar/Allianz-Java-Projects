package com.aslihanhasar.JavaProjects.homeworks.thirdWeek.transcriptSimulation.main;


import com.aslihanhasar.JavaProjects.homeworks.thirdWeek.transcriptSimulation.util.Grade;

/**
 * The CourseGrade class represents the grades obtained by a student in a specific course.
 * It contains information about the department,course code, credit, and grade taken for that course.
 */
public class CourseGrade {
    private String courseDepartment;
    private int courseCode;
    private int courseCredit;
    private Grade gradeTaken;

    /**
     * Constructor with course department initializes
     * the CourseGrade object with the provided course department,
     * using default values for other fields
     * (courseCode=100, courseCredit=4, gradeTaken=Grade.F).
     *
     * @param courseDepartment The department of the course.
     */
    public CourseGrade(String courseDepartment) {
        this(courseDepartment, 100, 4, Grade.F);
    }

    /**
     * Constructor with course department and course code initializes
     * the CourseGrade object with the provided course department and course code,
     * using default values for courseCredit (4) and gradeTaken (Grade.F).
     *
     * @param courseDepartment The department of the course.
     * @param courseCode       The course code.
     */
    public CourseGrade(String courseDepartment, int courseCode) {
        this(courseDepartment, courseCode, 4, Grade.F);
    }

    /**
     * Constructor with course department, course code, and course credit initializes
     * the CourseGrade object with the provided course department, course code, and course credit,
     * using a default value for gradeTaken (Grade.F).
     *
     * @param courseDepartment The department of the course.
     * @param courseCode       The course code.
     * @param courseCredit     The number of credits the course is worth.
     */
    public CourseGrade(String courseDepartment, int courseCode, int courseCredit) {
        this(courseDepartment, courseCode, courseCredit, Grade.F);
    }

    /**
     * Constructor with all fields initializes
     * the CourseGrade object with the provided course department,
     * course code, course credit, and grade taken.
     *
     * @param courseDepartment The department of the course.
     * @param courseCode       The course code.
     * @param courseCredit     The number of credits the course is worth.
     * @param gradeTaken       The grade obtained in the course.
     */
    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, Grade gradeTaken) {
        setCourseDepartment(courseDepartment);
        setCourseCode(courseCode);
        setCourseCredit(courseCredit);
        setGradeTaken(gradeTaken);
    }

    /**
     * Gets the department of the course.
     *
     * @return The department of the course.
     */
    public String getCourseDepartment() {
        return courseDepartment;
    }

    /**
     * Sets the department of the course.
     * If the provided course department is a valid department set to the field.
     * Otherwise, the default department "CENG" is set.
     *
     * @param courseDepartment The department of the course.
     */
    public void setCourseDepartment(String courseDepartment) {
        boolean validCourseDepartment = isValidCourseDepartment(courseDepartment);
        if (validCourseDepartment) {
            this.courseDepartment = courseDepartment.toUpperCase();
        } else {
            this.courseDepartment = "CENG";
        }
    }

    /**
     * Gets the course code.
     *
     * @return The three-digit course code.
     */
    public int getCourseCode() {
        return courseCode;
    }

    /**
     * Sets the course code.
     * If the provided course code is between 100 and 599 (inclusive), set to the field.
     * Otherwise, the default course code 100 is set.
     *
     * @param courseCode The three-digit course code.
     */
    public void setCourseCode(int courseCode) {
        if (courseCode >= 100 && courseCode <= 599) {
            this.courseCode = courseCode;
        } else {
            this.courseCode = 100;
        }
    }

    /**
     * Gets the number of credits the course is worth.
     *
     * @return The number of credits the course is worth.
     */
    public int getCourseCredit() {
        return courseCredit;
    }

    /**
     * Sets the number of credits the course is worth.
     * If the provided course credit is either 3 or 4, set to the field.
     * Otherwise, the default course credit 4 is set.
     *
     * @param courseCredit The number of credits the course is worth.
     */
    public void setCourseCredit(int courseCredit) {
        if (courseCredit == 3 || courseCredit == 4) {
            this.courseCredit = courseCredit;
        } else {
            this.courseCredit = 4;
        }
    }

    /**
     * Gets the grade obtained in the course.
     *
     * @return The grade obtained in the course.
     */
    public Grade getGradeTaken() {
        return gradeTaken;
    }

    /**
     * Sets the grade obtained in the course based on the given numeric value.
     * If the value is not within the valid range of 0.0 to 4.0, the grade is set to Grade.F.
     * Otherwise, the letter grade is determined based on the closest numeric value to the given value.
     *
     * @param value The numeric value representing the grade obtained in the course.
     */
    public void setGradeTaken(double value) {
        if (value < 0.0 || value > 4.0) {
            this.gradeTaken = Grade.F;
        } else {
            checkGradeNumeric(value);
        }

    }

    /**
     * Sets the grade obtained in the course directly using a Grade enum constant.
     *
     * @param gradeTaken The grade obtained in the course as a Grade enum constant.
     */
    public void setGradeTaken(Grade gradeTaken) {
        this.gradeTaken = gradeTaken;
    }

    /**
     * Checks if the provided course department is a valid department.
     * Valid departments are "CENG", "COMP", "ECE", "ME", and "MATH".
     *
     * @param courseDepartment The course department to be checked.
     * @return True if the course department is valid, false otherwise.
     */
    private boolean isValidCourseDepartment(String courseDepartment) {
        return courseDepartment.equalsIgnoreCase("CENG")
                || courseDepartment.equalsIgnoreCase("COMP")
                || courseDepartment.equalsIgnoreCase("ECE")
                || courseDepartment.equalsIgnoreCase("ME")
                || courseDepartment.equalsIgnoreCase("MATH");
    }

    /**
     * Sets the gradeTaken field based on the closest letter grade to the given numeric value.
     * If the value is not within the valid range of 0.0 to 4.0, the grade is set to Grade.F.
     *
     * @param value The numeric value representing the grade obtained in the course.
     */
    private void checkGradeNumeric(double value) {
        Grade closestGradeLetter = Grade.F;
        double minDistance = 4.0;
        double distance;
        for (Grade grade : Grade.values()) {
            distance = Math.abs(value - grade.getNumericValue());
            if (distance <= minDistance) {
                minDistance = distance;
                closestGradeLetter = grade;
            }
        }
        gradeTaken = closestGradeLetter;
    }

    /**
     * Returns a string representation of the CourseGrade object.
     *
     * @return A string containing the department, course code, credit, and grade taken.
     */
    @Override
    public String toString() {
        return "Department: " + courseDepartment + " " +
                " CourseCode: " + courseCode + " " +
                " Credit: " + courseCredit + " " +
                " Grade:" + gradeTaken.getStringValue() + " ";
    }
}

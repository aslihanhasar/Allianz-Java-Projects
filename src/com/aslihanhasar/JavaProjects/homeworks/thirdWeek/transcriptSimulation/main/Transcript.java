package com.aslihanhasar.JavaProjects.homeworks.thirdWeek.transcriptSimulation.main;

import java.util.ArrayList;
import java.util.List;

/**
 * The Transcript class represents the transcript of a student.
 * It stores the student's ID, GPA, and a list of CourseGrade objects.
 */
public class Transcript {
    private int studentID;
    private double GPA;
    private List<CourseGrade> courseGrades;

    /**
     * Constructs a new Transcript object with the given student ID.
     * Initializes the GPA to 0.0 and creates an empty list of CourseGrade objects.
     *
     * @param studentID The ID of the student.
     */
    public Transcript(int studentID) {
        this.studentID = studentID;
        this.GPA = 0.0;
        this.courseGrades = new ArrayList<>();
    }

    /**
     * Gets the student ID.
     *
     * @return The student ID.
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * Sets the student ID.
     *
     * @param studentID The student ID to set.
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * Gets the GPA of the student.
     *
     * @return The GPA of the student.
     */
    public double getGPA() {
        return GPA;
    }

    /**
     * Sets the GPA of the student.
     *
     * @param GPA The GPA to set for the student.
     */
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    /**
     * Gets the list of CourseGrade objects.
     *
     * @return The list of CourseGrade objects.
     */
    public List<CourseGrade> getCourseGrades() {
        return courseGrades;
    }

    /**
     * Sets the list of CourseGrade objects.
     *
     * @param courseGrades The list of CourseGrade objects to set.
     */
    public void setCourseGrades(List<CourseGrade> courseGrades) {
        this.courseGrades = courseGrades;
    }

    /**
     * Adds a CourseGrade object representing to the list of course grades.
     * If the provided CourseGrade object is not null, it is added to the list.
     * If the list of course grades is null, a new list is created and the CourseGrade object is added to it.
     * The student's GPA is updated accordingly.
     *
     * @param courseGrade The CourseGrade object representing the course taken by the student.
     */
    public void addCourseTaken(CourseGrade courseGrade) {
        if (courseGrade != null) {
            if (courseGrades != null) {
                courseGrades.add(courseGrade);
            } else {
                List<CourseGrade> tempCourseGrades = new ArrayList<>();
                tempCourseGrades.add(courseGrade);
                setCourseGrades(tempCourseGrades);
            }
            updateStudentGPA();
        } else {
            System.out.println("Error. Course not added. ");
        }
    }

    /**
     * Updates the student's GPA based on the list of course grades.
     * If the list is empty, the GPA is set to 0.0.
     * Otherwise, the total course credit and total grade points are calculated.
     * GPA is updated by dividing total grade points by total course credit.
     */
    private void updateStudentGPA() {
        if (courseGrades.isEmpty()) {
            GPA = 0.0;
            return;
        }
        int totalCourseCredit = 0;
        double totalGradePoint = 0.0;

        for (CourseGrade courseGrade : courseGrades) {
            totalCourseCredit += courseGrade.getCourseCredit();
            totalGradePoint += courseGrade.getCourseCredit() * courseGrade.getGradeTaken().getNumericValue();
        }
        GPA = totalGradePoint / totalCourseCredit;
    }

    /**
     * Returns a string representation of the student's transcript.
     * It includes the student's ID, all the course grades with their departments,
     * course codes, credits, letter grades, and the overall GPA.
     *
     * @return A string representation of the student's transcript.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Student ID: ").append(studentID).append('\n');
        for (CourseGrade courseGrade : courseGrades) {
            stringBuilder.append(courseGrade).append('\n');
        }
        stringBuilder.append("GPA: ").append(GPA);
        return stringBuilder.toString();
    }
}

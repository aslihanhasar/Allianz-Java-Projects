package com.aslihanhasar.JavaProjects.homeworks.thirdWeek.transcriptSimulation.util;

/**
 * The GradeTest class is a test program for the Grade enum.
 * It prints out the letter grades and their corresponding numerical values for each grade constant.
 * in the following form: "Grade F corresponds to numeric grade of 0".
 */
public class GradeTest {
    public static void main(String[] args) {
        for (Grade grade : Grade.values()) {
            System.out.println(grade);
        }
    }
}

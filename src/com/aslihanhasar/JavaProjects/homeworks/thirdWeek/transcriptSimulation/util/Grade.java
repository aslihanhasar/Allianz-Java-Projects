package com.aslihanhasar.JavaProjects.homeworks.thirdWeek.transcriptSimulation.util;

/**
 * The Grade enum represents student grades with both letter and numeric values.
 * It defines constants for the grades A, B, C, D, and F.
 * Each constant has a String representation (stringValue) for the letter grade (e.g., "C", "A"),
 * numericValue contains the numeric grade corresponding to the letter grade.
 */
public enum Grade {
    F("F", 0),
    D("D", 1),
    C("C", 2),
    B("B", 3),
    A("A", 4);
    private final String stringValue;
    private final int numericValue;

    /**
     * Constructor for Grade enum.
     *
     * @param stringValue  The String representation of the letter grade.
     * @param numericValue The numeric value corresponding to the letter grade.
     */
    Grade(String stringValue, int numericValue) {
        this.stringValue = stringValue;
        this.numericValue = numericValue;
    }

    /**
     * Get the String representation of the letter grade.
     *
     * @return The String representation of the letter grade.
     */
    public String getStringValue() {
        return stringValue;
    }

    /**
     * Get the numeric value corresponding to the letter grade.
     *
     * @return The numeric value corresponding to the letter grade.
     */
    public int getNumericValue() {
        return numericValue;
    }

    /**
     * Get a String representation of the Grade object.
     *
     * @return A String containing the letter grade and its numerical value.
     * (e.g., "Grade F: 0")
     */
    @Override
    public String toString() {
        return "Grade " + stringValue +
                " corresponds to numeric grade of " + numericValue;
    }
}

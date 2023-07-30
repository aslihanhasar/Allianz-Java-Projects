package com.aslihanhasar.JavaProjects.homeworks.thirdWeek.transcriptSimulation.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * The GenerateTranscript class allows the user to input student information or read student information
 * from a file to generate and print a student's transcript.
 */
public class GenerateTranscript {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Takes input from the user to enter course information and grades for a student.
     * It creates a Transcript object to store the entered course grades and prints the transcript.
     */
    public void takeInputFromUser() {
        System.out.print("Enter the student ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine();
        Transcript transcript = new Transcript(studentID);
        System.out.print("Enter course information for the student." + "\n" +
                "Press EOF indicator to stop entering grades.");
        while (scanner.hasNextLine()) {
            try {
                System.out.print("Enter the course department: ");
                String courseDepartment = scanner.next();
                System.out.print("Enter the course code: ");
                int courseCode = scanner.nextInt();
                System.out.print("Enter the course credit: ");
                int courseCredit = scanner.nextInt();
                System.out.print("Enter the course grade: ");
                double gradeTaken = scanner.nextDouble();
                CourseGrade courseGrade = new CourseGrade(courseDepartment, courseCode, courseCredit);
                courseGrade.setGradeTaken(gradeTaken);
                transcript.addCourseTaken(courseGrade);
            } catch (NoSuchElementException e) {
                System.out.println("Generating transcript...");
            }
        }
        System.out.println(transcript);
    }

    /**
     * Reads student information from a file and generates and prints the student's transcript.
     * The file should contain student ID followed by course information in each line.
     * The format of each line should be: "department courseCode courseCredit gradeTaken".
     */
    public void takeInputFromFile() {
        try {
            System.out.print("Enter the file name: ");
            String fileName = "src/com/aslihanhasar/JavaProjects/homeworks/thirdWeek/" +
                    "transcriptSimulation/" + scanner.next().trim();
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            int studentID = fileScanner.nextInt();
            fileScanner.nextLine();
            Transcript transcript = new Transcript(studentID);
            while (fileScanner.hasNextLine()) {
                String courseDepartment = fileScanner.next();
                int courseCode = fileScanner.nextInt();
                int courseCredit = fileScanner.nextInt();
                double gradeTaken = fileScanner.nextDouble();
                fileScanner.nextLine();
                CourseGrade courseGrade = new CourseGrade(courseDepartment, courseCode, courseCredit);
                courseGrade.setGradeTaken(gradeTaken);
                transcript.addCourseTaken(courseGrade);
            }
            System.out.println(transcript);
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        } catch (Exception e) {
            System.err.println("Error: Invalid file format.");
        }
    }
}



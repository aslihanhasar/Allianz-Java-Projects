package com.aslihanhasar.JavaProjects.homeworks.thirdWeek.transcriptSimulation.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GenerateTranscript {
    private final Scanner scanner = new Scanner(System.in);

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
            System.err.println("Error: Invalid file format." + e.getMessage());
            e.printStackTrace();
        }
    }
}



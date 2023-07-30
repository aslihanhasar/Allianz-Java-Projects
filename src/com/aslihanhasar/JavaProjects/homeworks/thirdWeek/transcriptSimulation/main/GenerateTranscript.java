package com.aslihanhasar.JavaProjects.homeworks.thirdWeek.transcriptSimulation.main;

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
            }catch (NoSuchElementException e){
                System.out.println("Generating transcript...");
            }
        }
        System.out.println(transcript);
    }
}


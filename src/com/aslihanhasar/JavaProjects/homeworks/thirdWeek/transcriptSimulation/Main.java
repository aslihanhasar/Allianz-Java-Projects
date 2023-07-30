package com.aslihanhasar.JavaProjects.homeworks.thirdWeek.transcriptSimulation;

import com.aslihanhasar.JavaProjects.homeworks.thirdWeek.transcriptSimulation.main.GenerateTranscript;

public class Main {
    /**
     * The main method is the entry point of the application.
     * It creates an instance of the GenerateTranscript class and calls its methods.
     */
    public static void main(String[] args) {
        /*
        CourseGrade courseGrade = new CourseGrade("ceng", 102, 5, Grade.B);
        CourseGrade courseGrade2 = new CourseGrade("eCE", 52, 4, Grade.C);
        CourseGrade courseGrade3 = new CourseGrade("comp", 186, 3, Grade.C);
        CourseGrade courseGrade4 = new CourseGrade("math", 250, 4, Grade.A);
        CourseGrade courseGrade5 = new CourseGrade("che", 365, 2, Grade.A);

        Transcript transcript = new Transcript(1);
        transcript.addCourseTaken(courseGrade);
        transcript.addCourseTaken(courseGrade2);
        transcript.addCourseTaken(courseGrade3);
        transcript.addCourseTaken(courseGrade4);
        transcript.addCourseTaken(courseGrade5);
        System.out.println(transcript);

         */

        GenerateTranscript generateTranscript = new GenerateTranscript();
        generateTranscript.takeInputFromUser();
        generateTranscript.takeInputFromFile();
    }
}

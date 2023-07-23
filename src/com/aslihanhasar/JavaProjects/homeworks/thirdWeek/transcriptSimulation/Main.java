package com.aslihanhasar.JavaProjects.homeworks.thirdWeek.transcriptSimulation;


import com.aslihanhasar.JavaProjects.homeworks.thirdWeek.transcriptSimulation.main.CourseGrade;
import com.aslihanhasar.JavaProjects.homeworks.thirdWeek.transcriptSimulation.main.Transcript;
import com.aslihanhasar.JavaProjects.homeworks.thirdWeek.transcriptSimulation.util.Grade;

public class Main {
    public static void main(String[] args) {
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
    }
}

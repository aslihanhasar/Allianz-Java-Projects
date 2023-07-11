package com.aslihanhsr.JavaProjects.secondWeek.danceCourseSimulation.service;

import com.aslihanhsr.JavaProjects.secondWeek.danceCourseSimulation.model.*;

import java.util.List;

public class LectureService {
    public Branch createBranch(String name) {
        Branch branch = new Branch();
        branch.setName(name);
        return branch;
    }

    public LectureScheduleTime createLectureScheduleTime(Day day, String time) {
        LectureScheduleTime lectureScheduleTime = new LectureScheduleTime();
        lectureScheduleTime.setDay(day);
        lectureScheduleTime.setTime(time);
        return lectureScheduleTime;
    }

    public Lecture createLecture(String name, Instructor instructor, Branch branch, int capacity,
                                 List<LectureScheduleTime> lectureScheduleTimes, List<Student> students) {
        Lecture lecture = new Lecture();
        lecture.setName(name);
        lecture.setInstructor(instructor);
        lecture.setBranch(branch);
        lecture.setCapacity(capacity);
        lecture.setLectureScheduleTimes(lectureScheduleTimes);
        lecture.setStudents(students);
        return lecture;
    }
}

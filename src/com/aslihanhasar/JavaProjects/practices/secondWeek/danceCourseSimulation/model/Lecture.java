package com.aslihanhasar.JavaProjects.practices.secondWeek.danceCourseSimulation.model;

import java.util.List;

public class Lecture {
    private String name;
    private Instructor instructor;
    private Branch branch;
    private int capacity;
    private List<LectureScheduleTime> lectureScheduleTimes;
    private List<Student> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<LectureScheduleTime> getLectureScheduleTimes() {
        return lectureScheduleTimes;
    }

    public void setLectureScheduleTimes(List<LectureScheduleTime> lectureScheduleTimes) {
        this.lectureScheduleTimes = lectureScheduleTimes;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "name='" + name + '\'' +
                ", instructor=" + instructor +
                ", branch=" + branch +
                ", capacity=" + capacity +
                ", lectureScheduleTimes=" + lectureScheduleTimes +
                ", students=" + students +
                '}';
    }
}

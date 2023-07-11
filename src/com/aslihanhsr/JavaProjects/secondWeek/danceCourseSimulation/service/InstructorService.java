package com.aslihanhsr.JavaProjects.secondWeek.danceCourseSimulation.service;

import com.aslihanhsr.JavaProjects.secondWeek.danceCourseSimulation.model.Branch;
import com.aslihanhsr.JavaProjects.secondWeek.danceCourseSimulation.model.Instructor;
import com.aslihanhsr.JavaProjects.secondWeek.danceCourseSimulation.model.Sex;

import java.math.BigDecimal;
import java.util.List;

public class InstructorService {
    public Instructor createInstructor(String name, List<Branch> branches, int age,
                                       Sex sex, BigDecimal salary) {
        Instructor instructor = new Instructor();
        instructor.setName(name);
        instructor.setBranches(branches);
        instructor.setAge(age);
        instructor.setSex(sex);
        instructor.setSalary(salary);
        return instructor;
    }
}

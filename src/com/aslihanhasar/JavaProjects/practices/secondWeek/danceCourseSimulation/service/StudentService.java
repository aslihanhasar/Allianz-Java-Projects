package com.aslihanhasar.JavaProjects.practices.secondWeek.danceCourseSimulation.service;

import com.aslihanhasar.JavaProjects.practices.secondWeek.danceCourseSimulation.model.Sex;
import com.aslihanhasar.JavaProjects.practices.secondWeek.danceCourseSimulation.model.Student;

import java.math.BigDecimal;
import java.util.Date;

public class StudentService {
    public Student createStudent(String name, int age, Sex sex, boolean isPaid,
                                 BigDecimal contractAmount, Date startDate, Date endDate) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setSex(sex);
        student.setPaid(isPaid);
        student.setContractAmount(contractAmount);
        student.setStartDate(startDate);
        student.setEndDate(endDate);
        return student;
    }
}

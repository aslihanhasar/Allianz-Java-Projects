package com.aslihanhasar.JavaProjects.practices.secondWeek.danceCourseSimulation.model;

public class Branch {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "name='" + name + '\'' +
                '}';
    }
}

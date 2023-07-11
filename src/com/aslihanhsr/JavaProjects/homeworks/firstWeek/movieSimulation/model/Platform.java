package com.aslihanhsr.JavaProjects.homeworks.firstWeek.movieSimulation.model;

public class Platform {
    private String platformName;

    public Platform(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @Override
    public String toString() {
        return "Platform Name: " + platformName;
    }
}

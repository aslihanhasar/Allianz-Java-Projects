package com.aslihanhasar.JavaProjects.homeworks.firstWeek.movieSimulation.model;

public class Category {
    private final String categoryName;
    private int movieCounter;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getMovieCounter() {
        return movieCounter;
    }

    public void setMovieCounter(int movieCounter) {
        this.movieCounter = movieCounter;
    }

    public void incrementMovieCounter() {
        this.movieCounter++;
    }

    @Override
    public String toString() {
        return "\nCategory Name: " + categoryName + '\n' +
                "Number of Movies: " + movieCounter;
    }
}

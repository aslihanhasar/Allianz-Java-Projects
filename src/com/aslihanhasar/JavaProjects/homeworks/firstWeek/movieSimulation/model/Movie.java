package com.aslihanhasar.JavaProjects.homeworks.firstWeek.movieSimulation.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private final String filmName;
    private final String director;
    private final String releaseDate;
    private final String[] showTimes;
    private final double imdb;
    private List<Category> categories;
    private List<Platform> platforms;

    public Movie(String filmName, String director, String releaseDate, String[] showTime, double imdb) {
        this.filmName = filmName;
        this.director = director;
        this.releaseDate = releaseDate;
        this.showTimes = showTime;
        this.imdb = imdb;
        categories = new ArrayList<>();
        platforms = new ArrayList<>();
    }

    public String getFilmName() {
        return filmName;
    }

    public String getDirector() {
        return director;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String[] getShowTimes() {
        return showTimes;
    }

    public double getImdb() {
        return imdb;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    @Override
    public String toString() {
        return "\n***** Movie *****" + '\n' +
                "Film Name: " + filmName + '\n' +
                "Director: '" + director + '\n' +
                "Release Date:" + releaseDate + '\n' +
                "Show Times: " + Arrays.toString(showTimes) + '\n' +
                "IMDB: " + imdb + '\n' +
                "Categories: " + getCategories() + '\n' +
                "Platforms: " + getPlatforms();
    }
}

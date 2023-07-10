package com.aslihanhsr.JavaProjects.firstWeek.movieSimulation.service;

import com.aslihanhsr.JavaProjects.firstWeek.movieSimulation.model.*;

import java.util.ArrayList;
import java.util.List;

public class AppManagementService {
    private final List<Category> categories;
    private final List<Platform> platforms;
    private final List<Movie> movies;

    public AppManagementService() {
        this.categories = new ArrayList<>();
        this.platforms = new ArrayList<>();
        this.movies = new ArrayList<>();
    }

    public void addCategoryToApp(Category category) {
        categories.add(category);
    }

    public void addPlatformToApp(Platform platform) {
        platforms.add(platform);
    }

    public void addMovieToApp(Movie movie, String[] categoriesInputArr, String[] platformsInputArr) {
        boolean categoriesAddedToMovie = addCategoriesToMovie(movie, categoriesInputArr);
        boolean platformsAddedToMovie = addPlatformsToMovie(movie, platformsInputArr);
        if (categoriesAddedToMovie && platformsAddedToMovie) {
            movies.add(movie);
            increaseMovieCounter(movie.getCategories());
            System.out.println("Movie successfully added");
        } else {
            System.out.println("Movie creation failed. Categories or platforms not found.");
        }
    }

    public void listMoviesByCategoryName(String categoryName) {
        Category category = getCategoryByName(categoryName);
        for (Movie movie : movies) {
            boolean categoryExist = movie.getCategories().contains(category);
            if (categoryExist) {
                System.out.println(category);
                System.out.println(movie);
            }
        }
    }


    private void increaseMovieCounter(List<Category> movieCategories) {
        for (Category movieCategory : movieCategories) {
            String movieCategoryName = movieCategory.getCategoryName();
            Category categoryByName = getCategoryByName(movieCategoryName);
            if (categoryByName != null) {
                movieCategory.incrementMovieCounter();
            } else {
                System.out.println("Category not found.");
            }
        }
    }

    private boolean addCategoriesToMovie(Movie movie, String[] categoriesInputArr) {
        for (String categoryInput : categoriesInputArr) {
            Category category = getCategoryByName(categoryInput);
            if (category != null) {
                List<Category> movieCategories = new ArrayList<>();
                movieCategories.add(category);
                movie.setCategories(movieCategories);
            } else {
                System.out.println("No such a category found. " + categoryInput);
                return false;
            }
        }
        return true;
    }

    private boolean addPlatformsToMovie(Movie movie, String[] platformsInputArr) {
        for (String platformInput : platformsInputArr) {
            Platform platform = getPlatformByName(platformInput);
            if (platform != null) {
                List<Platform> moviePlatforms = new ArrayList<>();
                moviePlatforms.add(platform);
                movie.setPlatforms(moviePlatforms);
            } else {
                System.out.println("No such a platform found. " + platformInput);
                return false;
            }
        }
        return true;
    }

    private Category getCategoryByName(String categoryName) {
        for (Category category : categories) {
            boolean categoriesMatch = category.getCategoryName().equalsIgnoreCase(categoryName);
            if (categoriesMatch) {
                return category;
            }
        }
        return null;
    }

    private Platform getPlatformByName(String platformName) {
        for (Platform platform : platforms) {
            boolean platformsMatch = platform.getPlatformName().equalsIgnoreCase(platformName);
            if (platformsMatch) {
                return platform;
            }
        }
        return null;
    }

}
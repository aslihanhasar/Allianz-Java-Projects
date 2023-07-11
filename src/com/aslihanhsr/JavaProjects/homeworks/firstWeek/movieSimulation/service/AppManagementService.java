package com.aslihanhsr.JavaProjects.homeworks.firstWeek.movieSimulation.service;

import com.aslihanhsr.JavaProjects.homeworks.firstWeek.movieSimulation.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The AppManagementService class provides methods to manage categories,
 * platforms, and movies in the movie simulation app.
 */
public class AppManagementService {
    private final List<Category> categories;
    private final List<Platform> platforms;
    private final List<Movie> movies;

    /**
     * Constructs a new instance of AppManagementService
     * with empty lists of categories, platforms, and movies.
     */
    public AppManagementService() {
        this.categories = new ArrayList<>();
        this.platforms = new ArrayList<>();
        this.movies = new ArrayList<>();
    }

    /**
     * Adds a category to the app.
     *
     * @param category The category to be added.
     */
    public void addCategoryToApp(Category category) {
        categories.add(category);
    }

    /**
     * Adds a platform to the app.
     *
     * @param platform The platform to be added.
     */
    public void addPlatformToApp(Platform platform) {
        platforms.add(platform);
    }

    /**
     * Adds a movie to the app with
     * the specified categories and platforms.
     *
     * @param movie              The movie to be added.
     * @param categoriesInputArr An array of category names to be assigned to the movie.
     * @param platformsInputArr  An array of platform names to be assigned to the movie.
     */
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

    /**
     * Lists movies in the app filtered
     * by the specified category name.
     *
     * @param categoryName The name of the category to filter movies by.
     */
    public void listMoviesByCategoryName(String categoryName) {
        Category category = getCategoryByName(categoryName);
        if (category != null) {
            System.out.println(category);
            for (Movie movie : movies) {
                boolean categoryExist = movie.getCategories().contains(category);
                if (categoryExist) {
                    System.out.println(movie);
                }
            }
        } else {
            System.out.println("No such category found" + categoryName);
        }
    }

    /**
     * Lists all categories in the app.
     */
    public void listCategories() {
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    /**
     * Lists all platforms in the app.
     */
    public void listPlatforms() {
        for (Platform platform : platforms) {
            System.out.println(platform);
        }
    }

    /**
     * Lists all movies in the app.
     */
    public void listMovies() {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    /**
     * Adds categories to the specified movie.
     *
     * @param movie              The movie to add categories to.
     * @param categoriesInputArr An array of category names to be assigned to the movie.
     * @return True if all categories are successfully added, false otherwise.
     */
    private boolean addCategoriesToMovie(Movie movie, String[] categoriesInputArr) {
        List<Category> movieCategories = new ArrayList<>();
        for (String categoryInput : categoriesInputArr) {
            Category category = getCategoryByName(categoryInput);
            if (category != null) {
                movieCategories.add(category);
            } else {
                System.out.println("No such a category found. " + categoryInput);
                return false;
            }
        }
        movie.setCategories(movieCategories);
        return true;
    }

    /**
     * Adds platforms to the specified movie.
     *
     * @param movie             The movie to add platforms to.
     * @param platformsInputArr An array of platform names to be assigned to the movie.
     * @return True if all platforms are successfully added, false otherwise.
     */
    private boolean addPlatformsToMovie(Movie movie, String[] platformsInputArr) {
        List<Platform> moviePlatforms = new ArrayList<>();
        for (String platformInput : platformsInputArr) {
            Platform platform = getPlatformByName(platformInput);
            if (platform != null) {
                moviePlatforms.add(platform);
            } else {
                System.out.println("No such a platform found. " + platformInput);
                return false;
            }
        }
        movie.setPlatforms(moviePlatforms);
        return true;
    }

    /**
     * Retrieves a category object by its name.
     *
     * @param categoryName The name of the category to retrieve.
     * @return The Category object if found, null otherwise.
     */
    private Category getCategoryByName(String categoryName) {
        for (Category category : categories) {
            boolean categoriesMatch = category.getCategoryName().equalsIgnoreCase(categoryName.trim());
            if (categoriesMatch) {
                return category;
            }
        }
        return null;
    }

    /**
     * Retrieves a platform object by its name.
     *
     * @param platformName The name of the platform to retrieve.
     * @return The Platform object if found, null otherwise.
     */
    private Platform getPlatformByName(String platformName) {
        for (Platform platform : platforms) {
            boolean platformsMatch = platform.getPlatformName().equalsIgnoreCase(platformName.trim());
            if (platformsMatch) {
                return platform;
            }
        }
        return null;
    }

    /**
     * Increases the movie counter for each category
     * in the specified list of movie categories.
     *
     * @param movieCategories The list of categories associated with a movie.
     */
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
}

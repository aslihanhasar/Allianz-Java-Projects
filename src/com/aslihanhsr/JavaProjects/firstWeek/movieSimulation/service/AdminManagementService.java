package com.aslihanhsr.JavaProjects.firstWeek.movieSimulation.service;

import com.aslihanhsr.JavaProjects.firstWeek.movieSimulation.model.*;

import java.util.Scanner;

public class AdminManagementService {
    private final AppManagementService appManagement = new AppManagementService();
    private final Scanner scanner = new Scanner(System.in);

   

    private void createCategory() {
        System.out.print("Enter the category name: ");
        String categoryName = scanner.next();
        Category category = new Category(categoryName);
        appManagement.addCategoryToApp(category);
    }

    private void createPlatform() {
        System.out.print("Enter the platform name: ");
        String platformName = scanner.next();
        Platform platform = new Platform(platformName);
        appManagement.addPlatformToApp(platform);
    }

    private void createMovie() {
        Movie movie = getMovieFromInput();
        System.out.println("Categories you added to the app: ");
        appManagement.listCategories();
        System.out.print("Enter the film categories (with a comma) : ");
        String[] categoriesInputArr = scanner.next().split(",");
        System.out.println("Platforms you added to the app: ");
        appManagement.listPlatforms();
        System.out.print("Enter the film platforms (with a comma) : ");
        String[] platformsInputArr = scanner.next().split(",");
        appManagement.addMovieToApp(movie, categoriesInputArr, platformsInputArr);
        appManagement.listMovies();
    }

    private Movie getMovieFromInput() {
        System.out.print("Enter the film name: ");
        String filmName = scanner.next();
        System.out.print("Enter the film director: ");
        String director = scanner.next();
        System.out.print("Enter the film release date (dd-MM-yyyy) : ");
        String releaseDate = scanner.next();
        System.out.print("Enter the film show times with a comma: ");
        String[] showTimes = scanner.next().split(",");
        System.out.print("Enter the film IMDB: ");
        double imdbPoint = scanner.nextDouble();
        return new Movie(filmName, director, releaseDate, showTimes, imdbPoint);
    }

    private void adminOperationsMenu() {
        System.out.print("""
                \n***** Admin Operations *****
                1 - Add Category.
                2 - Add Platform
                3 - Add Film.
                4 - Main Menu.
                Enter your choice:\s""");
    }
}

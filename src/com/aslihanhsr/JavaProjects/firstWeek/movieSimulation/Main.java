package com.aslihanhsr.JavaProjects.firstWeek.movieSimulation;

import com.aslihanhsr.JavaProjects.firstWeek.movieSimulation.model.*;
import com.aslihanhsr.JavaProjects.firstWeek.movieSimulation.service.AppManagementService;

import java.util.Scanner;

public class Main {
    private static final AppManagementService appManagementService = new AppManagementService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMainMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> adminOperations();
                case 2 -> userOperations();
                case 3 -> exit = true;
                default -> System.out.println("Enter a valid choice (1/2/3)");
            }
        }
    }

    private static void adminOperations() {
        boolean backToMenu = false;
        do {
            adminOperationsMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> createCategory();
                case 2 -> createPlatform();
                case 3 -> createMovie();
                case 4 -> backToMenu = true;
                default -> System.out.println("Enter a valid choice (1/2/3/4)");
            }
        } while (!backToMenu);
    }

    private static void userOperations() {
        boolean backToMenu = false;
        do {
            userOperationsMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the category name to search movies: ");
                    String categoryName = scanner.next();
                    appManagementService.listMoviesByCategoryName(categoryName);
                }
                case 2 -> backToMenu = true;
                default -> System.out.println("Enter a valid choice (1/2)");
            }
        } while (!backToMenu);
    }

    private static void createCategory() {
        System.out.print("Enter the category name: ");
        String categoryName = scanner.next();
        Category category = new Category(categoryName);
        appManagementService.addCategoryToApp(category);
    }

    private static void createPlatform() {
        System.out.print("Enter the platform name: ");
        String platformName = scanner.next();
        Platform platform = new Platform(platformName);
        appManagementService.addPlatformToApp(platform);
    }

    private static void createMovie() {
        Movie movie = getMovieFromInput();
        System.out.println("Categories you added to the app: ");
        appManagementService.listCategories();
        System.out.print("\nEnter the film categories (with a comma) : ");
        String[] categoriesInputArr = scanner.next().split(",");
        System.out.println("\nPlatforms you added to the app: ");
        appManagementService.listPlatforms();
        System.out.print("\nEnter the film platforms (with a comma) : ");
        String[] platformsInputArr = scanner.next().split(",");
        appManagementService.addMovieToApp(movie, categoriesInputArr, platformsInputArr);
        appManagementService.listMovies();
    }

    private static Movie getMovieFromInput() {
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

    private static void printMainMenu() {
        System.out.print("""
                \n***** Welcome to the Movie Management App *****
                1 - Admin Operations.
                2 - User Operations.
                3 - Exit.
                Enter Your choice:\s""");
    }

    private static void adminOperationsMenu() {
        System.out.print("""
                \n***** Admin Operations *****
                1 - Add Category.
                2 - Add Platform
                3 - Add Film.
                4 - Main Menu.
                Enter your choice:\s""");
    }

    private static void userOperationsMenu() {
        System.out.print("""
                \n***** User Operations *****
                1 - List Movies and Categories.
                2 - Main Menu.
                Enter Your choice:\s""");
    }

}

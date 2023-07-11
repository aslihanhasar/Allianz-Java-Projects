package com.aslihanhsr.JavaProjects.homeworks.firstWeek.movieSimulation;

import com.aslihanhsr.JavaProjects.homeworks.firstWeek.movieSimulation.service.AppManagementService;
import com.aslihanhsr.JavaProjects.homeworks.firstWeek.movieSimulation.model.*;

import java.util.Scanner;

/**
 * This class represents the main entry point of the Movie Simulation.
 * It provides functionality for both admin and user operations.
 */
public class Main {
    private static final AppManagementService appManagementService = new AppManagementService();
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * The main method that starts the Movie Simulation.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMainMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> adminOperations();
                case 2 -> userOperations();
                case 3 -> exit = true;
                default -> System.out.println("Enter a valid choice (1/2/3)");
            }
        }
    }

    /**
     * Performs the admin operations,
     * allowing the user to create categories,
     * platforms, and movies.
     */
    private static void adminOperations() {
        boolean backToMenu = false;
        do {
            adminOperationsMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> createCategory();
                case 2 -> createPlatform();
                case 3 -> createMovie();
                case 4 -> backToMenu = true;
                default -> System.out.println("Enter a valid choice (1/2/3/4)");
            }
        } while (!backToMenu);
    }

    /**
     * Performs the user operations,
     * allowing the user to list movies by category.
     */
    private static void userOperations() {
        boolean backToMenu = false;
        do {
            userOperationsMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the category name to search movies: ");
                    String categoryName = scanner.nextLine();
                    appManagementService.listMoviesByCategoryName(categoryName);
                }
                case 2 -> backToMenu = true;
                default -> System.out.println("Enter a valid choice (1/2)");
            }
        } while (!backToMenu);
    }

    /**
     * Creates a new category by taking user input.
     */
    private static void createCategory() {
        System.out.print("Enter the category name: ");
        String categoryName = scanner.nextLine();
        Category category = new Category(categoryName);
        appManagementService.addCategoryToApp(category);
    }

    /**
     * Creates a new platform by taking user input.
     */
    private static void createPlatform() {
        System.out.print("Enter the platform name: ");
        String platformName = scanner.nextLine();
        Platform platform = new Platform(platformName);
        appManagementService.addPlatformToApp(platform);
    }

    /**
     * Creates a new movie by taking user input
     * for movie details, categories, and platforms.
     */
    private static void createMovie() {
        Movie movie = getMovieFromInput();
        System.out.println("Categories you added to the app: ");
        appManagementService.listCategories();
        System.out.print("\nEnter the film categories (with a comma) : ");
        String[] categoriesInputArr = scanner.nextLine().split(",");
        System.out.println("\nPlatforms you added to the app: ");
        appManagementService.listPlatforms();
        System.out.print("\nEnter the film platforms (with a comma) : ");
        String[] platformsInputArr = scanner.nextLine().split(",");
        appManagementService.addMovieToApp(movie, categoriesInputArr, platformsInputArr);
        appManagementService.listMovies();
    }

    /**
     * Retrieves movie details from user input.
     *
     * @return The created movie object.
     */
    private static Movie getMovieFromInput() {
        System.out.print("Enter the film name: ");
        String filmName = scanner.nextLine();
        System.out.print("Enter the film director: ");
        String director = scanner.nextLine();
        System.out.print("Enter the film release date (dd-MM-yyyy) : ");
        String releaseDate = scanner.nextLine();
        System.out.print("Enter the film show times with a comma: ");
        String[] showTimes = scanner.nextLine().split(",");
        System.out.print("Enter the film IMDB: ");
        double imdbPoint = Double.parseDouble(scanner.nextLine());
        return new Movie(filmName, director, releaseDate, showTimes, imdbPoint);
    }

    /**
     * Prints the main menu of the Movie Management App.
     */
    private static void printMainMenu() {
        System.out.print("""
                \n***** Welcome to the Movie Management App *****
                1 - Admin Operations.
                2 - User Operations.
                3 - Exit.
                Enter Your choice:\s""");
    }

    /**
     * Prints the admin operations menu.
     */
    private static void adminOperationsMenu() {
        System.out.print("""
                \n***** Admin Operations *****
                1 - Add Category.
                2 - Add Platform
                3 - Add Film.
                4 - Main Menu.
                Enter your choice:\s""");
    }

    /**
     * Prints the user operations menu.
     */
    private static void userOperationsMenu() {
        System.out.print("""
                \n***** User Operations *****
                1 - List Movies and Categories.
                2 - Main Menu.
                Enter Your choice:\s""");
    }

}

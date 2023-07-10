package com.aslihanhsr.JavaProjects.firstWeek.movieSimulation.service;

import java.util.Scanner;

public class UserManagementService {
    private final AppManagementService appManagement = new AppManagementService();
    private final Scanner scanner = new Scanner(System.in);

    public void userOperations() {
        int choice;
        boolean backToMenu = false;
        do {
            userOperationsMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the category name to search movies:");
                    String categoryName = scanner.next();
                    appManagement.listMoviesByCategoryName(categoryName);
                }
                case 2 -> backToMenu = true;
                default -> System.out.println("Enter a valid choice (1/2)");
            }
        } while (!backToMenu);
    }

    private void userOperationsMenu() {
        System.out.print("""
                \n***** User Operations *****
                1 - List Movies and Categories.
                2 - Main Menu.
                Enter Your choice:\s""");
    }
}

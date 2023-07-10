package com.aslihanhsr.JavaProjects.firstWeek.movieSimulation;

import com.aslihanhsr.JavaProjects.firstWeek.movieSimulation.service.AdminManagementService;
import com.aslihanhsr.JavaProjects.firstWeek.movieSimulation.service.UserManagementService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AdminManagementService adminService = new AdminManagementService();
        UserManagementService userService = new UserManagementService();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            printMainMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> adminService.adminOperations();
                case 2 -> userService.userOperations();
                case 3 -> exit = true;
                default -> System.out.println("Enter a valid choice (1/2/3)");
            }
        }
    }

    private static void printMainMenu() {
        System.out.print("""
                \n***** Welcome to the Movie Management App *****
                1 - Admin Operations.
                2 - User Operations.
                3 - Exit.
                Enter Your choice:\s""");
    }
}

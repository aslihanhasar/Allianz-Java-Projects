package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.service;

import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.*;

import java.util.Scanner;

public class PlayerService {
    private final Scanner scanner;

    public PlayerService(){
        scanner=new Scanner(System.in);
    }

    public Player createPlayer(int id){
        System.out.println("Create player. Enter the name: ");
        String name=scanner.next();;
        switch (id) {
            case 1 -> {
                return new Player1(name);
            }
            case 2 -> {
                return new Player2(name);
            }
            default -> {
                return null;
            }
        }
    }

}

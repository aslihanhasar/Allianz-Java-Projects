package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation;

import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.service.GameService;

public class Main {
    public static void main(String[] args) {
        GameService gameService=new GameService();
        gameService.startGame();
    }
}

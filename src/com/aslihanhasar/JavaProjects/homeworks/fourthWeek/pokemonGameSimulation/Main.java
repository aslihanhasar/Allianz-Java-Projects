package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation;

import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.service.GameService;


/**
 * The Main class serves as the entry point to the Pokemon game.
 * It creates an instance of GameService and starts the game by calling the startGame() method.
 */
public class Main {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.startGame();
    }
}

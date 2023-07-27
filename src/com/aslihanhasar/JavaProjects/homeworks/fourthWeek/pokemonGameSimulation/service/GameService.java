package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.service;

import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.Game;
import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.Player;
import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.Player1;

import java.util.Scanner;

public class GameService {
    private final Scanner scanner = new Scanner(System.in);
    private final PlayerService playerService = new PlayerService();
    private final LoadService loadService=new LoadService();
    private Game game;
    private String inputPlayer1;
    private String inputPlayer2;

    public void startGame() {
        boolean startGame = isGameStart();
        if (startGame) {
            System.out.println("******* The Pokemon Game is starting. *******");
            Player player1=playerService.createPlayer(1);
            Player player2=playerService.createPlayer(2);
            game=new Game(player1,player2);
            loadGame();




        } else {
            System.out.println("No player match found.");
        }

    }

    private boolean isGameStart(){
        printStartMenu();
        inputPlayer1 =scanner.next().trim();
        printStartMenu();
        inputPlayer2 =scanner.next().trim();
        return inputPlayer1.equals(inputPlayer2);
    }

    private void loadGame(){
        System.out.println("Loading...");
        game.setGameCharacters(loadService.loadCharacters());
        game.setGamePokemons(loadService.loadPokemons());
    }
    private void printStartMenu() {
        System.out.print("""
                *********** THE POKEMON GAME ***********
                Are you ready to fight ?
                1 - Start Game
                2 - Exit
                Enter your choice(1/2)""");
    }

}
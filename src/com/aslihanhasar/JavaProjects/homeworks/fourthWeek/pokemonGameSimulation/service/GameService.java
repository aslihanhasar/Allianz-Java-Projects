package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.service;

import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class GameService {
    private final Scanner scanner = new Scanner(System.in);
    private final PlayerService playerService = new PlayerService();
    private final LoadService loadService = new LoadService();
    private Game game;
    private String inputPlayer1;
    private String inputPlayer2;

    public void startGame() {
        boolean startGame = isGameStart();
        if (startGame) {
            System.out.println("******* The Pokemon Game is starting. *******");
            Player player1 = playerService.createPlayer(1);
            Player player2 = playerService.createPlayer(2);
            game = new Game(player1, player2);
            loadGame();
            listCharactersInGame();
            playerService.selectCharacter(game,player1);
            playerService.selectCharacter(game,player2);
            listPokemonsInGame();
            playerService.selectPokemon(game,player1);
            playerService.selectPokemon(game,player2);
            System.out.println("Level 1 is starting..");
            System.out.println("Player 1 Information: "+player1);
            System.out.println("Player 2 Information: "+player2);
        } else {
            System.out.println("No player match found.");
        }

    }

    private boolean isGameStart() {
        printStartMenu();
        inputPlayer1 = scanner.next().trim();
        printStartMenu();
        inputPlayer2 = scanner.next().trim();
        return inputPlayer1.equals(inputPlayer2);
    }

    private void loadGame() {
        System.out.println("Loading...");
        game.setGameCharacters(loadService.loadCharacters());
        game.setGamePokemons(loadService.loadPokemons());
    }

    private void listCharactersInGame() {
        System.out.println(" ****** CHARACTERS ******");
        for (GameCharacter character : game.getGameCharacters()) {
            System.out.println(character);
        }
    }

    private void listPokemonsInGame() {
        System.out.println(" ****** POKEMONS ******");
        for (Pokemon pokemon : game.getGamePokemons()) {
            System.out.println(pokemon);
        }
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
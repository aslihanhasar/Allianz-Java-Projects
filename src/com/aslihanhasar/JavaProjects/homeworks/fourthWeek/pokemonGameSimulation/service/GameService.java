package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.service;

import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.Game;
import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.*;

import java.util.Scanner;

public class GameService {
    private final Scanner scanner = new Scanner(System.in);
    private final PlayerService playerService = new PlayerService();
    private final LoadService loadService = new LoadService();
    private Game game;

    public void startGame() {
        boolean startGame = isGameStart();
        int levelCount = 2;
        boolean gameOver = false;
        if (startGame) {
            System.out.println("******* The Pokemon Game is starting. *******");
            Player player1 = playerService.createPlayer(1);
            Player player2 = playerService.createPlayer(2);
            game = new Game(player1, player2);
            loadGame();
            listCharactersInGame();
            playerService.selectCharacter(game, player1);
            playerService.selectCharacter(game, player2);
            listPokemonsInGame();
            playerService.selectPokemon(game, player1);
            listPokemonsInGame();
            playerService.selectPokemon(game, player2);
            while (levelCount > 0) {
                System.out.println("Level " + (levelCount - 1) + " is starting..");
                System.out.println("\nPlayer 1 Information: " + player1);
                System.out.println("\nPlayer 2 Information: " + player2);
                System.out.println("The dice are thrown..");
                Player attacker = playerService.getAttackerPlayer(game);
                System.out.println("Attacker player : "+attacker);
                Player defender = (attacker.equals(game.getPlayer1())) ? game.getPlayer2() : game.getPlayer1();
                System.out.println("Defender player: "+defender);
                do{
                    playerService.attackToPlayer(attacker, defender);
                    if(isGameOver(attacker,defender)){
                        gameOver=true;
                    }
                    Player tempPlayer=attacker;
                    attacker=defender;
                    defender=tempPlayer;
                    System.out.println(attacker);
                    System.out.println(defender);
                }while(!gameOver);
                System.out.println("NEXT LEVEL");
                playerService.updatePlayer(game);
                levelCount--;
            }

        } else {
            System.out.println("No player match found.");
        }
    }

    private boolean isGameOver(Player attacker, Player defender) {
        boolean attackerLoser = playerService.isPlayerLost(attacker);
        boolean defenderLoser = playerService.isPlayerLost(defender);
        return attackerLoser || defenderLoser;
    }

    private boolean isGameStart() {
        printStartMenu();
        String inputPlayer1 = scanner.next().trim();
        printStartMenu();
        String inputPlayer2 = scanner.next().trim();
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
                Enter your choice(1/2):""");
    }

}
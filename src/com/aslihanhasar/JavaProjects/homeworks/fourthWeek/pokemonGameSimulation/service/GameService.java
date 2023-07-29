package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.service;

import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.*;

import java.util.Scanner;

/**
 * The GameService class is responsible for managing the game and its flow.
 * It provides methods for starting the game, loading characters and Pokémon, selecting players and characters,
 * and conducting battles between players.
 */
public class GameService {
    private final Scanner scanner = new Scanner(System.in);
    private final PlayerService playerService = new PlayerService();
    private final LoadService loadService = new LoadService();
    private Game game;

    /**
     * Starts the Pokemon game and manages its flow.
     * Initializes players, characters, and Pokemon for the game.
     * Conduct battles between players for multiple levels until the game is over.
     */
    public void startGame() {
        boolean startGame = isGameStart();
        int levelCount = 2;
        boolean gameOver = false;
        if (startGame) {
            System.out.println("******* The Pokemon Game is starting. *******");
            Player player1 = playerService.createPlayer(1);
            Player player2 = playerService.createPlayer(2);
            System.out.println("\nPlayer1 Name: " + player1.getName());
            System.out.println("\nPlayer2 Name: " + player2.getName());
            game = new Game(player1, player2);
            loadGame();
            listCharactersInGame();
            System.out.println("---- " + (player1.getName()) + "----");
            playerService.selectCharacter(game, player1);
            System.out.println("---- " + (player2.getName()) + "----");
            playerService.selectCharacter(game, player2);
            listPokemonsInGame();
            System.out.println("---- " + (player1.getName()) + "----");
            playerService.selectPokemon(game, player1);
            listPokemonsInGame();
            System.out.println("---- " + (player2.getName()) + "----");
            playerService.selectPokemon(game, player2);
            while (levelCount > 0) {
                System.out.println("\nLevel " + (levelCount - 1) + " is starting..");
                System.out.println("\n********** Player 1 Information: **********" + player1);
                System.out.println("\n********** Player 2 Information: **********" + player2);
                System.out.println("\nThe dice are thrown..");
                Player attacker = playerService.getAttackerPlayer(game);
                System.out.println("\n---- Attacker player ----  " + "\n" +
                        "Player Name: " + attacker.getName() + "\n" +
                        "Character Name:" + attacker.getGameCharacter().getName() + "\n" +
                        "Character Strategy:" + attacker.getGameCharacter().getPower().getName() + "\n" +
                        "Character Damage" + attacker.getGameCharacter().getPower().getDamage() + "\n" +
                        "Character Pokemon: " + attacker.getGameCharacter().getPokemons().toString());
                Player defender = (attacker.equals(game.getPlayer1())) ? game.getPlayer2() : game.getPlayer1();
                System.out.println("\n---- Defender player ----  " + "\n" +
                        "Player Name: " + defender.getName() + "\n" +
                        "Character Name:" + defender.getGameCharacter().getName() + "\n" +
                        "Character Strategy:" + defender.getGameCharacter().getPower().getName() + "\n" +
                        "Character Damage" + defender.getGameCharacter().getPower().getDamage() + "\n" +
                        "Character Pokemon: " + (defender.getGameCharacter().getPokemons().toString()) + "\n");
                do {
                    playerService.attackToPlayer(attacker, defender);
                    if (isGameOver(attacker, defender)) {
                        gameOver = true;
                    }
                    Player tempPlayer = attacker;
                    attacker = defender;
                    defender = tempPlayer;
                    System.out.println(attacker);
                    System.out.println(defender);
                } while (!gameOver);
                System.out.println("NEXT LEVEL");
                playerService.updatePlayer(game);
                levelCount--;
            }

        } else {
            System.out.println("No player match found.");
        }
    }

    /**
     * Checks if the game is over by checking the status of both players.
     *
     * @param attacker The attacking player
     * @param defender The defending player
     * @return True if either the attacker or defender has lost the game, otherwise false
     */
    private boolean isGameOver(Player attacker, Player defender) {
        boolean attackerLoser = playerService.isPlayerLost(attacker);
        boolean defenderLoser = playerService.isPlayerLost(defender);
        return attackerLoser || defenderLoser;
    }

    /**
     * Checks if the game should start or not by comparing the choices of two players.
     *
     * @return True if the game should start, otherwise false
     */
    private boolean isGameStart() {
        printStartMenu();
        String inputPlayer1 = scanner.next().trim();
        printStartMenu();
        String inputPlayer2 = scanner.next().trim();
        return inputPlayer1.equals(inputPlayer2);
    }

    /**
     * Loads characters and Pokemon for the game from the external data source.
     */
    private void loadGame() {
        System.out.println("\n------------- Loading -------------");
        game.setGameCharacters(loadService.loadCharacters());
        game.setGamePokemons(loadService.loadPokemons());
    }

    /**
     * Lists all characters available in the game and prints them to the console.
     */
    private void listCharactersInGame() {
        System.out.print("\n ****** CHARACTERS ******");
        for (GameCharacter character : game.getGameCharacters()) {
            System.out.println(character);
        }
    }

    /**
     * Lists all Pokemon available in the game and prints them to the console.
     */
    private void listPokemonsInGame() {
        System.out.println(" ****** POKEMONS ******");
        for (Pokemon pokemon : game.getGamePokemons()) {
            System.out.println(pokemon);
        }
    }

    /**
     * Prints the start menu of the game to the console.
     */
    private void printStartMenu() {
        System.out.print("""
                *********** THE POKEMON GAME ***********
                Are you ready to fight ?
                1 - Start Game
                2 - Exit
                Enter your choice(1/2):""");
    }

}
package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.service;

import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.*;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * The PlayerService class is responsible for handling player-related actions and interactions in the game.
 * It provides methods for creating players, selecting characters and Pokemon, managing attacks, and updating player status.
 */
public class PlayerService {
    private final Scanner scanner;
    private final GameCharacterService characterService;
    private final PokemonService pokemonService;

    /**
     * Constructor to initialize PlayerService with a Scanner and related services.
     */
    public PlayerService() {
        scanner = new Scanner(System.in);
        characterService = new GameCharacterService();
        pokemonService = new PokemonService();
    }

    /**
     * Perform an attack by the attacker player on the defender player.
     * This method handles choosing the attacking Pokemon, executing the strategy power, and calculating damage.
     *
     * @param attacker The attacking player
     * @param defender The defending player
     */
    public void attackToPlayer(Player attacker, Player defender) {
        List<Pokemon> pokemons = attacker.getGameCharacter().getPokemons();
        Pokemon attackerPokemon;
        int playerPokemonCount = pokemons.size();
        int pokemonId = 0;
        int pokemonDamageWithWeather = 0;
        if (playerPokemonCount == 1) {
            attackerPokemon = pokemons.get(0);
            pokemonDamageWithWeather = pokemonService.getPokemonDamageWithWeather(attackerPokemon);
        } else {
            System.out.println("** Your Pokemons **");
            pokemonService.listPokemons(attacker);
            System.out.print("Which pokemon would you like to attack with?" + "\n" +
                    "Enter the pokemon id: ");
            pokemonId = scanner.nextInt();
            attackerPokemon = pokemonService.getPlayerPokemonById(attacker, pokemonId);
            if (attackerPokemon != null) {
                pokemonDamageWithWeather = pokemonService.getPokemonDamageWithWeather(attackerPokemon);
            }
        }
        System.out.println("Attacker Pokemon: " + attackerPokemon);
        System.out.println("Attacker pokemon damage in that weather: " + pokemonDamageWithWeather);
        int attackerCharacterDamage = executeStrategyPowerAndGetPlayerDamage(defender);
        int attackerPokemonDamage = executeSuperPowerAndGetPlayerDamage(attacker, pokemonId, pokemonDamageWithWeather);
        int totalAttackerDamage = attackerCharacterDamage + attackerPokemonDamage;
        System.out.println("Attacker pokemon dealt a total of " + totalAttackerDamage + " damage.");
        System.out.print("** Your Pokemons **");
        pokemonService.listPokemons(defender);
        System.out.print("""
                !!! HEY DEFENDER PLAYER !!
                Which pokemon would you like to defend?
                Enter the pokemon id:""");
        pokemonId = scanner.nextInt();
        Pokemon defenderPokemon = pokemonService.getPlayerPokemonById(defender, pokemonId);
        System.out.println("Defender Pokemon: " + "\n" + defenderPokemon);
        int defenderPokemonHealth = defenderPokemon.getHealth() - totalAttackerDamage;
        System.out.println("Defender Pokemon Health: " + defenderPokemonHealth);
        defenderPokemon.setHealth(defenderPokemonHealth);
    }

    /**
     * Create a new player with the given ID and name.
     *
     * @param id The ID of the player
     * @return The created Player object
     */

    public Player createPlayer(int id) {
        System.out.print("Enter the name to create player : ");
        String name = scanner.next();
        switch (id) {
            case 1 -> {
                return new Player1(name);
            }
            case 2 -> {
                return new Player2(name);
            }
            default -> {
                System.out.println("Error! Failed to create player");
                return null;
            }
        }
    }

    /**
     * Let the player select a character from the available game characters.
     *
     * @param game   The game instance
     * @param player The player who will select the character
     */
    public void selectCharacter(Game game, Player player) {
        System.out.print("Enter the id of the character you want to select: ");
        int characterId = scanner.nextInt();
        GameCharacter gameCharacter = characterService.getGameCharacterById(game, characterId);
        if (gameCharacter != null) {
            int playerId = player.getId();
            switch (playerId) {
                case 1 -> game.getPlayer1().setGameCharacter(gameCharacter);
                case 2 -> game.getPlayer2().setGameCharacter(gameCharacter);
                default -> System.out.println("An error occurred while selecting a character.");
            }
        } else {
            System.out.println("There is no such character");
        }
    }

    /**
     * Let the player select a Pokemon from the available game Pokémon.
     *
     * @param game   The game instance
     * @param player The player who will select the Pokemon
     */
    public void selectPokemon(Game game, Player player) {
        System.out.print("Enter the id of the pokemon you want to select: ");
        int pokemonId = scanner.nextInt();
        Pokemon pokemon = pokemonService.getGamePokemonById(game, pokemonId);
        if (pokemon != null) {
            int playerId = player.getId();
            switch (playerId) {
                case 1 -> game.getPlayer1().getGameCharacter().getPokemons().add(pokemon);
                case 2 -> game.getPlayer2().getGameCharacter().getPokemons().add(pokemon);
                default -> System.out.println("An error occurred while selecting a pokemon.");
            }
            game.getGamePokemons().remove(pokemon);
        } else {
            System.out.println("There is no such character");
        }
    }

    /**
     * Randomly choose the attacking player for the current round.
     *
     * @param game The game instance
     * @return The player who will be the attacker for this round
     */
    public Player getAttackerPlayer(Game game) {
        int randomNumber = rollDice();
        if (randomNumber == 1) {
            System.out.println("\nPlayer 1 starts the game");
            return game.getPlayer1();
        } else {
            System.out.println("\nPlayer 2 starts the game");
            return game.getPlayer2();
        }
    }

    /**
     * Update player status and Pokemon after a round of battle.
     *
     * @param game The game instance
     */
    public void updatePlayer(Game game) {
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();
        boolean player1Lost = isPlayerLost(player1);
        if (player1Lost) {
            Pokemon player1Pokemon = player1.getGameCharacter().getPokemons().get(0);
            player1.getGameCharacter().getPokemons().remove(player1Pokemon);
            player1Pokemon.setHealth(100);
            player2.getGameCharacter().getPokemons().add(player1Pokemon);
            addNewPokemonToLoserPlayer(game, player1);
        } else {
            Pokemon player2Pokemon = player2.getGameCharacter().getPokemons().get(0);
            player2.getGameCharacter().getPokemons().remove(player2Pokemon);
            player2Pokemon.setHealth(100);
            player1.getGameCharacter().getPokemons().add(player2Pokemon);
            addNewPokemonToLoserPlayer(game, player2);
        }

    }

    /**
     * Execute the strategy power for the player and calculate damage based on the strategy power.
     *
     * @param player The player who will use the strategy power
     * @return The calculated damage based on the strategy power
     */
    public int executeStrategyPowerAndGetPlayerDamage(Player player) {
        System.out.println("""
                \n!! HEY ATTACKER PLAYER !!
                Do you want to use the character's strategy power ?
                1 - Use strategy power
                2 - Not use strategy power.
                Enter your choice (1/2) :
                """);
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Character Strategy Power will use.");
            GameCharacter playerCharacter = player.getGameCharacter();
            characterService.updateCharacterDamageWithPower(playerCharacter);
            int damage = player.getGameCharacter().getPower().getDamage();
            int playerPowerRight = playerCharacter.getPower().getRemainRight();
            boolean powerRightZero = characterService.isCharacterPowerRightZero(playerCharacter);
            if (powerRightZero) {
                System.out.println("Your power right is zero. You cannot damage this turn.");
                damage = 0;
            }
            playerCharacter.getPower().setRemainRight(playerPowerRight - 1);
            return damage;
        }
        return 0;
    }

    /**
     * Execute the superpower for the player's Pokemon and calculate damage based on the superpower.
     *
     * @param player                   The player who owns the attacking Pokemon
     * @param pokemonId                The ID of the attacking Pokemon
     * @param pokemonDamageWithWeather The Pokemon damage considering the weather condition
     * @return The calculated damage based on the superpower of the Pokemon
     */
    public int executeSuperPowerAndGetPlayerDamage(Player player, int pokemonId, int pokemonDamageWithWeather) {
        List<Pokemon> pokemons = player.getGameCharacter().getPokemons();
        int playerPokemonCount = pokemons.size();
        int damage = 0;
        if (playerPokemonCount == 1) {
            Pokemon pokemon = pokemons.get(0);
            damage = pokemonService.getPokemonDamageWithSuperPower(pokemon, pokemonDamageWithWeather);
        } else {
            pokemonService.listPokemons(player);
            Pokemon pokemon = pokemonService.getPlayerPokemonById(player, pokemonId);
            if (pokemon != null) {
                System.out.println(pokemon.getName() + " is fighting");
                damage = pokemonService.getPokemonDamageWithSuperPower(pokemon, pokemonDamageWithWeather);
            }
        }
        return damage;
    }

    /**
     * Add a new Pokemon to the loser player after losing a round.
     *
     * @param game   The game instance
     * @param player The player who lost the round
     */
    private void addNewPokemonToLoserPlayer(Game game, Player player) {
        List<Pokemon> gamePokemons = game.getGamePokemons();
        Pokemon pokemonWithLowestDamage = gamePokemons.get(0);
        int minDamage = 10;
        for (Pokemon pokemon : gamePokemons) {
            if (pokemon.getDamage() < minDamage) {
                minDamage = pokemon.getDamage();
                pokemonWithLowestDamage = pokemon;
            }
        }
        player.getGameCharacter().getPokemons().add(pokemonWithLowestDamage);
        game.getGamePokemons().remove(pokemonWithLowestDamage);
    }

    /**
     * Check if the player has lost the game by checking if any of their Pokemon's health is zero.
     *
     * @param player The player to check
     * @return True if the player has lost, otherwise false
     */
    public boolean isPlayerLost(Player player) {
        return isPlayerHealthZero(player);
    }

    private boolean isPlayerHealthZero(Player player) {
        List<Pokemon> pokemons = player.getGameCharacter().getPokemons();
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getHealth() <= 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Roll a dice to randomly determine the attacking player.
     *
     * @return 1 for player1 (attacker), 2 for player2 (attacker)
     */
    private int rollDice() {
        Random random = new Random();
        return random.nextInt(2);
    }
}

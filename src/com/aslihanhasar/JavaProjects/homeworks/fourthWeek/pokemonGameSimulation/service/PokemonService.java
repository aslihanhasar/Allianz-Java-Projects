package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.service;

import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.*;

import java.util.List;
import java.util.Scanner;

/**
 * The PokemonService class is responsible for handling Pokemon-related actions and interactions in the game.
 * It provides methods for calculating damage based on superpowers and weather conditions, listing Pokémon,
 * and retrieving Pokémon by ID for players and the game.
 */
public class PokemonService {
    private final Scanner scanner;

    /**
     * Constructor to initialize PokemonService with a Scanner.
     */
    public PokemonService() {
        scanner = new Scanner(System.in);
    }

    /**
     * Calculate the damage dealt by a Pokemon with its superpower.
     * The player can choose whether to use the superpower or not.
     *
     * @param pokemon                  The attacking Pokemon
     * @param pokemonDamageWithWeather The Pokemon's base damage considering the weather condition
     * @return The calculated damage based on the superpower of the Pokemon
     */
    public int getPokemonDamageWithSuperPower(Pokemon pokemon, int pokemonDamageWithWeather) {
        int damage = pokemonDamageWithWeather;
        System.out.print("""
                \n!! HEY ATTACKER PLAYER!!
                Do you want to use the pokemon's super power ?
                1 - Use super power
                2 - Not use super power.
                Enter your choice (1/2) :
                """);
        int choice = scanner.nextInt();
        if (choice == 1) {
            boolean powerRightZero = isPokemonPowerRightZero(pokemon);
            if (powerRightZero) {
                damage = 0;
            }
            damage += pokemon.getPower().getDamage();
            int pokemonPowerRight = pokemon.getPower().getRemainRight();
            pokemon.getPower().setRemainRight(pokemonPowerRight - 1);
        }
        return damage;
    }

    /**
     * Calculate the damage dealt by a Pokemon considering the weather condition.
     *
     * @param pokemon The attacking Pokemon
     * @return The calculated damage based on the weather and Pokemon's type
     */
    public int getPokemonDamageWithWeather(Pokemon pokemon) {
        String powerName = pokemon.getPower().getName();
        WeatherType weatherType = WeatherType.getRandomizeWeatherType();
        int weatherImpact = weatherType.getWeatherImpact();
        int pokemonDamage = pokemon.getDamage();
        boolean changeDamage = false;
        switch (weatherType) {
            case SUNNY -> {
                System.out.println("WEATHER IS SUNNY.");
                if (powerName.equalsIgnoreCase(SuperPowerEnum.WATER.name())) {
                    changeDamage = true;
                }
            }
            case RAINY -> {
                System.out.println("WEATHER IS RAINY.");
                if (powerName.equalsIgnoreCase(SuperPowerEnum.FIRE.name())) {
                    changeDamage = true;
                }
            }
            case SAND_STORM -> {
                System.out.println("WEATHER IS SAND STORM.");
                if (powerName.equalsIgnoreCase(SuperPowerEnum.EARTH.name())) {
                    changeDamage = true;
                }
            }
            case ELECTRIC_STORM -> {
                System.out.println("WEATHER IS ELECTRICITY STORM.");
                if (powerName.equalsIgnoreCase(SuperPowerEnum.ELECTRICITY.name())) {
                    changeDamage = true;
                }
            }
            default -> System.out.println("WEATHER IS NORMAL.");
        }
        if (changeDamage) {
            pokemonDamage -= weatherImpact;
        }
        return pokemonDamage;
    }

    /**
     * List all the Pokémon of a specific player's game character.
     *
     * @param player The player whose Pokémon will be listed
     */
    public void listPokemons(Player player) {
        List<Pokemon> pokemons = player.getGameCharacter().getPokemons();
        for (Pokemon pokemon : pokemons) {
            System.out.println(pokemon);
        }
    }

    /**
     * Get a Pokemon from a specific player's game character by its ID.
     *
     * @param player    The player whose game character contains the Pokemon
     * @param pokemonId The ID of the desired Pokemon
     * @return The Pokemon with the specified ID, or null if not found
     */
    public Pokemon getPlayerPokemonById(Player player, int pokemonId) {
        List<Pokemon> pokemons = player.getGameCharacter().getPokemons();
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getId() == pokemonId) {
                return pokemon;
            }
        }
        return null;
    }

    /**
     * Get a Pokemon from the game's available Pokemon by its ID.
     *
     * @param game The game instance
     * @param id   The ID of the desired Pokemon
     * @return The Pokemon with the specified ID, or null if not found
     */
    public Pokemon getGamePokemonById(Game game, int id) {
        List<Pokemon> gamePokemons = game.getGamePokemons();
        for (Pokemon pokemon : gamePokemons) {
            if (pokemon.getId() == id) {
                return pokemon;
            }
        }
        return null;
    }

    /**
     * Check if the Pokemon's superpower right is zero.
     *
     * @param pokemon The Pokemon to check
     * @return True if the Pokemon's superpower right is zero, otherwise false
     */
    private boolean isPokemonPowerRightZero(Pokemon pokemon) {
        return pokemon.getPower().getRemainRight() <= 0;
    }

}

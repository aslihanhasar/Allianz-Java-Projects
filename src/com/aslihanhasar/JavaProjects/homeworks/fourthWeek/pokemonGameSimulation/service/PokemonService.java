package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.service;

import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.Game;
import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.*;


import java.util.List;
import java.util.Scanner;

public class PokemonService {
    private final Scanner scanner;

    public PokemonService() {
        scanner = new Scanner(System.in);
    }

    public int getPokemonDamageWithSuperPower(Pokemon pokemon,int pokemonDamageWithWeather) {
        int damage=pokemonDamageWithWeather;
        System.out.println("""
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

    public int getPokemonDamageWithWeather(Pokemon pokemon) {
        String powerName = pokemon.getPower().getName();
        WeatherType weatherType = WeatherType.getRandomizeWeatherType();
        int weatherImpact = weatherType.getWeatherImpact();
        int pokemonDamage = pokemon.getDamage();
        boolean changeDamage = false;
        switch (weatherType) {
            case SUNNY -> {
                if (powerName.equalsIgnoreCase(SuperPowerEnum.WATER.name())) {
                    System.out.println("WEATHER IS SUNNY.");
                    changeDamage = true;
                }
            }
            case RAINY -> {
                if (powerName.equalsIgnoreCase(SuperPowerEnum.FIRE.name())) {
                    System.out.println("WEATHER IS RAINY.");
                    changeDamage = true;
                }
            }
            case SAND_STORM -> {
                if (powerName.equalsIgnoreCase(SuperPowerEnum.EARTH.name())) {
                    System.out.println("WEATHER IS SAND STORM.");
                    changeDamage = true;
                }
            }
            case ELECTRIC_STORM -> {
                if (powerName.equalsIgnoreCase(SuperPowerEnum.ELECTRICITY.name())) {
                    System.out.println("WEATHER IS ELECTRICITY STORM.");
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

    public void listPokemons(Player player) {
        List<Pokemon> pokemons = player.getGameCharacter().getPokemons();
        for (Pokemon pokemon : pokemons) {
            System.out.println(pokemon);
        }
    }

    public Pokemon getPlayerPokemonById(Player player, int pokemonId) {
        List<Pokemon> pokemons = player.getGameCharacter().getPokemons();
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getId() == pokemonId) {
                return pokemon;
            }
        }
        return null;
    }

    public Pokemon getGamePokemonById(Game game, int id) {
        List<Pokemon> gamePokemons = game.getGamePokemons();
        for (Pokemon pokemon : gamePokemons) {
            if (pokemon.getId() == id) {
                return pokemon;
            }
        }
        return null;
    }

    private boolean isPokemonPowerRightZero(Pokemon pokemon) {
        return pokemon.getPower().getRemainRight() <= 0;
    }

}

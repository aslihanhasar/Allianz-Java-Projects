package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.service;

import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.*;


import java.util.List;
import java.util.Scanner;

public class PokemonService {
    private final Scanner scanner;

    public PokemonService() {
        scanner = new Scanner(System.in);
    }

    public int getPokemonDamageWithSuperPower(Pokemon pokemon) {
        int damage = pokemon.getDamage();
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
        }
        return damage;
    }
    public void updatePokemonDamageWithWeather(Pokemon pokemon) {
        String powerName=pokemon.getPower().getPowerType().getStrategyPowerEnum().name();
        WeatherType weatherType=WeatherType.getRandomizeWeatherType();
        int weatherImpact=weatherType.getWeatherImpact();
        int pokemonNormalDamage=pokemon.getDamage();
        int pokemonPowerDamage=pokemon.getPower().getDamage();
        boolean changeDamage=false;
        switch (weatherType) {
            case SUNNY ->{
                if(powerName.equalsIgnoreCase(SuperPowerEnum.WATER.name())){
                    changeDamage=true;
                }
            }
            case RAINY -> {
                if(powerName.equalsIgnoreCase(SuperPowerEnum.FIRE.name())){
                    changeDamage=true;
                }
            }
            case SAND_STORM -> {
                if(powerName.equalsIgnoreCase(SuperPowerEnum.EARTH.name())){
                    changeDamage=true;
                }
            }
            case ELECTRIC_STORM -> {
                if(powerName.equalsIgnoreCase(SuperPowerEnum.ELECTRICITY.name())){
                    changeDamage=true;
                }
            }
        }
        if(changeDamage){
            pokemonNormalDamage-=weatherImpact;
            pokemonPowerDamage-=weatherImpact;
            pokemon.setDamage(pokemonNormalDamage);
            pokemon.getPower().setDamage(pokemonPowerDamage);
        }
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

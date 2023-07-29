package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.service;


import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The LoadService class is responsible for loading the initial game characters and Pokemon.
 * It provides methods to create and load predefined game characters and Pokemon.
 */
public class LoadService {

    /**
     * Loads the initial game characters with their respective powers.
     *
     * @return A list of game characters loaded with their powers
     */
    public List<GameCharacter> loadCharacters() {
        Power strategyDefensive = new StrategyPower("Defensive",
                2, 1, new PowerType(StrategyPowerEnum.DEFENSIVE));
        Power strategyOffensive = new StrategyPower("Offensive",
                6, 1, new PowerType(StrategyPowerEnum.OFFENSIVE));
        Power strategyBalanced = new StrategyPower("Balanced",
                5, 1, new PowerType(StrategyPowerEnum.BALANCED));
        Power strategyAggressive = new StrategyPower("Aggressive",
                8, 1, new PowerType(StrategyPowerEnum.AGGRESSIVE));

        GameCharacter characterMisty = new Misty(strategyDefensive);
        GameCharacter characterAsh = new Ash(strategyOffensive);
        GameCharacter characterBrock = new Brock(strategyBalanced);
        GameCharacter characterJessie = new Jessie(strategyAggressive);

        List<GameCharacter> gameCharacters = new ArrayList<>();
        gameCharacters.add(characterMisty);
        gameCharacters.add(characterAsh);
        gameCharacters.add(characterBrock);
        gameCharacters.add(characterJessie);
        return gameCharacters;
    }

    /**
     * Loads the initial Pokemon with their respective powers.
     *
     * @return A list of Pokemon loaded with their powers
     */
    public List<Pokemon> loadPokemons() {
        Power waterPower = new SuperPower("Water",
                2, 3, new PowerType(SuperPowerEnum.WATER));
        Power firePower = new SuperPower("Fire",
                5, 3, new PowerType(SuperPowerEnum.FIRE));
        Power electricityPower = new SuperPower("Electricity",
                4, 3, new PowerType(SuperPowerEnum.ELECTRICITY));
        Power earthPower = new SuperPower("Earth",
                3, 3, new PowerType(SuperPowerEnum.EARTH));
        Power talkPower = new SuperPower("Talk",
                3, 3, new PowerType(SuperPowerEnum.TALK));

        Pokemon squirtle = new Squirtle(waterPower);
        Pokemon charmander = new Charmander(firePower);
        Pokemon pikachu = new Pikachu(electricityPower);
        Pokemon bulbasaur = new Bulbasaur(earthPower);
        Pokemon meowth = new Meowth(talkPower);

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(squirtle);
        pokemons.add(charmander);
        pokemons.add(pikachu);
        pokemons.add(bulbasaur);
        pokemons.add(meowth);
        return pokemons;
    }
}

package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.service;

import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.*;

import java.util.ArrayList;
import java.util.List;

public class LoadService {

    public List<GameCharacter> loadCharacters() {
        Power strategyDefensive = new StrategyPower("Defensive Strategy",
                2, 1, new PowerType(StrategyPowerEnum.DEFENSIVE));
        Power strategyOffensive = new StrategyPower("Offensive Strategy",
                6, 1, new PowerType(StrategyPowerEnum.OFFENSIVE));
        Power strategyBalanced = new StrategyPower("Balanced Strategy",
                5, 1, new PowerType(StrategyPowerEnum.BALANCED));
        Power strategyAggressive = new StrategyPower("Aggressive Strategy",
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

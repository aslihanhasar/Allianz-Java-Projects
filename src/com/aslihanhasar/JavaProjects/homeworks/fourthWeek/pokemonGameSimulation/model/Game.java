package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model;

import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.GameCharacter;
import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.Player;
import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Player player1;
    private final Player player2;
    private List<GameCharacter> gameCharacters;
    private List<Pokemon> gamePokemons;

    public Game(Player player1,Player player2){
        this.player1=player1;
        this.player2=player2;
        gameCharacters=new ArrayList<>();
        gamePokemons=new ArrayList<>();
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public List<GameCharacter> getGameCharacters() {
        return gameCharacters;
    }

    public void setGameCharacters(List<GameCharacter> gameCharacters) {
        this.gameCharacters = gameCharacters;
    }

    public List<Pokemon> getGamePokemons() {
        return gamePokemons;
    }

    public void setGamePokemons(List<Pokemon> gamePokemons) {
        this.gamePokemons = gamePokemons;
    }
}

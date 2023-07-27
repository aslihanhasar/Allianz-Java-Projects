package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model;

public class Player {
    private String name;
    private GameCharacter gameCharacter;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameCharacter getGameCharacter() {
        return gameCharacter;
    }

    public void setGameCharacter(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", gameCharacter=" + gameCharacter +
                '}';
    }
}

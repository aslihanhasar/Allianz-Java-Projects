package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model;

import java.util.ArrayList;
import java.util.List;

public abstract class GameCharacter {
    private final Long id;
    private final String name;
    private Power power;
    private List<Pokemon> pokemons;

    public GameCharacter(Long id,String name, Power power) {
        this.id=id;
        this.name = name;
        this.power = power;
        this.pokemons=new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {
        return "GameCharacter{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", pokemons=" + pokemons +
                '}';
    }
}

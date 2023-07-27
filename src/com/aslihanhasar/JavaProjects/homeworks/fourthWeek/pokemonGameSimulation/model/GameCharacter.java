package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model;

import java.util.ArrayList;
import java.util.List;

public class GameCharacter {
    private String name;
    private SpecialPower specialPower;
    private List<Pokemon> pokemons;

    public GameCharacter(String name,SpecialPower specialPower){
        this.name=name;
        this.specialPower=specialPower;
        pokemons=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpecialPower getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(SpecialPower specialPower) {
        this.specialPower = specialPower;
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
                ", specialPower=" + specialPower +
                ", pokemons=" + pokemons +
                '}';
    }
}

package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model;

public class Power {
    private String name;
    private int damage;
    private int remainRight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRemainRight() {
        return remainRight;
    }

    public void setRemainRight(int remainRight) {
        this.remainRight = remainRight;
    }

    @Override
    public String toString() {
        return "Power{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", remainRight=" + remainRight +
                '}';
    }
}

package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model;

public abstract class Pokemon {
    private final int id;
    private final String name;
    private int health;
    private int damage;
    private Power power;

    public Pokemon(int id, String name, int health, int damage, Power power) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", power=" + power +
                '}';
    }
}

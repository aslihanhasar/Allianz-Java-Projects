package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model;

public abstract class Power {
    private String name;
    private int damage;
    private int remainRight;
    private PowerType powerType;

    public Power(String name, int damage, int remainRight, PowerType powerType) {
        this.name = name;
        this.damage = damage;
        this.remainRight = remainRight;
        this.powerType = powerType;
    }

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

    public PowerType getPowerType() {
        return powerType;
    }

    public void setPowerType(PowerType powerType) {
        this.powerType = powerType;
    }

    @Override
    public String toString() {
        return "Power{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", remainRight=" + remainRight +
                ", powerType=" + powerType +
                '}';
    }
}

package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model;

public enum StrategyPowerEnum {
    DEFENSIVE(0.8),
    OFFENSIVE(0.4),
    BALANCED(0.5),
    AGGRESSIVE(0.2);

    private double defenseChance;

    StrategyPowerEnum(double defenseChance) {
        this.defenseChance = defenseChance;
    }

    public double getDefenseChance() {
        return defenseChance;
    }

    public void setDefenseChance(double defenseChance) {
        this.defenseChance = defenseChance;
    }

    @Override
    public String toString() {
        return "StrategyPowerEnum{" +
                "defenseChance=" + defenseChance +
                '}';
    }
}

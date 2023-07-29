package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model;

public enum StrategyPowerEnum {
    DEFENSIVE(80),
    OFFENSIVE(40),
    BALANCED(50),
    AGGRESSIVE(20);

    private int defenseChance;

    StrategyPowerEnum(int defenseChance) {
        this.defenseChance = defenseChance;
    }

    public int getDefenseChance() {
        return defenseChance;
    }

    public void setDefenseChance(int defenseChance) {
        this.defenseChance = defenseChance;
    }

}

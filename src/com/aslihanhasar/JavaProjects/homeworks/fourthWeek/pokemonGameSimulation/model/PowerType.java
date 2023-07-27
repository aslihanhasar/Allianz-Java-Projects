package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model;

public class PowerType {
    private SuperPowerEnum superPowerEnum;
    private StrategyPowerEnum strategyPowerEnum;

    public PowerType(SuperPowerEnum superPowerEnum) {
        this.superPowerEnum = superPowerEnum;
    }

    public PowerType(StrategyPowerEnum strategyPowerEnum) {
        this.strategyPowerEnum = strategyPowerEnum;
    }

    public SuperPowerEnum getSuperPowerEnum() {
        return superPowerEnum;
    }
    public StrategyPowerEnum getStrategyPowerEnum() {
        return strategyPowerEnum;
    }

}

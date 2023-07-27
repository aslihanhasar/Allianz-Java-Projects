package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model;

public abstract class PowerType {
    private SuperPowerEnum superPowerEnum;
    private StrategyPowerEnum strategyPowerEnum;

    public SuperPowerEnum getSuperPowerEnum() {
        return superPowerEnum;
    }

    public void setSuperPowerEnum(SuperPowerEnum superPowerEnum) {
        this.superPowerEnum = superPowerEnum;
    }

    public StrategyPowerEnum getStrategyPowerEnum() {
        return strategyPowerEnum;
    }

    public void setStrategyPowerEnum(StrategyPowerEnum strategyPowerEnum) {
        this.strategyPowerEnum = strategyPowerEnum;
    }

}

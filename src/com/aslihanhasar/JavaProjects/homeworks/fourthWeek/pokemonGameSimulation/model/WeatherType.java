package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model;

import java.util.EnumSet;
import java.util.Random;

public enum WeatherType {
    NORMAL(0, 1),
    SUNNY(2, 2),
    RAINY(3, 3),
    SAND_STORM(4, 4),
    ELECTRIC_STORM(5, 5);

    private final int weatherImpact;
    private final int randomValue;

    WeatherType(int weatherImpact, int randomValue) {
        this.weatherImpact = weatherImpact;
        this.randomValue = randomValue;
    }

    public int getWeatherImpact() {
        return weatherImpact;
    }

    public int getRandomValue() {
        return randomValue;
    }

    public static WeatherType getRandomizeWeatherType() {
        int randomNumber = getRandomNumber();
        var weatherTypes = EnumSet.allOf(WeatherType.class);
        for (WeatherType weatherType : weatherTypes) {
            if (weatherType.randomValue == randomNumber) {
                return weatherType;
            }
        }
        return NORMAL;
    }

    private static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(5);
    }
}

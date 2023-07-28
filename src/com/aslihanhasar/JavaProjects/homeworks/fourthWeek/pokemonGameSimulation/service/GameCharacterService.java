package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.service;

import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.Game;
import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.*;

import java.util.EnumSet;
import java.util.List;

public class GameCharacterService {

    public GameCharacter getGameCharacterById(Game game, int id) {
        List<GameCharacter> gameCharacters = game.getGameCharacters();
        for (GameCharacter gameCharacter : gameCharacters) {
            if (gameCharacter.getId() == id) {
                return gameCharacter;
            }
        }
        return null;
    }

    public void updateCharacterDamageWithPower(GameCharacter gameCharacter) {
        String powerName = gameCharacter.getPower().getPowerType().getStrategyPowerEnum().name();
        int powerDamage=0;
        var powerTypes = EnumSet.allOf(StrategyPowerEnum.class);
        for (StrategyPowerEnum powerType : powerTypes) {
            if (powerType.name().equalsIgnoreCase(powerName)) {
                int defenseChance = powerType.getDefenseChance();
                boolean blockAttack = isCharacterBlockAttack(defenseChance);
                if (blockAttack) {
                    powerDamage = 0;
                    System.out.println("Character blocked the move with strategy. "+powerDamage);
                }else{
                    System.out.println("Character could not block the move with strategy.");
                    powerDamage = gameCharacter.getPower().getDamage();
                }
            }
            gameCharacter.getPower().setDamage(powerDamage);
        }
    }

    public boolean isCharacterPowerRightZero(GameCharacter gameCharacter) {
        return gameCharacter.getPower().getRemainRight() <= 0;
    }

    public void listCharacters(List<GameCharacter> gameCharacters) {
        for (GameCharacter gameCharacter : gameCharacters) {
            System.out.println(gameCharacter);
        }
    }

    private boolean isCharacterBlockAttack(int defenseChance) {
        int randomValue = (int) (Math.random() * 100);
        return randomValue <= defenseChance;
    }

}

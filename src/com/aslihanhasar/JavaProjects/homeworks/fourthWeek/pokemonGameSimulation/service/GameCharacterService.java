package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.service;


import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.*;

import java.util.EnumSet;
import java.util.List;

/**
 * The GameCharacterService class is a service class used to manage game characters.
 * This class provides methods for updating character damage based on their powers,
 * checking defense capabilities, listing characters, and other character-related operations.
 */
public class GameCharacterService {
    /**
     * Returns the game character with the specified ID from the given game.
     *
     * @param game The game object
     * @param id   The ID of the game character
     * @return The game character object or null if no character is found with the given ID
     */
    public GameCharacter getGameCharacterById(Game game, int id) {
        List<GameCharacter> gameCharacters = game.getGameCharacters();
        for (GameCharacter gameCharacter : gameCharacters) {
            if (gameCharacter.getId() == id) {
                return gameCharacter;
            }
        }
        return null;
    }

    /**
     * Updates the character damage based on their power.
     * Determines the attack damage according to the character's power and
     * checks if the character can block the attack based on their defense chance.
     * If the attack is blocked, the damage is set to 0; otherwise, the actual
     * damage is applied to the character.
     *
     * @param gameCharacter The game character object
     */
    public void updateCharacterDamageWithPower(GameCharacter gameCharacter) {
        String powerName = gameCharacter.getPower().getName();
        int powerDamage = 0;
        var powerTypes = EnumSet.allOf(StrategyPowerEnum.class);
        for (StrategyPowerEnum powerType : powerTypes) {
            if (powerType.name().equalsIgnoreCase(powerName)) {
                int defenseChance = powerType.getDefenseChance();
                boolean blockAttack = isCharacterBlockAttack(defenseChance);
                if (blockAttack) {
                    powerDamage = 0;
                    System.out.println("Character blocked the move with strategy. " + "\n" +
                            "Damage to be applied in this round: " + powerDamage);
                } else {
                    powerDamage = gameCharacter.getPower().getDamage();
                    System.out.println("Character could not block the move with strategy." +
                            "Damage to be applied in this round: " + powerDamage);
                }
            }
            gameCharacter.getPower().setDamage(powerDamage);
        }
    }

    /**
     * Checks if the character's power has zero or fewer remaining rights.
     *
     * @param gameCharacter The game character object
     * @return True if the remaining power rights are zero or less, otherwise false
     */
    public boolean isCharacterPowerRightZero(GameCharacter gameCharacter) {
        return gameCharacter.getPower().getRemainRight() <= 0;
    }

    /**
     * Lists the provided game characters and prints them to the console.
     *
     * @param gameCharacters The list of game characters
     */
    public void listCharacters(List<GameCharacter> gameCharacters) {
        for (GameCharacter gameCharacter : gameCharacters) {
            System.out.println(gameCharacter);
        }
    }

    /**
     * Checks if the character can block the attack based on their defense chance.
     * If the random value is less than or equal to the defense chance, the attack is blocked and returns true.
     * Otherwise, the attack is not blocked and returns false.
     *
     * @param defenseChance The defense chance of the character (a value between 0 and 100)
     * @return True if the attack is blocked, otherwise false
     */
    private boolean isCharacterBlockAttack(int defenseChance) {
        int randomValue = (int) (Math.random() * 100);
        return randomValue <= defenseChance;
    }

}

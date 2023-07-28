package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.service;

import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.*;

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
    public boolean isCharacterPowerRightZero(GameCharacter gameCharacter) {
        return gameCharacter.getPower().getRemainRight() <= 0;
    }

    public void listCharacters(List<GameCharacter> gameCharacters) {
        for (GameCharacter gameCharacter : gameCharacters) {
            System.out.println(gameCharacter);
        }
    }

}

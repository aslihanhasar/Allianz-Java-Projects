package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.service;

import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerService {
    private final Scanner scanner;
    private final GameCharacterService characterService;
    private final PokemonService pokemonService;

    public PlayerService() {
        scanner = new Scanner(System.in);
        characterService=new GameCharacterService();
        pokemonService=new PokemonService();
    }

    public Player createPlayer(int id) {
        System.out.println("Create player. Enter the name: ");
        String name = scanner.next();
        switch (id) {
            case 1 -> {
                return new Player1(name);
            }
            case 2 -> {
                return new Player2(name);
            }
            default -> {
                System.out.println("Error! Failed to create player");
                return null;
            }
        }
    }

    public void selectCharacter(Game game, Player player) {
        System.out.print("Enter the id of the character you want to select: ");
        int characterId = scanner.nextInt();
        GameCharacter gameCharacter = getGameCharacterById(game, characterId);
        if (gameCharacter != null) {
            int playerId = player.getId();
            switch (playerId) {
                case 1 -> game.getPlayer1().setGameCharacter(gameCharacter);
                case 2 -> game.getPlayer2().setGameCharacter(gameCharacter);
                default -> System.out.println("An error occurred while selecting a character.");
            }
        } else {
            System.out.println("There is no such character");
        }
    }

    public void selectPokemon(Game game, Player player) {
        System.out.print("Enter the id of the pokemon you want to select: ");
        int pokemonId = scanner.nextInt();
        Pokemon pokemon=getGamePokemonById(game,pokemonId);
        if(pokemon!=null){
            int playerId=player.getId();
            switch (playerId){
                case 1-> game.getPlayer1().getGameCharacter().getPokemons().add(pokemon);
                case 2-> game.getPlayer2().getGameCharacter().getPokemons().add(pokemon);
                default -> System.out.println("An error occurred while selecting a pokemon.");
            }
        }else{
            System.out.println("There is no such character");
        }
    }

    private Pokemon getGamePokemonById(Game game, int id) {
        List<Pokemon> gamePokemons = game.getGamePokemons();
        for (Pokemon pokemon : gamePokemons) {
            if (pokemon.getId() == id) {
                return pokemon;
            }
        }
        return null;
    }

    private GameCharacter getGameCharacterById(Game game, int id) {
        List<GameCharacter> gameCharacters = game.getGameCharacters();
        for (GameCharacter gameCharacter : gameCharacters) {
            if (gameCharacter.getId() == id) {
                return gameCharacter;
            }
        }
        return null;
    }

}

package com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.service;

import com.aslihanhasar.JavaProjects.homeworks.fourthWeek.pokemonGameSimulation.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PlayerService {
    private final Scanner scanner;
    private final GameCharacterService characterService;
    private final PokemonService pokemonService;

    public PlayerService() {
        scanner = new Scanner(System.in);
        characterService = new GameCharacterService();
        pokemonService = new PokemonService();
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
        Pokemon pokemon = getGamePokemonById(game, pokemonId);
        if (pokemon != null) {
            int playerId = player.getId();
            switch (playerId) {
                case 1 -> game.getPlayer1().getGameCharacter().getPokemons().add(pokemon);
                case 2 -> game.getPlayer2().getGameCharacter().getPokemons().add(pokemon);
                default -> System.out.println("An error occurred while selecting a pokemon.");
            }
            game.getGamePokemons().remove(pokemon);
        } else {
            System.out.println("There is no such character");
        }
    }

    public Player getAttackerPlayer(Game game) {
        int randomNumber = rollDice();
        if (randomNumber == 1) {
            System.out.println("Player 1 starts the game");
            return game.getPlayer1();
        } else {
            System.out.println("Player 2 starts the game");
            return game.getPlayer2();
        }
    }

    public void updatePlayer(Game game) {
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();
        boolean player1Lost = isPlayerLost(player1);
        if (player1Lost) {
            Pokemon player1Pokemon = player1.getGameCharacter().getPokemons().get(0);
            player1.getGameCharacter().getPokemons().remove(player1Pokemon);
            player1Pokemon.setHealth(100);
            player2.getGameCharacter().getPokemons().add(player1Pokemon);
            addNewPokemonToLoserPlayer(game,player1);
        } else {
            Pokemon player2Pokemon = player2.getGameCharacter().getPokemons().get(0);
            player2.getGameCharacter().getPokemons().remove(player2Pokemon);
            player2Pokemon.setHealth(100);
            player1.getGameCharacter().getPokemons().add(player2Pokemon);
            addNewPokemonToLoserPlayer(game,player2);
        }
    }

     private void addNewPokemonToLoserPlayer(Game game, Player player) {
        List<Pokemon> gamePokemons = game.getGamePokemons();
        Pokemon pokemonWithLowestDamage=gamePokemons.get(0);
        int minDamage = 10;
        for (Pokemon pokemon : gamePokemons) {
            if (pokemon.getDamage() < minDamage) {
                minDamage = pokemon.getDamage();
                pokemonWithLowestDamage = pokemon;
            }
        }
        player.getGameCharacter().getPokemons().add(pokemonWithLowestDamage);
        game.getGamePokemons().remove(pokemonWithLowestDamage);
    }
    public boolean isPlayerLost(Player player) {
        return isPlayerHealthZero(player);
    }

    private boolean isPlayerHealthZero(Player player) {
        List<Pokemon> pokemons = player.getGameCharacter().getPokemons();
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getHealth() <= 0) {
                return true;
            }
        }
        return false;
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

    private int rollDice() {
        Random random = new Random();
        return random.nextInt(2);
    }
}

package com.aslihanhasar.JavaProjects.practices.secondWeek.playerSimulation.service;

import com.aslihanhasar.JavaProjects.practices.secondWeek.playerSimulation.model.Player;
import com.aslihanhasar.JavaProjects.practices.secondWeek.playerSimulation.model.Team;
import com.aslihanhasar.JavaProjects.practices.secondWeek.playerSimulation.model.Transfer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PlayerService {

    public Player createPlayer(String name, String surname, int kitNumber, int birthYear,
                               String position, BigDecimal value) {

        Player player = new Player();
        player.setName(name);
        player.setSurname(surname);
        player.setKitNumber(kitNumber);
        player.setBirthYear(birthYear);
        player.setPosition(position);
        player.setValue(value);

        return player;
    }

    public void addTeamToPlayer(Player player, Team team) {
        if (player.getTeamList() != null) {
            player.getTeamList().add(team);
        } else {
            List<Team> teamList = new ArrayList<>();
            teamList.add(team);
            player.setTeamList(teamList);
        }
    }

    public void getPlayerTransferHistory(Player player,Transfer transfer) {
        if (player.getTransferHistory()!= null) {
            player.getTransferHistory().add(transfer);
        }else{
            List<Transfer> playerTransferHistory=new ArrayList<>();
            playerTransferHistory.add(transfer);
            player.setTransferHistory(playerTransferHistory);
        }
    }
}



package com.aslihanhsr.JavaProjects.secondWeek.playerSimulation.service;

import com.aslihanhsr.JavaProjects.secondWeek.playerSimulation.model.Player;
import com.aslihanhsr.JavaProjects.secondWeek.playerSimulation.model.Team;

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

    public void addTeamToPlayer(Player player, Team team){
        if(player.getTeamList()!=null){
            player.getTeamList().add(team);
        }else{
            List<Team> teamList=new ArrayList<>();
            teamList.add(team);
            player.setTeamList(teamList);
        }
    }
}

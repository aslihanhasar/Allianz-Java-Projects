package com.aslihanhsr.JavaProjects.secondWeek.playerSimulation.service;

import com.aslihanhsr.JavaProjects.secondWeek.playerSimulation.model.*;

public class TransferService {
    public void makeTransfer(Player player, Team toTeam){
        if(toTeam.getBudget().compareTo(player.getValue())>=0){
            System.out.println("transfer can be done");
            toTeam.setBudget(toTeam.getBudget().subtract(player.getValue()));
            Team fromTeam=player.getTeamList().get(player.getTeamList().size()-1);
            fromTeam.setBudget(fromTeam.getBudget().add(player.getValue()));
            player.getTeamList().add(toTeam);
        }else{
            System.err.println("transfer can not be done because of not enough budget");
        }
    }
}

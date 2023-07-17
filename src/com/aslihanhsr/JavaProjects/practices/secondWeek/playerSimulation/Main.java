package com.aslihanhsr.JavaProjects.practices.secondWeek.playerSimulation;

import com.aslihanhsr.JavaProjects.practices.secondWeek.playerSimulation.model.*;
import com.aslihanhsr.JavaProjects.practices.secondWeek.playerSimulation.service.PlayerService;
import com.aslihanhsr.JavaProjects.practices.secondWeek.playerSimulation.service.TeamService;
import com.aslihanhsr.JavaProjects.practices.secondWeek.playerSimulation.service.TransferService;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        TeamService teamService = new TeamService();
        PlayerService playerService = new PlayerService();
        TransferService transferService = new TransferService();

        Currency currencyUSD = new Currency("USD");
        Currency currencyEUR = new Currency("EUR");
        // Currency currencyTRY=new Currency("TRY");

        Team team = teamService.createTeam("Galatasaray", "GS", "yellow-red",
                "Okan Buruk", "Dursun Özbek", "Nef Arena", new BigDecimal(10000000),
                currencyUSD, "Türkiye");

        System.out.println(team.toString());
        teamService.addAwardToTeam(team, "Champions Cup", 2023,
                AwardTypeEnum.CUP, AwardCategoryEnum.INTERNATIONAL);

        System.out.println(team.toString());

        Team team2 = teamService.createTeam("Fenerbahçe", "FB", "yellow-blue",
                "İsmail Kartal", "Ali Koç", "Kadıköy", new BigDecimal(55000000),
                currencyEUR, "Türkiye");


        teamService.addAwardToTeam(team2, "Turkish Cup", 2023,
                AwardTypeEnum.CUP, AwardCategoryEnum.NATIONAL);

        teamService.addAwardToTeam(team, "League Cup", 2023,
                AwardTypeEnum.CUP, AwardCategoryEnum.NATIONAL);

        System.out.println(team.toString());

        Player player = playerService.createPlayer("Cristiano", "Ronaldo",
                7, 1985, "Forvet", new BigDecimal(35000000));

        playerService.addTeamToPlayer(player, team);
        System.out.println(player.toString());
        transferService.makeTransfer(player, team2);
        System.out.println(team);
        System.out.println(team2);
        System.out.println(player);

    }
}

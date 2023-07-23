package com.aslihanhasar.JavaProjects.practices.secondWeek.playerSimulation.service;

import com.aslihanhasar.JavaProjects.practices.secondWeek.playerSimulation.model.Player;
import com.aslihanhasar.JavaProjects.practices.secondWeek.playerSimulation.model.Team;
import com.aslihanhasar.JavaProjects.practices.secondWeek.playerSimulation.model.Currency;

import java.math.BigDecimal;

public class TransferService {
    CurrencyService currencyService=new CurrencyService();
    public void makeTransfer(Player player, Team toTeam){
        Team fromTeam = player.getTeamList().get(player.getTeamList().size() - 1);
        Currency currencyFromTeam=fromTeam.getCurrency();
        Currency currencyToTeam=toTeam.getCurrency();
        Currency currencyPlayer=player.getCurrency();
        BigDecimal budgetFromTeam=currencyService.makeConversionCurrency(fromTeam.getBudget(),
                currencyFromTeam,currencyPlayer);
        BigDecimal budgetToTeam=currencyService.makeConversionCurrency(toTeam.getBudget(),
                currencyToTeam, currencyPlayer);

        int compareResult=toTeam.getBudget().compareTo(player.getValue());
        if(compareResult>=0){
            System.out.println("Transfer can be done");
            budgetFromTeam=fromTeam.getBudget().add(player.getValue());
            budgetToTeam=toTeam.getBudget().subtract(player.getValue());

            BigDecimal originalCurrencyFromTeam=currencyService.makeConversionCurrency(budgetFromTeam,
                    currencyPlayer,currencyFromTeam);
            BigDecimal originalCurrencyToTeam=currencyService.makeConversionCurrency(budgetToTeam,
                    currencyPlayer,currencyToTeam);
            fromTeam.setBudget(originalCurrencyFromTeam);
            toTeam.setBudget(originalCurrencyToTeam);
            player.getTeamList().add(toTeam);

        }else{
            System.err.println("transfer can not be done because of not enough budget");
        }
    }
}

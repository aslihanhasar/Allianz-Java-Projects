package com.aslihanhsr.JavaProjects.secondWeek.playerSimulation.model;

import java.math.BigDecimal;

public class Transfer {
    private Team fromTeam;
    private Team toTeam;
    private int year;
    private BigDecimal price;
    private Currency currency;

    public Team getFromTeam() {
        return fromTeam;
    }

    public void setFromTeam(Team fromTeam) {
        this.fromTeam = fromTeam;
    }

    public Team getToTeam() {
        return toTeam;
    }

    public void setToTeam(Team toTeam) {
        this.toTeam = toTeam;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "fromTeam=" + fromTeam +
                ", toTeam=" + toTeam +
                ", year=" + year +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }
}

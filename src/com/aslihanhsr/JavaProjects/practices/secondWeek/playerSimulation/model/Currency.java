package com.aslihanhsr.JavaProjects.practices.secondWeek.playerSimulation.model;

public class Currency {
    private String currencyName;

    public Currency(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyName='" + currencyName + '\'' +
                '}';
    }
}

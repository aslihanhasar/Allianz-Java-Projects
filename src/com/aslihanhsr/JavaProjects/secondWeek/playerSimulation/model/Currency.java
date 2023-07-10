package com.aslihanhsr.JavaProjects.secondWeek.playerSimulation.model;

public class Currency {
    private String currency;

    public Currency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currency='" + currency + '\'' +
                '}';
    }
}

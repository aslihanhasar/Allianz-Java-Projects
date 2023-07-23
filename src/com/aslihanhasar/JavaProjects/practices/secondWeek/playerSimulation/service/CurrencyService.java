package com.aslihanhasar.JavaProjects.practices.secondWeek.playerSimulation.service;

import com.aslihanhasar.JavaProjects.practices.secondWeek.playerSimulation.model.Currency;

import java.math.BigDecimal;

public class CurrencyService {
    public BigDecimal makeConversionCurrency(BigDecimal amount, Currency fromCurrency, Currency toCurrency) {
        BigDecimal conversionRate = getConversionRate(amount,fromCurrency, toCurrency);
        BigDecimal result=new BigDecimal(0);
        if (conversionRate != null) {
            result= amount.multiply(conversionRate);
        } else {
            System.out.println("Invalid conversion currency");
        }
        return result;
    }

    private BigDecimal getConversionRate(BigDecimal amount,Currency fromCurrency, Currency toCurrency) {
        String fromCurrencyName = fromCurrency.getCurrencyName();
        String toCurrencyName = toCurrency.getCurrencyName();
        switch (fromCurrencyName) {
            case "USD":
                switch (toCurrencyName) {
                    case "TRY":
                        return new BigDecimal("26");
                    case "EUR":
                        return new BigDecimal("0.85");
                    case "USD":
                        return amount;
                }
                break;
            case "TRY":
                switch (toCurrencyName) {
                    case "USD":
                        return new BigDecimal("0.26");
                    case "EUR":
                        return new BigDecimal("0.25");
                    case "TRY":
                        return amount;
                }
                break;
            case "EUR":
                switch (toCurrencyName) {
                    case "USD":
                        return new BigDecimal("1.2");
                    case "TRY":
                        return new BigDecimal("25");
                    case "EUR":
                        return amount;
                }
                break;
        }
        return null;
    }
}

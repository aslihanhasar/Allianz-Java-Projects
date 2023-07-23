package com.aslihanhasar.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Accident {
    private LocalDate accidentDate;
    private String description;
    private BigDecimal damagePrice;
    private int failureRate;

    public LocalDate getAccidentDate() {
        return accidentDate;
    }

    public void setAccidentDate(LocalDate accidentDate) {
        this.accidentDate = accidentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDamagePrice() {
        return damagePrice;
    }

    public void setDamagePrice(BigDecimal damagePrice) {
        this.damagePrice = damagePrice;
    }

    public int getFailureRate() {
        return failureRate;
    }

    public void setFailureRate(int failureRate) {
        this.failureRate = failureRate;
    }

    @Override
    public String toString() {
        return "Accident{" +
                "accidentDate=" + accidentDate +
                ", description='" + description + '\'' +
                ", damagePrice=" + damagePrice +
                ", failureRate=" + failureRate +
                '}';
    }
}

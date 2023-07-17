package com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.service;

import com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model.Accident;

import java.math.BigDecimal;
import java.util.Date;

public class AccidentService {

    /**
     * Creates a new accident with the specified details.
     *
     * @param accidentDate  The date of the accident.
     * @param description   A description of the accident.
     * @param damagePrice   The price of the damages caused by the accident.
     * @param failureRate   The failure rate associated with the accident.
     * @return The created accident.
     */
    public Accident createAccident(Date accidentDate, String description,
                                   BigDecimal damagePrice, int failureRate) {
        Accident accident = new Accident();
        accident.setAccidentDate(accidentDate);
        accident.setDescription(description);
        accident.setDamagePrice(damagePrice);
        accident.setFailureRate(failureRate);
        return accident;
    }
}

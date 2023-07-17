package com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.service;

import com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model.*;

public class InsuranceService {

    /**
     * Creates a new insurance with the specified insurance type and name.
     *
     * @param insuranceType The type of the insurance.
     * @param name          The name of the insurance.
     * @return The created insurance.
     */
    public Insurance createInsurance(InsuranceType insuranceType, String name) {
        Insurance insurance = new Insurance();
        insurance.setInsuranceType(insuranceType);
        insurance.setName(name);
        return insurance;
    }
}

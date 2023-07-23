package com.aslihanhasar.JavaProjects.homeworks.thirdWeek.insuranceSimulation.service;

import com.aslihanhasar.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model.*;

import java.math.BigDecimal;
import java.util.Date;

public class PolicyService {

    /**
     * Creates a new policy with the specified details.
     *
     * @param insuranceCompany The insurance company associated with the policy.
     * @param vehicle          The vehicle covered by the policy.
     * @param price            The price of the policy.
     * @param startDate        The start date of the policy.
     * @param endDate          The end date of the policy.
     * @return The created policy.
     */
    public Policy createPolicy(InsuranceCompany insuranceCompany, Vehicle vehicle,
                               BigDecimal price, Date startDate, Date endDate) {
        Policy policy = new Policy();
        policy.setInsuranceCompany(insuranceCompany);
        policy.setVehicle(vehicle);
        policy.setPrice(price);
        policy.setStartDate(startDate);
        policy.setEndDate(endDate);
        return policy;
    }
}

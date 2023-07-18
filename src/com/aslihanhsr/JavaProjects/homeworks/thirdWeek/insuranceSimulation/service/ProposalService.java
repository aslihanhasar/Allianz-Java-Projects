package com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.service;

import com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProposalService {

    /**
     * Creates a new proposal with the specified details.
     *
     * @param insuranceCompany The insurance company associated with the proposal.
     * @param vehicle          The vehicle covered by the proposal.
     * @param offerPrice       The offered price of the proposal.
     * @param startDate        The start date of the proposal.
     * @param endDate          The end date of the proposal.
     * @param expireDate       The expiration date of the proposal.
     * @param discountPrice    The discount price of the proposal.
     * @return The created proposal.
     */
    public Proposal createProposal(InsuranceCompany insuranceCompany, Vehicle vehicle,
                                   BigDecimal offerPrice, LocalDate startDate, LocalDate endDate,
                                   LocalDate expireDate, BigDecimal discountPrice) {
        Proposal proposal = new Proposal();
        proposal.setCompany(insuranceCompany);
        proposal.setVehicle(vehicle);
        proposal.setOfferPrice(offerPrice);
        proposal.setStartDate(startDate);
        proposal.setEndDate(endDate);
        proposal.setExpireDate(expireDate);
        proposal.setDiscountPrice(discountPrice);
        return proposal;
    }
}

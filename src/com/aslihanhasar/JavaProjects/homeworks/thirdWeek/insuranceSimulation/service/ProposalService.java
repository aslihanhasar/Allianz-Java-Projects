package com.aslihanhasar.JavaProjects.homeworks.thirdWeek.insuranceSimulation.service;

import com.aslihanhasar.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProposalService {
    VehicleService vehicleService = new VehicleService();

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
        BigDecimal calculatedOfferPrice=calculateOfferPriceForProposal(offerPrice,vehicle);
        proposal.setOfferPrice(calculatedOfferPrice);
        return proposal;
    }

    public BigDecimal calculateDiscountedPrice(Proposal proposal) {
        BigDecimal discountPrice = proposal.getDiscountPrice();
        if (discountPrice != null) {
            return proposal.getOfferPrice().subtract(discountPrice);
        }
        return proposal.getOfferPrice();
    }

    public BigDecimal calculateOfferPriceForProposal(BigDecimal offerPrice, Vehicle vehicle) {
        BigDecimal totalOfferPrice;
        BigDecimal totalAccidentPrice = vehicleService.getTotalAccidentPerice(vehicle);
        if (totalAccidentPrice.compareTo(BigDecimal.ZERO) == 0) {
            totalOfferPrice = offerPrice;
        } else if (totalAccidentPrice.compareTo(BigDecimal.ZERO) > 0 && totalAccidentPrice.compareTo(new BigDecimal(4000)) <= 0) {
            totalOfferPrice = offerPrice.add(offerPrice.multiply(new BigDecimal(10)).divide(new BigDecimal(100)));
        } else if (totalAccidentPrice.compareTo(new BigDecimal(4000)) > 0 && totalAccidentPrice.compareTo(new BigDecimal(8000)) <= 0) {
            totalOfferPrice = offerPrice.add(offerPrice.multiply(new BigDecimal(25)).divide(new BigDecimal(100)));
        } else if (totalAccidentPrice.compareTo(new BigDecimal(8000)) > 0 && totalAccidentPrice.compareTo(new BigDecimal(16000)) <= 0) {
            totalOfferPrice = offerPrice.add(offerPrice.multiply(new BigDecimal(40)).divide(new BigDecimal(100)));
        } else {
            totalOfferPrice = offerPrice.add(offerPrice.multiply(new BigDecimal(80)).divide(new BigDecimal(100)));
        }
        return totalOfferPrice;
    }
}

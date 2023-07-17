package com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.service;

import com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model.*;

import java.util.ArrayList;
import java.util.List;

public class InsuranceRequestService {
    /**
     * Creates a new insurance request with the specified vehicle.
     *
     * @param vehicle The vehicle associated with the insurance request.
     * @return The created insurance request.
     */
    public InsuranceRequest createInsuranceRequest(Vehicle vehicle) {
        InsuranceRequest insuranceRequest = new InsuranceRequest();
        insuranceRequest.setVehicle(vehicle);
        return insuranceRequest;
    }

    /**
     * Adds a proposal to the specified insurance request.
     *
     * @param insuranceRequest The insurance request to which the proposal will be added.
     * @param proposal         The proposal to be added.
     */
    public void addProposalToInsuranceRequest(InsuranceRequest insuranceRequest, Proposal proposal) {
        if (insuranceRequest.getProposals() != null) {
            insuranceRequest.getProposals().add(proposal);
        } else {
            List<Proposal> proposals = new ArrayList<>();
            proposals.add(proposal);
            insuranceRequest.setProposals(proposals);
        }
    }

    /**
     * Adds a policy to the specified insurance request.
     *
     * @param insuranceRequest The insurance request to which the policy will be added.
     * @param policy           The policy to be added.
     */
    public void addPolicyToInsuranceRequest(InsuranceRequest insuranceRequest, Policy policy) {
        if (insuranceRequest.getPolicies() != null) {
            insuranceRequest.getPolicies().add(policy);
        } else {
            List<Policy> policies = new ArrayList<>();
            policies.add(policy);
            insuranceRequest.setPolicies(policies);
        }
    }

}
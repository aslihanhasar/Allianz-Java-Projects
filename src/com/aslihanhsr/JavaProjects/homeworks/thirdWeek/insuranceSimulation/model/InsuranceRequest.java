package com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model;

import java.util.List;

public class InsuranceRequest {
    private Vehicle vehicle;
    private List<Proposal> proposals;
    private List<Policy> policies;

    public List<Proposal> getProposals() {
        return proposals;
    }

    public void setProposals(List<Proposal> proposals) {
        this.proposals = proposals;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }

    @Override
    public String toString() {
        return "InsuranceRequest{" +
                "vehicle=" + vehicle +
                ", proposals=" + proposals +
                ", policies=" + policies +
                '}';
    }
}

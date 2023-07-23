package com.aslihanhasar.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model;

import java.util.List;

public class Customer {
    private String name;
    private CustomerType customerType;
    private List<BankAccount> bankAccounts;
    private List<InsuranceRequest> insuranceRequests;
    private List<Policy> policies;
    private List<PaymentMovement> paymentMovements;
    private List<Vehicle> vehicles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<InsuranceRequest> getInsuranceRequests() {
        return insuranceRequests;
    }

    public void setInsuranceRequests(List<InsuranceRequest> insuranceRequests) {
        this.insuranceRequests = insuranceRequests;
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }

    public List<PaymentMovement> getPaymentMovements() {
        return paymentMovements;
    }

    public void setPaymentMovements(List<PaymentMovement> paymentMovements) {
        this.paymentMovements = paymentMovements;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", customerType=" + customerType +
                ", bankAccounts=" + bankAccounts +
                ", insuranceRequests=" + insuranceRequests +
                ", policies=" + policies +
                ", paymentMovements=" + paymentMovements +
                ", vehicles=" + vehicles +
                '}';
    }
}

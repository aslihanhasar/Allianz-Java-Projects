package com.aslihanhasar.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model;

import java.util.List;

public class Agency {
    private String name;
    private List<BankAccount> bankAccounts;
    private List<PaymentMovement> paymentMovements;
    private List<InsuranceCompany> insuranceCompanies;
    private List<Customer> customers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<PaymentMovement> getPaymentMovements() {
        return paymentMovements;
    }

    public void setPaymentMovements(List<PaymentMovement> paymentMovements) {
        this.paymentMovements = paymentMovements;
    }

    public List<InsuranceCompany> getInsuranceCompanies() {
        return insuranceCompanies;
    }

    public void setInsuranceCompanies(List<InsuranceCompany> insuranceCompanies) {
        this.insuranceCompanies = insuranceCompanies;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "name='" + name + '\'' +
                ", bankAccounts=" + bankAccounts +
                ", paymentMovements=" + paymentMovements +
                ", insuranceCompanies=" + insuranceCompanies +
                ", customers=" + customers +
                '}';
    }
}

package com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model;

import java.math.BigDecimal;
import java.util.List;

public class InsuranceCompany {

    private String name;
    private String taxOffice;
    private String taxNumber;
    private String address;
    private BigDecimal commission;
    private List<Insurance> insurances;
    private List<BankAccount> bankAccounts;
    private List<PaymentMovement> paymentMovements;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxOffice() {
        return taxOffice;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public List<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
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

    @Override
    public String toString() {
        return "InsuranceCompany{" +
                "name='" + name + '\'' +
                ", taxOffice='" + taxOffice + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", address='" + address + '\'' +
                ", commission=" + commission +
                ", insurances=" + insurances +
                ", bankAccounts=" + bankAccounts +
                ", paymentMovements=" + paymentMovements +
                '}';
    }
}

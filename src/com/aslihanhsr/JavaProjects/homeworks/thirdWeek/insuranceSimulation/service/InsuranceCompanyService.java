package com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.service;

import com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InsuranceCompanyService {

    /**
     * Creates a new insurance company with the specified details.
     *
     * @param name       The name of the insurance company.
     * @param taxOffice  The tax office of the insurance company.
     * @param taxNumber  The tax number of the insurance company.
     * @param address    The address of the insurance company.
     * @param commission The commission rate of the insurance company.
     * @return The created insurance company.
     */
    public InsuranceCompany createInsuranceCompany(String name, String taxOffice, String taxNumber,
                                                   String address, BigDecimal commission) {
        InsuranceCompany insuranceCompany = new InsuranceCompany();
        insuranceCompany.setName(name);
        insuranceCompany.setTaxOffice(taxOffice);
        insuranceCompany.setTaxNumber(taxNumber);
        insuranceCompany.setAddress(address);
        insuranceCompany.setCommission(commission);
        return insuranceCompany;
    }

    /**
     * Adds an insurance to the specified insurance company.
     *
     * @param insuranceCompany The insurance company to which the insurance will be added.
     * @param insurance        The insurance to be added.
     */
    public void addInsuranceToInsuranceCompany(InsuranceCompany insuranceCompany, Insurance insurance) {
        if (insuranceCompany.getInsurances() != null) {
            insuranceCompany.getInsurances().add(insurance);
        } else {
            List<Insurance> insurances = new ArrayList<>();
            insurances.add(insurance);
            insuranceCompany.setInsurances(insurances);
        }
    }

    /**
     * Adds a bank account to the specified insurance company.
     *
     * @param insuranceCompany The insurance company to which the bank account will be added.
     * @param bankAccount      The bank account to be added.
     */
    public void addBankAccountToInsuranceCompany(InsuranceCompany insuranceCompany,
                                                 BankAccount bankAccount) {
        if (insuranceCompany.getBankAccounts() != null) {
            insuranceCompany.getBankAccounts().add(bankAccount);
        } else {
            List<BankAccount> bankAccounts = new ArrayList<>();
            bankAccounts.add(bankAccount);
            insuranceCompany.setBankAccounts(bankAccounts);
        }
    }

    /**
     * Adds a payment movement to the specified insurance company.
     *
     * @param insuranceCompany The agency to which the payment movement will be added.
     * @param paymentMovement  The payment movement to be added.
     */
    public void addPaymentMovementToInsuranceCompany(InsuranceCompany insuranceCompany,
                                                     PaymentMovement paymentMovement) {
        if (insuranceCompany.getPaymentMovements() != null) {
            insuranceCompany.getPaymentMovements().add(paymentMovement);
        } else {
            List<PaymentMovement> paymentMovements = new ArrayList<>();
            paymentMovements.add(paymentMovement);
            insuranceCompany.setPaymentMovements(paymentMovements);
        }
    }

    public BankAccount getBankAccountWithEnoughMoney(InsuranceCompany insuranceCompany,BigDecimal amount){
        for(BankAccount bankAccount:insuranceCompany.getBankAccounts()){
            if(bankAccount.getAmount().compareTo(amount)>=0){
                return bankAccount;
            }
        }
        return null;
    }

}

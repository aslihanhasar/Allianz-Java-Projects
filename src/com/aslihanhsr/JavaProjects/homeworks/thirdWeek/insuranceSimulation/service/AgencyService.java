package com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.service;

import com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AgencyService {

    /**
     * Creates a new agency with the specified name.
     *
     * @param name The name of the agency.
     * @return The created agency.
     */
    public Agency createAgency(String name) {
        Agency agency = new Agency();
        agency.setName(name);
        return agency;
    }

    /**
     * Adds a bank account to the specified agency.
     *
     * @param agency      The agency to which the bank account will be added.
     * @param bankAccount The bank account to be added.
     */
    public void addBankAccountToAgency(Agency agency, BankAccount bankAccount) {
        if (agency.getBankAccounts() != null) {
            agency.getBankAccounts().add(bankAccount);
        } else {
            List<BankAccount> bankAccounts = new ArrayList<>();
            bankAccounts.add(bankAccount);
            agency.setBankAccounts(bankAccounts);
        }
    }


    /**
     * Adds a payment movement to the specified agency.
     *
     * @param agency          The agency to which the payment movement will be added.
     * @param paymentMovement The payment movement to be added.
     */
    public void addPaymentMovementToAgency(Agency agency, PaymentMovement paymentMovement) {
        if (agency.getPaymentMovements() != null) {
            agency.getPaymentMovements().add(paymentMovement);
        } else {
            List<PaymentMovement> paymentMovements = new ArrayList<>();
            paymentMovements.add(paymentMovement);
            agency.setPaymentMovements(paymentMovements);
        }
    }

    /**
     * Adds an insurance company to the specified agency.
     *
     * @param agency           The agency to which the insurance company will be added.
     * @param insuranceCompany The insurance company to be added.
     */
    public void addInsuranceCompanyToAgency(Agency agency, InsuranceCompany insuranceCompany) {
        if (agency.getInsuranceCompanies() != null) {
            agency.getInsuranceCompanies().add(insuranceCompany);
        } else {
            List<InsuranceCompany> insuranceCompanies = new ArrayList<>();
            insuranceCompanies.add(insuranceCompany);
            agency.setInsuranceCompanies(insuranceCompanies);
        }
    }

    /**
     * Adds a customer to the specified agency.
     *
     * @param agency   The agency to which the customer will be added.
     * @param customer The customer to be added.
     */
    public void addCustomerToAgency(Agency agency, Customer customer) {
        if (agency.getCustomers() != null) {
            agency.getCustomers().add(customer);
        } else {
            List<Customer> customers = new ArrayList<>();
            customers.add(customer);
            agency.setCustomers(customers);
        }
    }

    /**
     * Retrieves a bank account from the specified agency that has a balance
     * equal to or greater than the specified amount.
     *
     * @param agency The agency to search for the bank account.
     * @param amount The minimum required amount in the bank account.
     * @return The bank account with enough money, or null if none is found.
     */
    public BankAccount getBankAccountWithEnoughMoney(Agency agency, BigDecimal amount) {
        for (BankAccount bankAccount : agency.getBankAccounts()) {
            if (bankAccount.getAmount().compareTo(amount) >= 0) {
                return bankAccount;
            }
        }
        return null;
    }

}

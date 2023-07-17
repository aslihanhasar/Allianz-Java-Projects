package com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.service;

import com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model.*;

import java.math.BigDecimal;

public class BankAccountService {
    /**
     * Creates a new bank account with the specified details.
     *
     * @param bankName    The name of the bank.
     * @param ibanNo      The IBAN number of the account.
     * @param companyName The name of the company associated with the account.
     * @param amount      The initial amount of money in the account.
     * @return The created bank account.
     */
    public BankAccount createBankAccount(String bankName, String ibanNo, String companyName, BigDecimal amount) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankName(bankName);
        bankAccount.setCompanyName(companyName);
        bankAccount.setIbanNo(ibanNo);
        bankAccount.setAmount(amount);
        return bankAccount;
    }

    /**
     * Retrieves a bank account from the specified agency that has a balance
     * equal to or greater than the specified amount.
     *
     * @param agency The agency to search for the bank account.
     * @param amount The minimum required amount in the bank account.
     * @return The bank account with enough money, or null if none is found.
     */
    public BankAccount getAgencyBankAccountWithEnoughMoney(Agency agency, BigDecimal amount) {
        for (BankAccount bankAccount : agency.getBankAccounts()) {
            if (bankAccount.getAmount().compareTo(amount) >= 0) {
                return bankAccount;
            }
        }
        return null;
    }

}

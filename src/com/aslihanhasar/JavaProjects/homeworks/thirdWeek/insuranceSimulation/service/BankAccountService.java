package com.aslihanhasar.JavaProjects.homeworks.thirdWeek.insuranceSimulation.service;

import com.aslihanhasar.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model.BankAccount;

import java.math.BigDecimal;

public class BankAccountService {
    /**
     * Creates a new bank account with the specified details.
     *
     * @param bankName    The name of the bank.
     * @param ibanNo      The IBAN number of the account.
     * @param amount      The initial amount of money in the account.
     * @return The created bank account.
     */
    public BankAccount createBankAccount(String bankName, String ibanNo, BigDecimal amount) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankName(bankName);
        bankAccount.setIbanNo(ibanNo);
        bankAccount.setAmount(amount);
        return bankAccount;
    }

}

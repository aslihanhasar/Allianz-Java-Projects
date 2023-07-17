package com.aslihanhsr.JavaProjects.practices.secondWeek.danceCourseSimulation.service;

import com.aslihanhsr.JavaProjects.practices.secondWeek.danceCourseSimulation.model.BankAccount;
import com.aslihanhsr.JavaProjects.practices.secondWeek.danceCourseSimulation.model.MovementType;
import com.aslihanhsr.JavaProjects.practices.secondWeek.danceCourseSimulation.model.PaymentMovement;

import java.math.BigDecimal;

public class BankPaymentService {
    public BankAccount createBankAccount(String bankName, String ibanNo, String companyName) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankName(bankName);
        bankAccount.setIbanNo(ibanNo);
        bankAccount.setCompanyName(companyName);
        bankAccount.setAmount((BigDecimal.ZERO));
        return bankAccount;
    }

    public PaymentMovement createPaymentMovement(BankAccount bankAccount, String description,
                                                 MovementType movementType, BigDecimal amount) {
        PaymentMovement paymentMovement = new PaymentMovement();
        paymentMovement.setBankAccount(bankAccount);
        paymentMovement.setDescription(description);
        paymentMovement.setMovementType(movementType);
        paymentMovement.setAmount(amount);
        return paymentMovement;
    }
}

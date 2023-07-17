package com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.service;

import com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model.*;

import java.math.BigDecimal;

public class PaymentMovementService {

    /**
     * Creates a new payment movement with the specified details.
     *
     * @param bankAccount  The bank account associated with the payment movement.
     * @param description  A description or note about the payment movement.
     * @param movementType The type of movement, such as "credit" or "debit".
     * @param amount       The amount of money involved in the payment movement.
     * @return The created payment movement.
     */
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

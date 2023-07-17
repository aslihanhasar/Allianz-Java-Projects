package com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.service;

import com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model.*;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    /**
     * Creates a new customer with the specified name and customer type.
     *
     * @param name         The name of the customer.
     * @param customerType The type of the customer.
     * @return The created customer.
     */
    public Customer createCustomer(String name, CustomerType customerType) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCustomerType(customerType);
        return customer;
    }

    /**
     * Adds a bank account to the specified customer.
     *
     * @param customer    The customer to which the bank account will be added.
     * @param bankAccount The bank account to be added.
     */
    public void addBankAccountToCustomer(Customer customer, BankAccount bankAccount) {
        if (customer.getBankAccounts() != null) {
            customer.getBankAccounts().add(bankAccount);
        } else {
            List<BankAccount> bankAccounts = new ArrayList<>();
            bankAccounts.add(bankAccount);
            customer.setBankAccounts(bankAccounts);
        }
    }

    /**
     * Adds an insurance request to the specified customer.
     *
     * @param customer         The customer to which the insurance request will be added.
     * @param insuranceRequest The insurance request to be added.
     */
    public void addInsuranceRequestToCustomer(Customer customer, InsuranceRequest insuranceRequest) {
        if (customer.getInsuranceRequests() != null) {
            customer.getInsuranceRequests().add(insuranceRequest);
        } else {
            List<InsuranceRequest> insuranceRequests = new ArrayList<>();
            insuranceRequests.add(insuranceRequest);
            customer.setInsuranceRequests(insuranceRequests);
        }
    }

    /**
     * Adds a policy to the specified customer.
     *
     * @param customer The customer to which the policy will be added.
     * @param policy   The policy to be added.
     */
    public void addPolicyToCustomer(Customer customer, Policy policy) {
        if (customer.getPolicies() != null) {
            customer.getPolicies().add(policy);
        } else {
            List<Policy> policies = new ArrayList<>();
            policies.add(policy);
            customer.setPolicies(policies);
        }
    }

    /**
     * Adds a payment movement to the specified customer.
     *
     * @param customer        The customer to which the payment movement will be added.
     * @param paymentMovement The payment movement to be added.
     */
    public void addPaymentMovementToCustomer(Customer customer, PaymentMovement paymentMovement) {
        if (customer.getPaymentMovements() != null) {
            customer.getPaymentMovements().add(paymentMovement);
        } else {
            List<PaymentMovement> paymentMovements = new ArrayList<>();
            paymentMovements.add(paymentMovement);
            customer.setPaymentMovements(paymentMovements);
        }
    }

    /**
     * Adds a vehicle to the specified customer.
     *
     * @param customer The customer to which the vehicle will be added.
     * @param vehicle  The vehicle to be added.
     */
    public void addVehicleToCustomer(Customer customer, Vehicle vehicle) {
        if (customer.getVehicles() != null) {
            customer.getVehicles().add(vehicle);
        } else {
            List<Vehicle> vehicles = new ArrayList<>();
            vehicles.add(vehicle);
            customer.setVehicles(vehicles);
        }
    }
}

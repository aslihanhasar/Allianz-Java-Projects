package com.aslihanhasar.JavaProjects.homeworks.thirdWeek.insuranceSimulation.service;

import com.aslihanhasar.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    ProposalService proposalService = new ProposalService();
    AgencyService agencyService = new AgencyService();
    PaymentMovementService paymentMovementService = new PaymentMovementService();
    InsuranceCompanyService insuranceCompanyService = new InsuranceCompanyService();

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

    public BankAccount getBankAccountWithEnoughMoney(Customer customer, BigDecimal amount) {
        for (BankAccount bankAccount : customer.getBankAccounts()) {
            if (bankAccount.getAmount().compareTo(amount) >= 0) {
                return bankAccount;
            }
        }
        return null;
    }

    public void acceptProposal(Agency agency, Customer customer, Proposal proposal, InsuranceRequest insuranceRequest) {
        List<InsuranceRequest> customerInsuranceRequests = customer.getInsuranceRequests();
        for (InsuranceRequest insuranceRequest1 : customerInsuranceRequests) {
            if (insuranceRequest1.equals(insuranceRequest)) {
                for (Proposal proposal1 : insuranceRequest.getProposals()) {
                    if (proposal1.equals(proposal)) {
                        BigDecimal totalOfferPrice = proposalService.calculateDiscountedPrice(proposal);
                        BankAccount customerBankAccount = getBankAccountWithEnoughMoney(customer, totalOfferPrice);
                        if (customerBankAccount != null) {
                            BigDecimal remainingCustomerAmount = customerBankAccount.getAmount().subtract(totalOfferPrice);
                            customerBankAccount.setAmount(remainingCustomerAmount);

                            PaymentMovement customerPaymentMovement = paymentMovementService.
                                    createPaymentMovement(customerBankAccount,
                                            "Payment for the proposal. " + proposal,
                                            MovementType.OUTCOME, totalOfferPrice);
                            addPaymentMovementToCustomer(customer, customerPaymentMovement);
                            System.out.println("Movements: " + customerPaymentMovement);


                            InsuranceCompany insuranceCompany = proposal.getCompany();
                            if (insuranceCompany.getBankAccounts() != null) {
                                BankAccount companyBankAccount = insuranceCompany.getBankAccounts().get(0);
                                companyBankAccount.setAmount(totalOfferPrice);

                                PaymentMovement companyRevenuePaymentMovement = paymentMovementService.
                                        createPaymentMovement(companyBankAccount,
                                                "Revenue for the proposal. " + proposal,
                                                MovementType.INCOME, totalOfferPrice);
                                insuranceCompanyService.addPaymentMovementToInsuranceCompany
                                        (insuranceCompany, companyRevenuePaymentMovement);
                                System.out.println("Movements: " + companyRevenuePaymentMovement);

                                BigDecimal calculatedCommissionAmount = insuranceCompanyService
                                        .getCalculatedCommissionAmount(insuranceCompany, totalOfferPrice);
                                BigDecimal currentCompanyBalance=companyBankAccount.
                                        getAmount().subtract(calculatedCommissionAmount);
                                companyBankAccount.setAmount(currentCompanyBalance);

                                PaymentMovement companyPaymentMovement = paymentMovementService.
                                        createPaymentMovement(companyBankAccount,
                                                "Payment for the commission.  " + agency,
                                                MovementType.OUTCOME, calculatedCommissionAmount);
                                System.out.println("Movements: "+companyPaymentMovement);

                                if (agency.getBankAccounts() != null) {
                                    BankAccount agencyBankAccount = agency.getBankAccounts().get(0);
                                    agencyBankAccount.setAmount(calculatedCommissionAmount);
                                    PaymentMovement agencyPaymentMovement = paymentMovementService.
                                            createPaymentMovement(agencyBankAccount,
                                                    "Commission revenue for the proposal. " + proposal,
                                                    MovementType.INCOME, calculatedCommissionAmount);
                                    agencyService.addPaymentMovementToAgency(agency, agencyPaymentMovement);
                                    System.out.println("Movements: " + agencyPaymentMovement);

                                    proposal.setApproved(true);
                                    System.out.println(proposal);
                                }
                            }


                        } else {
                            System.out.println("No such a bank account found.");
                        }

                    }

                }
            }
        }
    }
}

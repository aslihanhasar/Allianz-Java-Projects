package com.aslihanhasar.JavaProjects.homeworks.thirdWeek.insuranceSimulation;

import java.math.BigDecimal;
import java.util.List;
/*
public class Main2 {

    ProposalService proposalService=new ProposalService();
    CustomerService customerService=new CustomerService();
    PaymentMovementService paymentMovementService=new PaymentMovementService();
    InsuranceCompanyService insuranceCompanyService=new InsuranceCompanyService();
    AgencyService agencyService=new AgencyService();

    public void acceptProposal(Agency agency, Customer customer, Proposal proposal, InsuranceRequest insuranceRequest) {
        List<InsuranceRequest> customerInsuranceRequests = customer.getInsuranceRequests();
        for (InsuranceRequest insuranceRequest1 : customerInsuranceRequests) {
            if (insuranceRequest1.equals(insuranceRequest)) {
                for (Proposal proposal1 : insuranceRequest.getProposals()) {
                    if (proposal1.equals(proposal)) {
                        processProposal(agency, customer, proposal, insuranceRequest);
                        return;
                    }
                }
            }
        }
    }

    private void processProposal(Agency agency, Customer customer, Proposal proposal, InsuranceRequest insuranceRequest) {
        BigDecimal totalOfferPrice = proposalService.calculateDiscountedPrice(proposal);
        BankAccount customerBankAccount = customerService.getBankAccountWithEnoughMoney(customer, totalOfferPrice);
        if (customerBankAccount != null) {
            handleCustomerPayment(customer, proposal, totalOfferPrice);
            handleCompanyRevenue(insuranceRequest, proposal, totalOfferPrice);
            handleCommissionPayment(agency, proposal, totalOfferPrice);
            proposal.setApproved(true);
            System.out.println(proposal);
        } else {
            System.out.println("No such a bank account found.");
        }
    }

    private void handleCustomerPayment(Customer customer, Proposal proposal, BigDecimal totalOfferPrice) {
        BigDecimal remainingCustomerAmount = customer.ge.getAmount().subtract(totalOfferPrice);
        customerBankAccount.setAmount(remainingCustomerAmount);

        PaymentMovement customerPaymentMovement = paymentMovementService.createPaymentMovement(
                customerBankAccount,
                "Payment for the proposal. " + proposal,
                MovementType.OUTCOME,
                totalOfferPrice
        );
        customerService.addPaymentMovementToCustomer(customer, customerPaymentMovement);
        System.out.println("Movements: " + customerPaymentMovement);
    }

    private void handleCompanyRevenue(InsuranceRequest insuranceRequest, Proposal proposal, BigDecimal totalOfferPrice) {
        InsuranceCompany insuranceCompany = proposal.getCompany();
        if (insuranceCompany.getBankAccounts() != null) {
            BankAccount companyBankAccount = insuranceCompany.getBankAccounts().get(0);
            companyBankAccount.setAmount(totalOfferPrice);

            PaymentMovement companyRevenuePaymentMovement = paymentMovementService.createPaymentMovement(
                    companyBankAccount,
                    "Revenue for the proposal. " + proposal,
                    MovementType.INCOME,
                    totalOfferPrice
            );

            insuranceCompanyService.addPaymentMovementToInsuranceCompany(insuranceCompany, companyRevenuePaymentMovement);
            System.out.println("Movements: " + companyRevenuePaymentMovement);

            BigDecimal calculatedCommissionAmount = insuranceCompanyService.getCalculatedCommissionAmount(
                    insuranceCompany,
                    totalOfferPrice
            );
            BigDecimal currentCompanyBalance = companyBankAccount.getAmount().subtract(calculatedCommissionAmount);
            companyBankAccount.setAmount(currentCompanyBalance);

            PaymentMovement companyPaymentMovement = paymentMovementService.createPaymentMovement(
                    companyBankAccount,
                    "Payment for the commission.  " + agency,
                    MovementType.OUTCOME,
                    calculatedCommissionAmount
            );
            System.out.println("Movements: " + companyPaymentMovement);
        }
    }

    private void handleCommissionPayment(Agency agency, Proposal proposal, BigDecimal totalOfferPrice) {
        if (agency.getBankAccounts() != null) {
            BankAccount agencyBankAccount = agency.getBankAccounts().get(0);
            agencyBankAccount.setAmount(totalOfferPrice);
            PaymentMovement agencyPaymentMovement = paymentMovementService.createPaymentMovement(
                    agencyBankAccount,
                    "Commission revenue for the proposal. " + proposal,
                    MovementType.INCOME,
                    totalOfferPrice
            );
            agencyService.addPaymentMovementToAgency(agency, agencyPaymentMovement);
            System.out.println("Movements: " + agencyPaymentMovement);
        }
    }

 */



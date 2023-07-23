package com.aslihanhasar.JavaProjects.homeworks.thirdWeek.insuranceSimulation;

import com.aslihanhasar.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model.*;
import com.aslihanhasar.JavaProjects.homeworks.thirdWeek.insuranceSimulation.service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        AgencyService agencyService = new AgencyService();
        Agency agency = agencyService.createAgency("MOM");
        System.out.println(agency);

        BankAccountService bankAccountService = new BankAccountService();
        BankAccount bankAccount = bankAccountService.createBankAccount("Ziraat Bankasi", "TR20300000048476353", BigDecimal.ZERO);

        agencyService.addBankAccountToAgency(agency, bankAccount);
        System.out.println(agency);

        InsuranceCompanyService insuranceCompanyService = new InsuranceCompanyService();
        InsuranceCompany insuranceCompany = insuranceCompanyService.createInsuranceCompany("Allianz", "727384849",
                "Ankara", "Ankara/ Cankaya", new BigDecimal(8));

        InsuranceService insuranceService = new InsuranceService();
        Insurance insurance = insuranceService.createInsurance(InsuranceType.COMPULSORY_TRAFFIC_INSURANCE,"compulsory traffic insurance" );
        insuranceCompanyService.addInsuranceToInsuranceCompany(insuranceCompany, insurance);
        BankAccount allianzBankAccount = bankAccountService.createBankAccount("Yapi Kredi Bankasi", "TR20300000048476353", new BigDecimal(1000000));
        insuranceCompanyService.addBankAccountToInsuranceCompany(insuranceCompany, allianzBankAccount);

        CustomerService customerService = new CustomerService();
        Customer customer = customerService.createCustomer("Sinem", CustomerType.CORPORATE);

        BankAccount customerBankAccount = bankAccountService.createBankAccount("Is Bankasi",
                "TR139128309183907", new BigDecimal(10000));

        customerService.addBankAccountToCustomer(customer, customerBankAccount);
        agencyService.addInsuranceCompanyToAgency(agency, insuranceCompany);
        agencyService.addCustomerToAgency(agency, customer);

        VehicleService vehicleService = new VehicleService();
        Vehicle vehicle = vehicleService.createVehicle("Ford", "Focus",
                "34cd474","2345",2010, ColorType.BLACK);

        customerService.addVehicleToCustomer(customer, vehicle);
        System.out.println(customer);

        InsuranceRequestService insuranceRequestService=new InsuranceRequestService();
        InsuranceRequest insuranceRequest =insuranceRequestService.createInsuranceRequest(vehicle,InsuranceType.COMPULSORY_TRAFFIC_INSURANCE);

        customerService.addInsuranceRequestToCustomer(customer,insuranceRequest);

        LocalDate startDate=LocalDate.of(2010, Month.APRIL,15);
        LocalDate endDate=LocalDate.of(2011,Month.APRIL,15);
        LocalDate expireDate=startDate.plusDays(3);

        AccidentService accidentService=new AccidentService();
        LocalDate accidentDate=LocalDate.now();
        Accident accident=accidentService.createAccident(accidentDate,"sdadasds",new BigDecimal(1000),4);
        vehicleService.addAccidentToVehicle(vehicle,accident);

        ProposalService proposalService=new ProposalService();
        Proposal proposal= proposalService.createProposal(insuranceCompany,vehicle,new BigDecimal(1000),startDate,
                endDate,expireDate,new BigDecimal(100));
        insuranceRequestService.addProposalToInsuranceRequest(insuranceRequest,proposal);

        customerService.acceptProposal(agency,customer,proposal,insuranceRequest);



    }
}

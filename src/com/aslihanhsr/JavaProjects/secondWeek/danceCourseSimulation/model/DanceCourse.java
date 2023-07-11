package com.aslihanhsr.JavaProjects.secondWeek.danceCourseSimulation.model;

import java.util.List;

public class DanceCourse {
    private String name;
    private String address;
    private String founder;
    private String taxNumber;
    private String taxOffice;
    private List<BankAccount> bankAccounts;
    private List<PaymentMovement> paymentMovements;
    private List<Instructor> instructors;
    private List<Student> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getTaxOffice() {
        return taxOffice;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<PaymentMovement> getPaymentMovements() {
        return paymentMovements;
    }

    public void setPaymentMovements(List<PaymentMovement> paymentMovements) {
        this.paymentMovements = paymentMovements;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "DanceCourse{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", founder='" + founder + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", taxOffice='" + taxOffice + '\'' +
                ", bankAccounts=" + bankAccounts +
                ", paymentMovements=" + paymentMovements +
                ", instructors=" + instructors +
                ", students=" + students +
                '}';
    }
}

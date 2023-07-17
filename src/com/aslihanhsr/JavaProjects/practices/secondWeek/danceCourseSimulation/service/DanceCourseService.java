package com.aslihanhsr.JavaProjects.practices.secondWeek.danceCourseSimulation.service;

import com.aslihanhsr.JavaProjects.practices.secondWeek.danceCourseSimulation.model.BankAccount;
import com.aslihanhsr.JavaProjects.practices.secondWeek.danceCourseSimulation.model.DanceCourse;

public class DanceCourseService {
    public DanceCourse createDanceCourse(String name, String address, String founder, String taxNumber, String taxOffice) {
        DanceCourse danceCourse = new DanceCourse();
        danceCourse.setName(name);
        danceCourse.setAddress(address);
        danceCourse.setFounder(founder);
        danceCourse.setTaxNumber(taxNumber);
        danceCourse.setTaxOffice(taxOffice);
        return danceCourse;
    }

    public void createBankAccountToDanceCourse(DanceCourse danceCourse, BankAccount bankAccount) {

    }

    public boolean isExistBankAccount(DanceCourse danceCourse, BankAccount bankAccount) {
        boolean isExist = false;
        for (BankAccount b : danceCourse.getBankAccounts()) {
            if (b.getIbanNo().equalsIgnoreCase(bankAccount.getIbanNo())) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }


}

package com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model;

public class Insurance {
    private InsuranceType insuranceType;
    private String name;

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "insuranceType=" + insuranceType +
                ", name='" + name + '\'' +
                '}';
    }
}

package com.aslihanhasar.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model;

import java.util.List;

public class Vehicle {
    private String brand;
    private String model;
    private String plate;
    private String chassisNumber;
    private int modelYear;
    private List<Accident> accidents;
    private ColorType colorType;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public List<Accident> getAccidents() {
        return accidents;
    }

    public void setAccidents(List<Accident> accidents) {
        this.accidents = accidents;
    }

    public ColorType getColorType() {
        return colorType;
    }

    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", plate='" + plate + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", modelYear=" + modelYear +
                ", accidents=" + accidents +
                ", colorType=" + colorType +
                '}';
    }
}

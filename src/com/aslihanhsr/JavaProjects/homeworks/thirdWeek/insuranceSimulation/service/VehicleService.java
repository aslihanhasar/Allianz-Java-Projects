package com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.service;

import com.aslihanhsr.JavaProjects.homeworks.thirdWeek.insuranceSimulation.model.*;

import java.util.ArrayList;
import java.util.List;

public class VehicleService {

    /**
     * Creates a new vehicle with the specified details.
     *
     * @param brand         The brand of the vehicle.
     * @param model         The model of the vehicle.
     * @param plate         The license plate of the vehicle.
     * @param chassisNumber The chassis number of the vehicle.
     * @param modelYear     The model year of the vehicle.
     * @param colorType     The color type of the vehicle.
     * @return The created vehicle.
     */
    public Vehicle createVehicle(String brand, String model, String plate,
                                 String chassisNumber, int modelYear, ColorType colorType) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(brand);
        vehicle.setModel(model);
        vehicle.setPlate(plate);
        vehicle.setChassisNumber(chassisNumber);
        vehicle.setModelYear(modelYear);
        vehicle.setColorType(colorType);
        return vehicle;
    }

    /**
     * Adds an accident to the specified vehicle.
     *
     * @param vehicle  The vehicle to which the accident will be added.
     * @param accident The accident to be added.
     */
    public void addAccidentToVehicle(Vehicle vehicle, Accident accident) {
        if (vehicle.getAccidents() != null) {
            vehicle.getAccidents().add(accident);
        } else {
            List<Accident> accidents = new ArrayList<>();
            accidents.add(accident);
            vehicle.setAccidents(accidents);
        }
    }
}

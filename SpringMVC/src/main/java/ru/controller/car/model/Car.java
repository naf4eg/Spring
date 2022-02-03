package ru.controller.car.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Car
 */
public class Car {
    private String modelName;
    private String color;
    private String country;
    private String engineFuel;
    final private HashMap<String, String> countryList = new HashMap<String, String>();
    final private HashMap<String, String> engineFuelList = new HashMap<String, String>();
    final private List<String> listCarOptions = new LinkedList<String>();
    private List<String> listChooseCarOptions = new LinkedList<String>();

    public Car() {
        countryList.put("JP", "Japan");
        countryList.put("RU", "Russia");
        countryList.put("US", "United States of America");
        countryList.put("DE", "Germany");

        engineFuelList.put("Diesel","Diesel");
        engineFuelList.put("Petrol","Petrol");

        listCarOptions.addAll(List.of("Audio System SONY", "Conditioner", "Heated Steering Wheel"));
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public HashMap<String, String> getCountryList() {
        return countryList;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEngineFuel() {
        return engineFuel;
    }

    public void setEngineFuel(String engineFuel) {
        this.engineFuel = engineFuel;
    }

    public HashMap<String, String> getEngineFuelList() {
        return engineFuelList;
    }

    public List<String> getListCarOptions() {
        return listCarOptions;
    }

    public List<String> getListChooseCarOptions() {
        return listChooseCarOptions;
    }

    public void setListChooseCarOptions(List<String> listChooseCarOptions) {
        this.listChooseCarOptions = listChooseCarOptions;
    }
}

package ru.controller.car.model;

import java.util.HashMap;

public class Car {
    private String modelName;
    private String color;
    private String country;
    private String engineFuel;
    private HashMap<String, String> countryList = new HashMap();
    private HashMap<String, String> engineFuelList = new HashMap();

    public Car() {
        countryList.put("JP", "Japan");
        countryList.put("RU", "Russia");
        countryList.put("US", "United States of America");
        countryList.put("DE", "Germany");

        engineFuelList.put("Diesel","Diesel");
        engineFuelList.put("Petrol","Petrol");
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

    public void setCountryList(HashMap<String, String> countryList) {
        this.countryList = countryList;
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

    public void setEngineFuelList(HashMap<String, String> engineFuelList) {
        this.engineFuelList = engineFuelList;
    }
}

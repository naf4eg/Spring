package ru.controller.car.model;

import javax.validation.constraints.*;

/**
 * Driver car
 */
public class Driver {
    @NotNull
    @Size(min = 1, message = "is required")
    private String firstName;

    @NotNull
    @Size(min = 1, message = "is required")
    private String lastName;

    @Min(value = 0, message = "incorrect driving experience")
    @Max(value = 50, message = "incorrect driving experience")
    private int drivingExperience;

    @Pattern(regexp = "[a-zA-Z]{4}[0-9]{5}", message = "aaAA12345")
    private String driversLicense;

    public String getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(String driversLicense) {
        this.driversLicense = driversLicense;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
    }
}

package ru.controller.car.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

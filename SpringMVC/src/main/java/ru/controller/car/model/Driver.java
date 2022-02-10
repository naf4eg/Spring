package ru.controller.car.model;

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

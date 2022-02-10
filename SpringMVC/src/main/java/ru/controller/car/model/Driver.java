package ru.controller.car.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Driver car
 */
public class Driver {
    @NotNull(message = "is required")
    @Size(min = 1)
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1)
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

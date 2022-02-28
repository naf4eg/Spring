package ru.controller.car.model.annotation.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DriverCodeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DriverCode {
    public String value() default "RUS";
    public String message() default "must start with RUS";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}

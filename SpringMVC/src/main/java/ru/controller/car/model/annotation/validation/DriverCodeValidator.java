package ru.controller.car.model.annotation.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DriverCodeValidator implements ConstraintValidator<DriverCode, String> {

   String prefix;

   public void initialize(DriverCode constraint) {
      prefix = constraint.value();
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      return obj.startsWith(prefix);
   }
}

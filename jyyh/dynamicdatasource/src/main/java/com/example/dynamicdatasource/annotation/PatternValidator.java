package com.example.dynamicdatasource.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PatternValidator implements ConstraintValidator<TestAnnotation, String> {


    @Override
    public void initialize(TestAnnotation constraintAnnotation) {
         System.out.println(constraintAnnotation.value());
         System.out.println("22222222");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println("22222");
        return false;
    }
}

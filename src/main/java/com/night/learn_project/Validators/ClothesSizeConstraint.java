package com.night.learn_project.Validators;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// Аннотация на поля и параметры.
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ClothesSizeValidator.class)
public @interface ClothesSizeConstraint {
    // Сообщение об ошибке берем из messages файла. Локали есть тоже разные.
    String message() default "{validation.errors.clothes_size}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

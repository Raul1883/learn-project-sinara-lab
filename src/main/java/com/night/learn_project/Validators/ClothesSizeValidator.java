package com.night.learn_project.Validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClothesSizeValidator implements ConstraintValidator<ClothesSizeConstraint, String> {


    // Логика валидации
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            // Если значение корректно и входит в Enum -> нет ошибки -> true
            ClothesSize.valueOf(s);
            return true;
        } catch (IllegalArgumentException ex) {
            // Если ошибка -> false
            return false;
        }

        // По идее, это один из самых быстрых и при этом читаемых вариантов для валидации
        // малой конечной группы. Но если есть предложения лучше - было бы интересно узнать.

    }

    private enum ClothesSize {
        XS,
        S,
        M,
        L,
        XL,
        XXL,
        XXXL
    }
}

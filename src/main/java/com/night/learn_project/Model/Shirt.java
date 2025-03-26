package com.night.learn_project.Model;


import com.night.learn_project.Validators.ClothesSizeConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

//Класс модели, который использует аннотация для валидации
@Data
@AllArgsConstructor
public class Shirt {

    @NotBlank
    private String color;

    @NotBlank
    private String brand;

    @ClothesSizeConstraint
    private String size;
}

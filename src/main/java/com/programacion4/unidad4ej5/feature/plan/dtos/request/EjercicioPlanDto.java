package com.programacion4.unidad4ej5.feature.plan.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class EjercicioPlanDto {

    @NotBlank(message = "El nombre del ejercicio es obligatorio")
    private String nombre;

    @NotNull(message = "La cantidad de series es obligatoria")
    @Min(value = 1, message = "Debe tener al menos 1 serie")
    private Integer series;

    @NotNull(message = "La cantidad de repeticiones es obligatoria")
    @Min(value = 1, message = "Debe tener al menos 1 repetición")
    private Integer repeticiones;
}
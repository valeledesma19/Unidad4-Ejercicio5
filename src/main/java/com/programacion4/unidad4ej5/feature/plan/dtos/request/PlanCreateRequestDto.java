package com.programacion4.unidad4ej5.feature.plan.dtos.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
public class PlanCreateRequestDto {

    // Necesitamos saber a qué socio le estamos creando este plan
    @NotNull(message = "El ID del socio es obligatorio")
    private Long socioId;

    @NotBlank(message = "El objetivo es obligatorio")
    @Size(min = 10, max = 200, message = "El objetivo debe tener entre 10 y 200 caracteres")
    private String objetivo;

    @NotNull(message = "La frecuencia semanal es obligatoria")
    @Min(value = 1, message = "La frecuencia mínima es 1 vez por semana")
    @Max(value = 7, message = "La frecuencia máxima es 7 veces por semana")
    private Integer frecuenciaSemanal;

    @NotNull(message = "El peso inicial es obligatorio")
    @DecimalMin(value = "30.0", message = "El peso mínimo es 30.0 kg")
    @DecimalMax(value = "250.0", message = "El peso máximo es 250.0 kg")
    private Double pesoInicial;

    @NotNull(message = "La altura es obligatoria")
    @DecimalMin(value = "1.0", message = "La altura mínima es 1.0 metro")
    @DecimalMax(value = "2.5", message = "La altura máxima es 2.5 metros")
    private Double altura;

    @NotEmpty(message = "La lista de ejercicios no puede estar vacía")
    @Size(min = 3, message = "Debe contener al menos 3 ejercicios definidos")
    private List<@Valid EjercicioPlanDto> ejercicios;
}
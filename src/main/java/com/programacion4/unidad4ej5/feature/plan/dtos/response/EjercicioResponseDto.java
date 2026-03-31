package com.programacion4.unidad4ej5.feature.plan.dtos.response;

import lombok.Data;

@Data
public class EjercicioResponseDto {
    private Long id;
    private String nombre;
    private Integer series;
    private Integer repeticiones;
}
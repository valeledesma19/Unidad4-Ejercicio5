package com.programacion4.unidad4ej5.feature.plan.dtos.response;

import lombok.Data;
import java.util.List;

@Data
public class PlanResponseDto {
    private Long id;
    private Long socioId;
    private String nombreSocio;
    private String objetivo;
    private Integer frecuenciaSemanal;
    private Double pesoInicial;
    private Double altura;
    private List<EjercicioResponseDto> ejercicios;
}
package com.programacion4.unidad4ej5.feature.plan.mappers;

import com.programacion4.unidad4ej5.feature.plan.domain.Ejercicio;
import com.programacion4.unidad4ej5.feature.plan.domain.PlanEntrenamiento;
import com.programacion4.unidad4ej5.feature.plan.dtos.response.EjercicioResponseDto;
import com.programacion4.unidad4ej5.feature.plan.dtos.response.PlanResponseDto;

import java.util.stream.Collectors;

public class PlanMapper {

    public static PlanResponseDto toResponseDto(PlanEntrenamiento entity) {
        PlanResponseDto dto = new PlanResponseDto();
        dto.setId(entity.getId());

        if (entity.getSocio() != null) {
            dto.setSocioId(entity.getSocio().getId());
            dto.setNombreSocio(entity.getSocio().getNombre() + " " + entity.getSocio().getApellido());
        }

        dto.setObjetivo(entity.getObjetivo());
        dto.setFrecuenciaSemanal(entity.getFrecuenciaSemanal());
        dto.setPesoInicial(entity.getPesoInicial());
        dto.setAltura(entity.getAltura());


        if (entity.getEjercicios() != null) {
            dto.setEjercicios(entity.getEjercicios().stream().map(ejercicio -> {
                EjercicioResponseDto ejDto = new EjercicioResponseDto();
                ejDto.setId(ejercicio.getId());
                ejDto.setNombre(ejercicio.getNombre());
                ejDto.setSeries(ejercicio.getSeries());
                ejDto.setRepeticiones(ejercicio.getRepeticiones());
                return ejDto;
            }).collect(Collectors.toList()));
        }

        return dto;
    }
}
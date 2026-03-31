package com.programacion4.unidad4ej5.feature.plan.services;

import com.programacion4.unidad4ej5.feature.plan.domain.Ejercicio;
import com.programacion4.unidad4ej5.feature.plan.domain.PlanEntrenamiento;
import com.programacion4.unidad4ej5.feature.plan.dtos.request.EjercicioPlanDto;
import com.programacion4.unidad4ej5.feature.plan.dtos.request.PlanCreateRequestDto;
import com.programacion4.unidad4ej5.feature.plan.dtos.response.PlanResponseDto;
import com.programacion4.unidad4ej5.feature.plan.mappers.PlanMapper;
import com.programacion4.unidad4ej5.feature.plan.repository.PlanRepository;
import com.programacion4.unidad4ej5.feature.socio.domain.Socio;
import com.programacion4.unidad4ej5.feature.socio.repository.SocioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanService implements IPlanService {

    private final PlanRepository planRepository;
    private final SocioRepository socioRepository;

    @Override
    public PlanResponseDto crearPlan(PlanCreateRequestDto request) {
        // 1. Verificar que el Socio existe
        Socio socio = socioRepository.findById(request.getSocioId())
                .orElseThrow(() -> new IllegalArgumentException("No existe un socio con el ID: " + request.getSocioId()));

        // 2. Crear la entidad Plan
        PlanEntrenamiento plan = new PlanEntrenamiento();
        plan.setObjetivo(request.getObjetivo());
        plan.setFrecuenciaSemanal(request.getFrecuenciaSemanal());
        plan.setPesoInicial(request.getPesoInicial());
        plan.setAltura(request.getAltura());
        plan.setSocio(socio);


        for (EjercicioPlanDto ejDto : request.getEjercicios()) {
            Ejercicio ejercicio = new Ejercicio();
            ejercicio.setNombre(ejDto.getNombre());
            ejercicio.setSeries(ejDto.getSeries());
            ejercicio.setRepeticiones(ejDto.getRepeticiones());

            plan.agregarEjercicio(ejercicio);
        }


        PlanEntrenamiento planGuardado = planRepository.save(plan);


        return PlanMapper.toResponseDto(planGuardado);
    }
}
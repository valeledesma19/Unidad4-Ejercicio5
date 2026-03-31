package com.programacion4.unidad4ej5.feature.plan.services;

import com.programacion4.unidad4ej5.feature.plan.dtos.request.PlanCreateRequestDto;
import com.programacion4.unidad4ej5.feature.plan.dtos.response.PlanResponseDto;

public interface IPlanService {
    PlanResponseDto crearPlan(PlanCreateRequestDto request);
}
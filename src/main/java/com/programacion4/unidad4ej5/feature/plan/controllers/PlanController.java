package com.programacion4.unidad4ej5.feature.plan.controllers;

import com.programacion4.unidad4ej5.feature.plan.dtos.request.PlanCreateRequestDto;
import com.programacion4.unidad4ej5.feature.plan.dtos.response.PlanResponseDto;
import com.programacion4.unidad4ej5.feature.plan.services.IPlanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/planes")
@RequiredArgsConstructor
public class PlanController {

    private final IPlanService planService;

    @PostMapping
    public ResponseEntity<PlanResponseDto> crearPlan(@Valid @RequestBody PlanCreateRequestDto request) {
        PlanResponseDto response = planService.crearPlan(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
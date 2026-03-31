package com.programacion4.unidad4ej5.feature.socio.controller;

import com.programacion4.unidad4ej5.feature.socio.dtos.request.SocioCreateRequestDto;
import com.programacion4.unidad4ej5.feature.socio.dtos.response.SocioResponseDto;
import com.programacion4.unidad4ej5.feature.socio.service.ISocioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socios")
@RequiredArgsConstructor
public class SocioController {

    private final ISocioService socioService;

    @PostMapping
    public ResponseEntity<SocioResponseDto> crearSocio(@Valid @RequestBody SocioCreateRequestDto request) {
        SocioResponseDto response = socioService.create(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
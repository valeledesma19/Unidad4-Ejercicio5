package com.programacion4.unidad4ej5.feature.socio.controller;

import com.programacion4.unidad4ej5.feature.socio.dtos.request.SocioCreateRequestDto;
import com.programacion4.unidad4ej5.feature.socio.dtos.request.SocioUpdateDto;
import com.programacion4.unidad4ej5.feature.socio.dtos.response.SocioResponseDto;
import com.programacion4.unidad4ej5.feature.socio.service.ISocioService;
import com.programacion4.unidad4ej5.shared.validation.OnUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    @PutMapping("/perfil")
    public ResponseEntity<?> actualizarPerfil(@Validated(OnUpdate.class) @RequestBody SocioUpdateDto request) {
        // Llama a tu servicio de socio
        var response = socioService.actualizarPerfil(request);
        return ResponseEntity.ok(response);
    }
}
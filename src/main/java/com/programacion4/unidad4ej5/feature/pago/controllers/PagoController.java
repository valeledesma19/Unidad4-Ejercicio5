package com.programacion4.unidad4ej5.feature.pago.controllers;

import com.programacion4.unidad4ej5.feature.pago.dtos.request.PagoRequestDto;
import com.programacion4.unidad4ej5.feature.pago.dtos.response.PagoResponseDto;
import com.programacion4.unidad4ej5.feature.pago.services.IPagoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final IPagoService pagoService;

    @PostMapping
    public ResponseEntity<PagoResponseDto> registrarPago(@Valid @RequestBody PagoRequestDto request) {
        PagoResponseDto response = pagoService.registrarPago(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
package com.programacion4.unidad4ej5.feature.pago.services;

import com.programacion4.unidad4ej5.feature.pago.dtos.request.PagoRequestDto;
import com.programacion4.unidad4ej5.feature.pago.dtos.response.PagoResponseDto;

public interface IPagoService {
    PagoResponseDto registrarPago(PagoRequestDto request);
}
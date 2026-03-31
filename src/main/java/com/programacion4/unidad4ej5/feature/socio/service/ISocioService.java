package com.programacion4.unidad4ej5.feature.socio.service;

import com.programacion4.unidad4ej5.feature.socio.dtos.request.SocioCreateRequestDto;
import com.programacion4.unidad4ej5.feature.socio.dtos.request.SocioUpdateDto;
import com.programacion4.unidad4ej5.feature.socio.dtos.response.SocioResponseDto;

public interface ISocioService {
    SocioResponseDto create(SocioCreateRequestDto request);

    Object actualizarPerfil(SocioUpdateDto request);
}
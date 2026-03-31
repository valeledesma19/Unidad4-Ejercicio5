package com.programacion4.unidad4ej5.feature.socio.service;

import com.programacion4.unidad4ej5.feature.socio.domain.Socio;
import com.programacion4.unidad4ej5.feature.socio.dtos.request.SocioCreateRequestDto;
import com.programacion4.unidad4ej5.feature.socio.dtos.response.SocioResponseDto;
import com.programacion4.unidad4ej5.feature.socio.mappers.SocioMapper;
import com.programacion4.unidad4ej5.feature.socio.repository.SocioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
public class SocioService implements ISocioService {

    private final SocioRepository socioRepository;

    @Override
    public SocioResponseDto create(SocioCreateRequestDto request) {

        // Validar que no exista el DNI (Cambiamos ResourceConflictException por IllegalArgumentException)
        if (socioRepository.existsByDni(request.getDni())) {
            throw new IllegalArgumentException("Ya existe un socio con el DNI: " + request.getDni());
        }

        // Validar que tenga al menos 18 años
        if (!esMayorDeEdad(request.getFechaNacimiento())) {
            throw new IllegalArgumentException("El socio debe ser mayor de 18 años");
        }

        Socio socio = SocioMapper.toEntity(request);
        socio.setEstaEliminado(false);

        Socio socioGuardado = socioRepository.save(socio);

        return SocioMapper.toResponseDto(socioGuardado);
    }

    private boolean esMayorDeEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }
}
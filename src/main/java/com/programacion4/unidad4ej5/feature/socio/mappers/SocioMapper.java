package com.programacion4.unidad4ej5.feature.socio.mappers;

import com.programacion4.unidad4ej5.feature.socio.domain.Socio;
import com.programacion4.unidad4ej5.feature.socio.dtos.request.SocioCreateRequestDto;
import com.programacion4.unidad4ej5.feature.socio.dtos.response.SocioResponseDto;

public class SocioMapper {

    // Convierte el DTO de creación (Request) a Entidad
    public static Socio toEntity(SocioCreateRequestDto dto) {
        Socio socio = new Socio();
        socio.setNombre(dto.getNombre());
        socio.setApellido(dto.getApellido());
        socio.setEmail(dto.getEmail());
        socio.setDni(dto.getDni());
        socio.setFechaNacimiento(dto.getFechaNacimiento());
        socio.setTelefono(dto.getTelefono());
        return socio;
    }

    // Convierte la Entidad al DTO de Respuesta
    public static SocioResponseDto toResponseDto(Socio entity) {
        SocioResponseDto dto = new SocioResponseDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setApellido(entity.getApellido());
        dto.setEmail(entity.getEmail());
        dto.setDni(entity.getDni());
        dto.setFechaNacimiento(entity.getFechaNacimiento());
        dto.setTelefono(entity.getTelefono());
        return dto;
    }
}
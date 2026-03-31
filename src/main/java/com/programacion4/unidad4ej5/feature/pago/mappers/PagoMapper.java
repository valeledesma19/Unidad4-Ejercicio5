package com.programacion4.unidad4ej5.feature.pago.mappers;

import com.programacion4.unidad4ej5.feature.pago.domain.Pago;
import com.programacion4.unidad4ej5.feature.pago.dtos.response.PagoResponseDto;

public class PagoMapper {

    public static PagoResponseDto toResponseDto(Pago entity) {
        PagoResponseDto dto = new PagoResponseDto();
        dto.setId(entity.getId());

        if (entity.getSocio() != null) {
            dto.setSocioId(entity.getSocio().getId());
            dto.setNombreSocio(entity.getSocio().getNombre() + " " + entity.getSocio().getApellido());
        }

        dto.setMonto(entity.getMonto());
        dto.setCodigoTransaccion(entity.getCodigoTransaccion());
        dto.setFechaVencimiento(entity.getFechaVencimiento());
        dto.setTipoPago(entity.getTipoPago());

        return dto;
    }
}
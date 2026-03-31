package com.programacion4.unidad4ej5.feature.pago.services;

import com.programacion4.unidad4ej5.feature.pago.domain.Pago;
import com.programacion4.unidad4ej5.feature.pago.dtos.request.PagoRequestDto;
import com.programacion4.unidad4ej5.feature.pago.dtos.response.PagoResponseDto;
import com.programacion4.unidad4ej5.feature.pago.mappers.PagoMapper;
import com.programacion4.unidad4ej5.feature.pago.repository.PagoRepository;
import com.programacion4.unidad4ej5.feature.socio.domain.Socio;
import com.programacion4.unidad4ej5.feature.socio.repository.SocioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagoService implements IPagoService {

    private final PagoRepository pagoRepository;
    private final SocioRepository socioRepository;

    @Override
    public PagoResponseDto registrarPago(PagoRequestDto request) {

        Socio socio = socioRepository.findById(request.getSocioId())
                .orElseThrow(() -> new IllegalArgumentException("No existe un socio con el ID: " + request.getSocioId()));

        Pago pago = new Pago();
        pago.setMonto(request.getMonto());
        pago.setCodigoTransaccion(request.getCodigoTransaccion());
        pago.setFechaVencimiento(request.getFechaVencimiento());
        pago.setTipoPago(request.getTipoPago());
        pago.setSocio(socio);
        Pago pagoGuardado = pagoRepository.save(pago);

        return PagoMapper.toResponseDto(pagoGuardado);
    }
}
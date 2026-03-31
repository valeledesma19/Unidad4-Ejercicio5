package com.programacion4.unidad4ej5.feature.pago.dtos.response;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PagoResponseDto {
    private Long id;
    private Long socioId;
    private String nombreSocio;
    private BigDecimal monto;
    private String codigoTransaccion;
    private LocalDate fechaVencimiento;
    private String tipoPago;
}
package com.programacion4.unidad4ej5.feature.pago.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PagoRequestDto {

    @NotNull(message = "El ID del socio es obligatorio")
    private Long socioId;

    @NotNull(message = "El monto es obligatorio")
    @DecimalMin(value = "1000.00", message = "El monto no puede ser menor a 1000.00")
    @Digits(integer = 8, fraction = 2, message = "El monto debe tener máximo 2 decimales")
    private BigDecimal monto;

    @NotBlank(message = "El código de transacción es obligatorio")
    @Pattern(regexp = "^PAY-[A-Z0-9]{4}-[A-Z0-9]{4}$", message = "El código debe seguir el patrón PAY-XXXX-XXXX (X = mayúsculas o números)")
    private String codigoTransaccion;

    @NotNull(message = "La fecha de vencimiento es obligatoria")
    @Future(message = "La fecha de vencimiento debe ser una fecha en el futuro")
    private LocalDate fechaVencimiento;

    @NotBlank(message = "El tipo de pago es obligatorio")
    @Pattern(regexp = "^(EFECTIVO|DEBITO|CREDITO|TRANSFERENCIA)$", message = "Tipo de pago inválido. Solo se acepta: EFECTIVO, DEBITO, CREDITO, TRANSFERENCIA")
    private String tipoPago;
}
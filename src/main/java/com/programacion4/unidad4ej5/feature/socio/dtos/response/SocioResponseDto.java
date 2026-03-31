package com.programacion4.unidad4ej5.feature.socio.dtos.response;

import lombok.Data;
import java.time.LocalDate;

@Data
public class SocioResponseDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private LocalDate fechaNacimiento;
    private String telefono;
}
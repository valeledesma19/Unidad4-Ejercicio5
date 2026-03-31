package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import com.programacion4.unidad4ej5.shared.validation.OnCreate;
import com.programacion4.unidad4ej5.shared.validation.OnUpdate;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;
import lombok.Data;

@Data
public class SocioUpdateDto {


    @Null(groups = OnCreate.class, message = "El ID debe ser nulo en la creación")
    @NotNull(groups = OnUpdate.class, message = "El ID del socio es obligatorio en la actualización")
    private Long id;

    private String telefono;
    private String email;


    @URL(message = "La URL de la foto debe ser un enlace válido")
    private String urlFoto;


    @Size(min = 3, max = 15, message = "El alias debe tener entre 3 y 15 caracteres")
    @Pattern(regexp = "^[^\\s]+$", message = "El alias no puede contener espacios")
    private String alias;
}
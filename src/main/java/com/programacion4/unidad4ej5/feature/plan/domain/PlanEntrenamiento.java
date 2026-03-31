package com.programacion4.unidad4ej5.feature.plan.domain;

import com.programacion4.unidad4ej5.feature.socio.domain.Socio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "planes_entrenamiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanEntrenamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String objetivo;
    private Integer frecuenciaSemanal;
    private Double pesoInicial;
    private Double altura;

    // Relación con el Socio (Muchos planes pueden pertenecer a un socio a lo largo del tiempo)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "socio_id")
    private Socio socio;

    // Relación con los ejercicios: si se borra el plan, se borran sus ejercicios (CascadeType.ALL)
    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ejercicio> ejercicios = new ArrayList<>();

    // Método fundamental para vincular ambas tablas correctamente antes de guardar
    public void agregarEjercicio(Ejercicio ejercicio) {
        ejercicios.add(ejercicio);
        ejercicio.setPlan(this);
    }
}
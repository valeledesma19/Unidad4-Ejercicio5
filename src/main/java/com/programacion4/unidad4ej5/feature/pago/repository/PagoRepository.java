package com.programacion4.unidad4ej5.feature.pago.repository;

import com.programacion4.unidad4ej5.feature.pago.domain.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
}
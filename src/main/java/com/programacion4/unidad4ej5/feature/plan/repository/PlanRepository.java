package com.programacion4.unidad4ej5.feature.plan.repository;

import com.programacion4.unidad4ej5.feature.plan.domain.PlanEntrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntrenamiento, Long> {
}
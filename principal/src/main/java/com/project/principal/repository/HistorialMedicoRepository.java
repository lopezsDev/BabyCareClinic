package com.project.principal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.principal.models.HistorialMedicoModel;

@Repository
public interface HistorialMedicoRepository extends JpaRepository<HistorialMedicoModel, Long> {
}

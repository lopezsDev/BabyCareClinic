package com.project.principal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.principal.models.Pacientes;

@Repository
public interface PacienteRepository extends JpaRepository<Pacientes, Long> {
}

package com.project.principal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.principal.models.PacienteModel;

/**
 * This interface defines a repository for accessing and managing PacienteModel entities.
 */
@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel, Long> {
}

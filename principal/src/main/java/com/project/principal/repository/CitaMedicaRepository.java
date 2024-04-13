package com.project.principal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.principal.models.CitaMedicaModel;
/**
 * Repository interface for managing medical appointments.
 * This interface extends JpaRepository, providing basic CRUD operations for the CitaMedicaModel entity.
 *
 * @author [lopezs.dev]
 * @version [1.1]
 */
@Repository
public interface CitaMedicaRepository extends JpaRepository<CitaMedicaModel, Long> {
}



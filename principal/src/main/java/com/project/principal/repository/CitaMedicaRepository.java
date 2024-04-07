package com.project.principal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.principal.models.CitaMedicaModel;

@Repository
public interface CitaMedicaRepository extends JpaRepository<CitaMedicaModel, Long> {
}


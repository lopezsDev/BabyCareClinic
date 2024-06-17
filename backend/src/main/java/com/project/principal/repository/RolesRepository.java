package com.project.principal.repository;

import com.project.principal.models.RolModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<RolModel, Long> {
    Optional<RolModel> findByName(String name);
}

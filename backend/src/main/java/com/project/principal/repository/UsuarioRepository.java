package com.project.principal.repository;

import com.project.principal.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for managing user data in the database.
 *
 * @author LopezS7
 */
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    Optional<UsuarioModel> findByNombre(String nombre);
    Boolean existsByNombre(String nombre);
}

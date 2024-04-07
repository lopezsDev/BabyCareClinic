package com.project.principal.repository;

import java.util.Optional;
import com.project.principal.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByNombre(String nombreUsuario);
}
